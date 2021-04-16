package br.edu.ifma.si.lpw.imobiliaria.controller;

import br.edu.ifma.si.lpw.imobiliaria.model.Cliente;
import br.edu.ifma.si.lpw.imobiliaria.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes")
    public List<Cliente> listaCliente() {
        return clienteRepository.findAll();
    }
}