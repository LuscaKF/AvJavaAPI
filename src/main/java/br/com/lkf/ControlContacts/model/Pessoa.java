package br.com.lkf.ControlContacts.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da Pessoa", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Nome da Pessoa", example = "João Silva")
    private String nome;

    @Schema(description = "Endereço da Pessoa", example = "Rua A, 123")
    private String endereco;

    @Schema(description = "CEP da Pessoa", example = "12345-678")
    private String cep;

    @Schema(description = "Cidade da Pessoa", example = "São Paulo")
    private String cidade;

    @Schema(description = "UF da Pessoa", example = "SP")
    private String uf;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de Contatos da Pessoa")
    private List<Contato> contatos = new ArrayList<>();

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
