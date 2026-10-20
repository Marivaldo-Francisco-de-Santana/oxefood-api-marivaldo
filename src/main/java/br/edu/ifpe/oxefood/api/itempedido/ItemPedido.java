package br.edu.ifpe.oxefood.api.itempedido;

import br.edu.ifpe.oxefood.util.EntidadeAuditavel;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "itempedido")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido extends EntidadeAuditavel {

    @Column
    private int quantidade;

    @Column
    private double valorUnitarioItem;

    @Column
    private double valorTotalItem;

    @Column
    private String observacaoItem;
}


