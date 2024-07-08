package br.com.lkf.ControlContacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.lkf.ControlContacts.model.Contato;
import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByPessoaId(Long pessoaId);
}
