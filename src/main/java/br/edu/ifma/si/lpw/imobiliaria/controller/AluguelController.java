package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Aluguel;
import br.edu.ifma.si.lpw.imobiliaria.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    private final AluguelService aluguelService;

    @Autowired
    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public Page<Aluguel> alugueis(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 3)Pageable paginacao) {
        return aluguelService.buscaCom(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscaPor(@PathVariable Integer id) {
        Optional<Aluguel> aluguelOptional = aluguelService.buscaPor(id);
        if (aluguelOptional.isPresent()) {
            return ResponseEntity.ok(aluguelOptional.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
