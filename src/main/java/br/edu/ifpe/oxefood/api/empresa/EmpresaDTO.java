package br.edu.ifpe.oxefood.api.empresa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {

    private Long id;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String email;

    private String telefone;

    private String endereco;
}
