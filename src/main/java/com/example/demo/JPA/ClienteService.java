package com.example.demo.JPA;

import com.example.demo.dominio.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }
}
