package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocacaoController {
    private final LocacaoService locacaoService;

    @Autowired
    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }
}
