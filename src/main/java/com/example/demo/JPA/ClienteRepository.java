package com.example.demo.JPA;

import com.example.demo.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);

    @Query("FROM Cliente WHERE nome LIKE %:nome%")
    List<Cliente> consultaPeloNome(String nome);
}
