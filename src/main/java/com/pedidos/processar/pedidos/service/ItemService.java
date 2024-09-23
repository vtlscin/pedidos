package com.pedidos.processar.pedidos.service;

import com.pedidos.processar.pedidos.model.Item;
import com.pedidos.processar.pedidos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    public ItemRepository itemRepository;

    public Item retornaItemPorId(Long id){
        return itemRepository.findById(id).orElseThrow();
    }

}
