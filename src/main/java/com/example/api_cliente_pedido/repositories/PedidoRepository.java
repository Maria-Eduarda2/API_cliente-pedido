package com.example.api_cliente_pedido.repositories;

import com.example.api_cliente_pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional porem recomendado
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}