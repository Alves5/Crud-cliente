package com.example.demo.JPA;

import com.example.demo.dominio.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/jpa/clientes")
public class ClienteJPAController {

    private ClienteService clienteService;

    public ClienteJPAController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> lista(){
        return clienteService.lista();
    }
}
