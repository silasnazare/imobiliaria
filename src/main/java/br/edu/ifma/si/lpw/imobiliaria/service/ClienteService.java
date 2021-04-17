package br.edu.ifma.si.lpw.imobiliaria.service;

import br.edu.ifma.si.lpw.imobiliaria.model.Cliente;
import br.edu.ifma.si.lpw.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscaPor(Integer id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscaPor(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


    @Transactional
    public void removePor(Integer id) {
        clienteRepository.deleteById(id);
    }
}