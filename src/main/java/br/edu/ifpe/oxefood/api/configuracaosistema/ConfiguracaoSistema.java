package br.edu.ifpe.oxefood.api.configuracaosistema;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "configuracaosistema")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracaoSistema extends EntidadeAuditavel {

    @Column
    private String nomeEmpresa;

    @Column
    private String cnpj;

    @Column
    private String site;

    @Column
    private String emailContato;

    @Column
    private Long tempoMinimoAgendamentoPedidos;

    @Column
    private Boolean ligarAceitePedidos;

    @Column
    private LocalDate dataEntradaSistema;
}
