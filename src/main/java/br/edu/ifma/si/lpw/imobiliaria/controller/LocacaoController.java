package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.repository.LocacaoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocacaoController {
    private final LocacaoRepository locacaoRepository;

    public LocacaoController(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }
}
