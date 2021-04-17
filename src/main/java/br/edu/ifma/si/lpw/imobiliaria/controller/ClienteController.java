package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Cliente;
import br.edu.ifma.si.lpw.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> clientes(String nome) {
        System.out.println("############ " + nome);
        if (nome == null)
            return clienteService.todos();
        else
            return clienteService.buscaPor(nome);
    }

    @GetMapping("/{id}")
    public Cliente buscaPor(@PathVariable Integer id) {
        return clienteService.buscaPor(id).get();
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
        final Cliente clienteSalvo = clienteService.salva(cliente);
        final URI uri = builder.path("/clientes/{id}").buildAndExpand(clienteSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Optional<Cliente> optional = clienteService.buscaPor(id);

        if (optional.isPresent()) {
            Cliente clienteAtualizado = clienteService.salva(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}