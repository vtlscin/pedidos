package com.pedidos.processar.pedidos.kafka;

import com.pedidos.processar.pedidos.dto.PedidoDTO;
import com.pedidos.processar.pedidos.model.Pedido;
import com.pedidos.processar.pedidos.service.PedidoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private PedidoService pedidoService;

    public KafkaConsumer(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @KafkaListener(topics = "pedidos",groupId = "group")
    public void consumer(PedidoDTO pedido){
        pedidoService.salvarPedido(pedido);
        System.out.println(pedido);
    }

}
