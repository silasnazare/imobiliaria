package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Inquilino;
import br.edu.ifma.si.lpw.imobiliaria.service.InquilinoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {
    private final InquilinoService inquilinoService;

    @Autowired
    public InquilinoController(InquilinoService inquilinoService) {
        this.inquilinoService = inquilinoService;
    }

    @GetMapping
    public Page<Inquilino> inquilinos(@RequestParam(required = false) String nome, @PageableDefault
            (sort = "id", direction = Sort.Direction.ASC, page = 0, size = 3) Pageable paginacao) {
        if (nome == null) {
            Page<Inquilino> inquilinoPage = inquilinoService.buscaCom(paginacao);
            return inquilinoPage;
        }
        else {
            Page<Inquilino> inquilinoPage = inquilinoService.buscaPor(nome, paginacao);
            return inquilinoPage;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inquilino> buscaPor(@PathVariable Integer id) {
        Optional<Inquilino> inquilinoOptional = inquilinoService.buscaPor(id);
        if (inquilinoOptional.isPresent()) {
            return ResponseEntity.ok(inquilinoOptional.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Inquilino> salva(@RequestBody @Valid Inquilino inquilino, UriComponentsBuilder builder) {
        final Inquilino inquilinoSalvo = inquilinoService.salva(inquilino);
        final URI uri = builder.path("/inquilinos/{id}").buildAndExpand(inquilinoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(inquilinoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inquilino> atualiza(@PathVariable Integer id, @RequestBody @Valid Inquilino inquilino) {
        Optional<Inquilino> inquilinoOptional = inquilinoService.buscaPor(id);
        if (inquilinoOptional.isPresent()) {
            inquilino.setId(id);
            Inquilino inquilinoAtualizado = inquilinoService.salva(inquilino);
            return ResponseEntity.ok(inquilinoAtualizado);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Inquilino> atualizaParcialmente(@PathVariable Integer id, @RequestBody Map<String, Object> campos) {
        Optional<Inquilino> inquilinoOptional = inquilinoService.buscaPor(id);
        if (inquilinoOptional.isPresent()) {
            Inquilino inquilinoAtual = inquilinoOptional.get();
            merge(campos, inquilinoAtual);
            return this.atualiza(id, inquilinoAtual);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void merge(Map<String, Object> campos, Inquilino inquilinoDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Inquilino inquilinoOrigem = objectMapper.convertValue(campos, Inquilino.class);
        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Inquilino.class, nomePropriedade);
            field.setAccessible(true);
            Object novoValor = ReflectionUtils.getField(field, inquilinoOrigem);
            ReflectionUtils.setField(field, inquilinoDestino, novoValor);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        Optional<Inquilino> inquilinoOptional = inquilinoService.buscaPor(id);
        if (inquilinoOptional.isPresent()) {
            inquilinoService.removePor(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}