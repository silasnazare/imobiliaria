package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.repository.AluguelRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AluguelController {
    private final AluguelRepository aluguelRepository;

    public AluguelController(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }
}
