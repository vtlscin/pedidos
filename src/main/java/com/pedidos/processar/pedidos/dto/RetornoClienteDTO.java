package com.pedidos.processar.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RetornoClienteDTO {

    private int quantidadePedidos;

    private List<PedidoDTO> pedidos = new ArrayList<>();
}
