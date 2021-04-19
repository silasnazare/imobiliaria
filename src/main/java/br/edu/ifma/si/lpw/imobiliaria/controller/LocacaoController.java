package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Locacao;
import br.edu.ifma.si.lpw.imobiliaria.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    private final LocacaoService locacaoService;

    @Autowired
    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping
    public Page<Locacao> locacoes(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 3) Pageable paginacao) {
        return locacaoService.buscaCom(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> buscaPor(@PathVariable Integer id) {
        Optional<Locacao> locacaoOptional = locacaoService.buscaPorId(id);
        if (locacaoOptional.isPresent()) {
            return ResponseEntity.ok(locacaoOptional.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Locacao> salva(@RequestBody @Valid Locacao locacao, UriComponentsBuilder builder) {
        final Locacao locacaoSalva = locacaoService.salva(locacao);
        final URI uri = builder.path("/locacoes/{id}").buildAndExpand(locacaoSalva.getId()).toUri();
        return ResponseEntity.created(uri).body(locacaoSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locacao> atualiza(@PathVariable Integer id, @RequestBody @Valid Locacao locacao) {
        Optional<Locacao> locacaoOptional = locacaoService.buscaPorId(id);
        if (locacaoOptional.isPresent()) {
            locacao.setId(id);
            Locacao locacaoAtualizada = locacaoService.salva(locacao);
            return ResponseEntity.ok(locacaoAtualizada);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
