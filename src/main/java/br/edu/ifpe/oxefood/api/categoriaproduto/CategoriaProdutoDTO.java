package br.edu.ifpe.oxefood.api.categoriaproduto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoDTO {

    private Long id;

    private String descricao;
}

