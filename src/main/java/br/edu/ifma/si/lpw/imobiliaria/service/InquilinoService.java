package br.edu.ifma.si.lpw.imobiliaria.service;

import br.edu.ifma.si.lpw.imobiliaria.model.Inquilino;
import br.edu.ifma.si.lpw.imobiliaria.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InquilinoService {
    private final InquilinoRepository inquilinoRepository;

    @Autowired
    public InquilinoService(InquilinoRepository inquilinoRepository) {
        this.inquilinoRepository = inquilinoRepository;
    }

    public Page<Inquilino> buscaCom(Pageable paginacao) {
        return inquilinoRepository.findAll(paginacao);
    }

    public Page<Inquilino> buscaPor(String nome, Pageable paginacao) {
        return inquilinoRepository.findByNomeContaining(nome, paginacao);
    }

    public Optional<Inquilino> buscaPor(Integer id) {
        return inquilinoRepository.findById(id);
    }

    @Transactional
    public Inquilino salva(Inquilino inquilino) {
        return inquilinoRepository.save(inquilino);
    }


    @Transactional
    public void removePor(Integer id) {
        inquilinoRepository.deleteById(id);
    }
}