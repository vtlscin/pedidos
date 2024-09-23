package com.pedidos.processar.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {

    private String produto;

    private Integer quantidade;

    private BigDecimal preco;

    @Override
    public String toString() {
        return "ItemDTO{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
