package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.repository.ImovelRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImovelController {
    private final ImovelRepository imovelRepository;

    public ImovelController(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }
}
