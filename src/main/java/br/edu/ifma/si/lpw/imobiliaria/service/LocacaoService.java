package br.edu.ifma.si.lpw.imobiliaria.service;

import br.edu.ifma.si.lpw.imobiliaria.model.Locacao;
import br.edu.ifma.si.lpw.imobiliaria.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    @Autowired
    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public Page<Locacao> buscaCom(Pageable paginacao) {
        return locacaoRepository.findAll(paginacao);
    }

    public Optional<Locacao> buscaPorId(Integer id) {
        return locacaoRepository.findById(id);
    }

    @Transactional
    public Locacao salva(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    @Transactional
    public void removePor(Integer id) {
        locacaoRepository.deleteById(id);
    }
}
