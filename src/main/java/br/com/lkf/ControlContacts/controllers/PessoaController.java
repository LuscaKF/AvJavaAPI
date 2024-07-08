package br.com.lkf.ControlContacts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lkf.ControlContacts.model.Pessoa;
import br.com.lkf.ControlContacts.repository.PessoaRepository;
import br.com.lkf.ControlContacts.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
@Tag(name = "Pessoa", description = "API para gerenciamento de Pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    
    private final PessoaRepository pessoaRepository;
    
    @Autowired
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

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
    
    @GetMapping("/{id}/malaDireta")
    @Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta")
    public ResponseEntity<String> getMalaDiretaById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if (pessoa.isPresent()) {
            Pessoa p = pessoa.get();
            String malaDireta = String.format("Nome: %s, Endereço: %s, CEP: %s, Cidade: %s, UF: %s",
                    p.getNome(), p.getEndereco(), p.getCep(), p.getCidade(), p.getUf());
            return ResponseEntity.ok(malaDireta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
