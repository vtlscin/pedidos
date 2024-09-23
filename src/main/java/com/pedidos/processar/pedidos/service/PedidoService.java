package com.pedidos.processar.pedidos.service;

import com.pedidos.processar.pedidos.dto.PedidoDTO;
import com.pedidos.processar.pedidos.dto.RetornoClienteDTO;
import com.pedidos.processar.pedidos.model.Item;
import com.pedidos.processar.pedidos.model.Pedido;
import com.pedidos.processar.pedidos.repository.ItemRepository;
import com.pedidos.processar.pedidos.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ItemRepository itemRepository;

    private ModelMapper mapper;

    public PedidoService(PedidoRepository pedidoRepository, ItemRepository itemRepository, ModelMapper mapper) {
        this.pedidoRepository = pedidoRepository;
        this.itemRepository = itemRepository;
        this.mapper = mapper;
        this.mapper.typeMap(Pedido.class,PedidoDTO.class).addMapping(Pedido::valorTotalPedido,PedidoDTO::setValorTotal);
    }

    public void salvarPedido(PedidoDTO pedidoDTO){
        Pedido pedido = mapper.map(pedidoDTO, Pedido.class);
        pedido.atualizaItens(pedido.getItensPedido());
        pedidoRepository.save(pedido);
    }

    public RetornoClienteDTO listaPedidosCliente(Long codigoCliente) throws Exception {
        List<Pedido> pedidos = pedidoRepository.findByCodigoCliente(codigoCliente);
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();
        if(Objects.nonNull(pedidos) && !pedidos.isEmpty()){
            preencheItems(pedidos, pedidoDTOS);
        }
        return new RetornoClienteDTO(pedidoDTOS.size(),pedidoDTOS);
    }

    private void preencheItems(List<Pedido> pedidos, List<PedidoDTO> pedidoDTOS) {
        for(Pedido pedido : pedidos){
            List<Item> items = itemRepository.findAllByPedidoId(pedido.getId());
            pedido.setItensPedido(items);
            PedidoDTO pedidoDTO = mapper.map(pedido,PedidoDTO.class);
            pedidoDTOS.add(pedidoDTO);
        }
    }

}
