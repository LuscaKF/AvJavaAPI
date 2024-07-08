package br.com.lkf.ControlContacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lkf.ControlContacts.dto.MalaDiretaDTO;
import br.com.lkf.ControlContacts.model.Pessoa;
import br.com.lkf.ControlContacts.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@Tag(name = "Pessoa", description = "API para gerenciamento de Pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    @Operation(summary = "Cria uma nova Pessoa")
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados de uma Pessoa por ID")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        return pessoaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Lista todas as Pessoas")
    public List<Pessoa> getAllPessoas() {
        return pessoaService.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma Pessoa existente por ID")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        if (!pessoaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(id);
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @Operation(summary = "Remove uma Pessoa por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        if (!pessoaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/maladireta/{id}")
    @Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta")
    public ResponseEntity<MalaDiretaDTO> getMalaDiretaById(@PathVariable Long id) {
        return pessoaService.findById(id)
                .map(pessoa -> {
                    String malaDireta = String.format("%s, %s – CEP: %s – %s/%s",
                            pessoa.getEndereco(), pessoa.getCidade(), pessoa.getCep(), pessoa.getUf());
                    MalaDiretaDTO dto = new MalaDiretaDTO(pessoa.getId(), pessoa.getNome(), malaDireta);
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
