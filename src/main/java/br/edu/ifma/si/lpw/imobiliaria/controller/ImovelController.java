package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Imovel;
import br.edu.ifma.si.lpw.imobiliaria.service.ImovelService;
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
@RequestMapping("/imoveis")
public class ImovelController {
    private final ImovelService imovelService;

    @Autowired
    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @GetMapping
    public Page<Imovel> imoveis(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 3) Pageable paginacao) {
           return imovelService.buscaCom(paginacao);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscaPor(@PathVariable Integer id) {
        Optional<Imovel> imovelOptional = imovelService.buscaPor(id);
        if (imovelOptional.isPresent()) {
            return ResponseEntity.ok(imovelOptional.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Imovel> salva(@RequestBody @Valid Imovel imovel, UriComponentsBuilder builder) {
        final Imovel imovelSalvo = imovelService.salva(imovel);
        final URI uri = builder.path("/imoveis/{id}").buildAndExpand(imovelSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(imovelSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> atualiza(@PathVariable Integer id, @RequestBody @Valid Imovel imovel) {
        Optional<Imovel> imovelOptional = imovelService.buscaPor(id);
        if (imovelOptional.isPresent()) {
            imovel.setId(id);
            Imovel imovelAtualizado = imovelService.salva(imovel);
            return ResponseEntity.ok(imovelAtualizado);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Imovel> atualizaParcialmente(@PathVariable Integer id, @RequestBody Map<String, Object> campos) {
        Optional<Imovel> optional = imovelService.buscaPor(id);
        if (optional.isPresent()) {
            Imovel imovelAtual = optional.get();
            merge(campos, imovelAtual);
            return this.atualiza(id, imovelAtual);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void merge(Map<String, Object> campos, Imovel imovelDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Imovel imovelOrigem = objectMapper.convertValue(campos, Imovel.class);
        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Imovel.class, nomePropriedade);
            field.setAccessible(true);
            Object novoValor = ReflectionUtils.getField(field, imovelOrigem);
            ReflectionUtils.setField(field, imovelDestino, novoValor);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        Optional<Imovel> imovelOptional = imovelService.buscaPor(id);
        if (imovelOptional.isPresent()) {
            imovelService.removePor(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
