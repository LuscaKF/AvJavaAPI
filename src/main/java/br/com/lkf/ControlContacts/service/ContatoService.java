package br.com.lkf.ControlContacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lkf.ControlContacts.model.Contato;
import br.com.lkf.ControlContacts.repository.ContatoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> findByPessoaId(Long pessoaId) {
        return contatoRepository.findByPessoaId(pessoaId);
    }

    public void deleteById(Long id) {
        contatoRepository.deleteById(id);
    }
}
