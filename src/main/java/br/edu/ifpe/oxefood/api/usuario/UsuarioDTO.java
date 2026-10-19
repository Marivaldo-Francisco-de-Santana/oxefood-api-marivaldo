
package br.edu.ifpe.oxefood.api.usuario;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String username;

    private String password;

    private List<String> roles;
}
