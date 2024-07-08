package br.com.lkf.ControlContacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.lkf.ControlContacts.model.Contato;
import br.com.lkf.ControlContacts.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@Tag(name = "Contato", description = "API para gerenciamento de Contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @Operation(summary = "Adiciona um novo Contato a uma Pessoa")
    public Contato createContato(@RequestBody @Valid Contato contato) {
        return contatoService.save(contato);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados de um Contato por ID")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        return contatoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{idPessoa}")
    @Operation(summary = "Lista todos os Contatos de uma Pessoa")
    public List<Contato> getContatosByPessoaId(@PathVariable Long idPessoa) {
        return contatoService.findByPessoaId(idPessoa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Contato existente por ID")
    public ResponseEntity<Contato> updateContato(@PathVariable Long id, @RequestBody @Valid Contato contato) {
        if (!contatoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contato.setId(id);
        return ResponseEntity.ok(contatoService.save(contato));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um Contato por ID")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
        if (!contatoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
