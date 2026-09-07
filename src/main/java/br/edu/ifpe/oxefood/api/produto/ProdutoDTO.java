package br.edu.ifpe.oxefood.api.produto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private String foneCelular;

    private String foneFixo;
 
}
