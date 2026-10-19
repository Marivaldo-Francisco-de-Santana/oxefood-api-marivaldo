package br.edu.ifpe.oxefood.api.usuario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(
            @RequestBody UsuarioDTO dto) {

        Usuario usuarioCadastrado =
                usuarioService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioCadastrado);
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {

        List<Usuario> usuarios =
                usuarioService.listar();

        return ResponseEntity.ok(usuarios);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(
            @PathVariable Long id) {

        Usuario usuario =
                usuarioService.buscarPorId(id);

        return ResponseEntity.ok(usuario);
    }

    // ATUALIZAR
    @PutMapping
    public ResponseEntity<Usuario> atualizar(
            @RequestBody UsuarioDTO dto) {

        Usuario usuarioAtualizado =
                usuarioService.atualizar(dto);

        return ResponseEntity.ok(usuarioAtualizado);
    }

    // REMOVER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        usuarioService.remover(id);

        return ResponseEntity.noContent().build();
    }
}

