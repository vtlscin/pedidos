package com.pedidos.processar.pedidos.repository;

import com.pedidos.processar.pedidos.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findAllByPedidoId(Long id);
}
