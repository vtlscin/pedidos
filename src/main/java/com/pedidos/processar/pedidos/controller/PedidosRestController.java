package com.pedidos.processar.pedidos.controller;

import com.pedidos.processar.pedidos.dto.PedidoDTO;
import com.pedidos.processar.pedidos.dto.RetornoClienteDTO;
import com.pedidos.processar.pedidos.service.ItemService;
import com.pedidos.processar.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidosRestController {

    private KafkaTemplate<String, PedidoDTO> kafkaTemplate;

    private PedidoService pedidoService;

    @Autowired
    private ItemService itemService;

    public PedidosRestController(KafkaTemplate<String, PedidoDTO> kafkaTemplate, PedidoService pedidoService) {
        this.kafkaTemplate = kafkaTemplate;
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity incluirPedido(@RequestBody PedidoDTO pedido){
        this.kafkaTemplate.send("pedidos",pedido);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<RetornoClienteDTO> retornaPedidos(@PathVariable Long clienteId) throws Exception {
        RetornoClienteDTO retornoClienteDTO = pedidoService.listaPedidosCliente(clienteId);
        return ResponseEntity.ok(retornoClienteDTO);
    }
}
