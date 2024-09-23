package com.pedidos.processar.pedidos.repository;

import com.pedidos.processar.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    List<Pedido> findByCodigoCliente(Long clienteId);
}
