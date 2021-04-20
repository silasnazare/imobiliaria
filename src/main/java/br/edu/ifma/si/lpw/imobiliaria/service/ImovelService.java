package br.edu.ifma.si.lpw.imobiliaria.service;

import br.edu.ifma.si.lpw.imobiliaria.model.Imovel;
import br.edu.ifma.si.lpw.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ImovelService {
    private final ImovelRepository imovelRepository;

    @Autowired
    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public Page<Imovel> buscaCom(Pageable paginacao) {
        return imovelRepository.findAll(paginacao);
    }

    public Page<Imovel> buscaPor(String endereco, Pageable paginacao) {
        return imovelRepository.findByEnderecoContaining(endereco, paginacao);
    }

    public Optional<Imovel> buscaPor(Integer id) {
        return imovelRepository.findById(id);
    }

    @Transactional
    public Imovel salva(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    @Transactional
    public void removePor(Integer id) {
        imovelRepository.deleteById(id);
    }
}
