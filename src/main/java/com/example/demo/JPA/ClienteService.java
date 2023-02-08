package com.example.demo.JPA;

import com.example.demo.dominio.Cliente;
import com.example.demo.exception.ClienteBadRequestException;
import com.example.demo.exception.ClienteNotFoundException;
import org.springframework.beans.BeanUtils;
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

    public List<Cliente> listaPeloNome(String nome){
        return clienteRepository.consultaPeloNome(nome);
    }

    public Cliente buscarPeloId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(ClienteNotFoundException::new);
    }

    public Cliente adicionar(Cliente cliente){
        if(clienteRepository.existsByCpf(cliente.getCpf())){
            throw new ClienteBadRequestException();
        }
        return clienteRepository.save(cliente);
    }

    public Cliente alterar(Long id, Cliente cliente){
        Cliente clienteAtual = buscarPeloId(id);
        BeanUtils.copyProperties(cliente, clienteAtual, "id");
        return clienteRepository.save(clienteAtual);
    }

    public void deletar(Long id){
        buscarPeloId(id);
        clienteRepository.deleteById(id);
    }
}
