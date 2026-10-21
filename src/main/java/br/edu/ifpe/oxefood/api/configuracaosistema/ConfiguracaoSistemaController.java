package br.edu.ifpe.oxefood.api.configuracaosistema;

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
@RequestMapping("/api/configuracaosistema")
public class ConfiguracaoSistemaController {

    private final configuracaosistemaService configuracaosistemaService;

    public ConfiguracaoSistemaController(ConfiguracaoSistemaService service) {
        this.configuracaosistemaService = service;
    }

    @PostMapping
    public ResponseEntity<ConfiguracaoSistema> cadastrar(
            @RequestBody ConfiguracaoSistemaDTO dto) {

        ConfiguracaoSistema configuracaosistemaCadastrada =
                configuracaosistemaService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(configuracaosistemaCadastrada);
    }

    @GetMapping
    public ResponseEntity<List<ConfiguracaoSistema>> listar() {

        return ResponseEntity.ok(
                configuracaosistemaService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracaoSistema> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                configuracaosistemaService.buscarPorId(id)
        );
    }

    @PutMapping
    public ResponseEntity<ConfiguracaoSistema> atualizar(
            @RequestBody ConfiguracaoSistemaDTO dto) {

        ConfiguracaoSistema configuracaosistemaAtualizada =
                configuracaosistemaService.atualizar(dto);

        return ResponseEntity.ok(configuracaosistemaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        configuracaosistemaService.remover(id);

        return ResponseEntity.noContent().build();
    }
}
