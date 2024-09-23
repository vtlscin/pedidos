package com.pedidos.processar.pedidos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id")
    private Long codigoPedido;

    private Long codigoCliente;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itensPedido;

    public void atualizaItens(List<Item> itensPedido){
        for (Item item : itensPedido){
            item.setPedido(this);
        }
    }

    public BigDecimal valorTotalPedido(){
        return itensPedido.isEmpty()? BigDecimal.ZERO :
                itensPedido.stream().map(Item::valorItem).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
