package br.edu.ifpe.oxefood.api.sturno;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SturnoDTO {

    private Long id;

    private LocalDate dataVotacao;
    
    private Integer numeroCandidatoPresidente;
}
