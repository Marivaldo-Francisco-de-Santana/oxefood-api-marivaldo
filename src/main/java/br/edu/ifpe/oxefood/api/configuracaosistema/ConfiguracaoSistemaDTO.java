package br.edu.ifpe.oxefood.api.configuracaosistema;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracaoSistemaDTO {

    private Long id;

  
    private String nomeEmpresa;

    
    private String cnpj;

    
    private String site;

    
    private String emailContato;

   
    private Long tempoMinimoAgendamentoPedidos;

    
    private Boolean ligarAceitePedidos;

    
    private LocalDate dataEntradaSistema;
}
