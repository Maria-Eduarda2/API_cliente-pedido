package com.example.api_cliente_pedido.repositories;

import com.example.api_cliente_pedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Opcional, mas recomendado para clareza
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Métodos básicos (save, findById, findAll, delete) são herdados!
}
