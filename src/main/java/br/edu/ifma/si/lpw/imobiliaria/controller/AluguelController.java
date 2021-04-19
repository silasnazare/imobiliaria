package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Aluguel;
import br.edu.ifma.si.lpw.imobiliaria.service.AluguelService;
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

    @PostMapping
    public ResponseEntity<Aluguel> salva(@RequestBody @Valid Aluguel aluguel, UriComponentsBuilder builder) {
        final Aluguel aluguelSalvo = aluguelService.salva(aluguel);
        final URI uri = builder.path("/alugueis/{id}").buildAndExpand(aluguelSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(aluguelSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> atualiza(@PathVariable Integer id, @RequestBody @Valid Aluguel aluguel) {
        Optional<Aluguel> aluguelOptional = aluguelService.buscaPor(id);
        if (aluguelOptional.isPresent()) {
            aluguel.setId(id);
            Aluguel aluguelAtualizado = aluguelService.salva(aluguel);
            return ResponseEntity.ok(aluguelAtualizado);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Aluguel> atualizaParcialmente(@PathVariable Integer id, @RequestBody Map<String, Object> campos) {
        Optional<Aluguel> aluguelOptional = aluguelService.buscaPor(id);
        if (aluguelOptional.isPresent()) {
            Aluguel aluguelAtual = aluguelOptional.get();
            merge(campos, aluguelAtual);
            return this.atualiza(id, aluguelAtual);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void merge(Map<String, Object> campos, Aluguel aluguelDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Aluguel aluguelOrigem = objectMapper.convertValue(campos, Aluguel.class);
        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Aluguel.class, nomePropriedade);
            field.setAccessible(true);
            Object novoValor = ReflectionUtils.getField(field, aluguelOrigem);
            ReflectionUtils.setField(field, aluguelDestino, novoValor);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        Optional<Aluguel> aluguelOptional = aluguelService.buscaPor(id);
        if (aluguelOptional.isPresent()) {
            aluguelService.removePor(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
