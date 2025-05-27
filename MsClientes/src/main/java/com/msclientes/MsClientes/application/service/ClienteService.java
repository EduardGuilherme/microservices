package com.msclientes.MsClientes.application.service;

import com.msclientes.MsClientes.domain.Cliente;
import com.msclientes.MsClientes.infra.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private  final ClienteRepository repository;


    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cliente save (Cliente cliente){
        return repository.save(cliente);
    }
    public Optional<Cliente> getbyCPF(String cpf){
        return repository.findByCpf(cpf);
    }
}
