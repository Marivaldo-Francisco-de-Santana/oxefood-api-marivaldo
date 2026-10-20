package br.edu.ifpe.oxefood.api.itempedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ItemPedidoDTO {

    private Long id;

    private int quantidade;

    
    private double valorUnitarioItem;

    
    private double valorTotalItem;

    
    private String observacaoItem;
}