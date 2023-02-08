package com.example.demo.JPA;

import com.example.demo.dominio.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nome")
    public List<Cliente> listaPeloNome(String nome){
        return clienteService.listaPeloNome(nome);
    }

    @GetMapping("/{id}")
    public Cliente buscarPeloId(@PathVariable Long id){
        return clienteService.buscarPeloId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Validated @RequestBody Cliente cliente){
        return clienteService.adicionar(cliente);
    }

    @PutMapping ("/{id}")
    public Cliente alterar(@PathVariable Long id, @Validated @RequestBody Cliente cliente){
        return clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }
}
