package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AluguelController {
    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }
}
