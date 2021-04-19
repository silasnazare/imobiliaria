package br.edu.ifma.si.lpw.imobiliaria.service;

import br.edu.ifma.si.lpw.imobiliaria.model.Aluguel;
import br.edu.ifma.si.lpw.imobiliaria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AluguelService {
    private final AluguelRepository aluguelRepository;

    @Autowired
    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Page<Aluguel> buscaCom(Pageable paginacao) {
        return aluguelRepository.findAll(paginacao);
    }

    public Optional<Aluguel> buscaPor(Integer id) {
        return aluguelRepository.findById(id);
    }

    @Transactional
    public Aluguel salva(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Transactional
    public void removePor(Integer id) {
        aluguelRepository.deleteById(id);
    }
}
