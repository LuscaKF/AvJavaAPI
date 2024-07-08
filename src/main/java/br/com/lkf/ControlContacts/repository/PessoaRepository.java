package br.com.lkf.ControlContacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lkf.ControlContacts.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
