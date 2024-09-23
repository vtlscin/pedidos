package com.pedidos.processar.pedidos.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedidos.processar.pedidos.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Long codigoPedido;

    @JsonIgnore
    private Long codigoCliente;

    @JsonProperty("itens")
    private List<ItemDTO> itensPedido;

    private BigDecimal valorTotal;

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "codigoPedido=" + codigoPedido +
                ", codigoCliente=" + codigoCliente +
                ", itensPedido=" + itensPedido +
                '}';
    }
}
