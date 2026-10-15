package br.edu.ifpe.oxefood.api.sturno;

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
@RequestMapping("/api/sturno")
public class SturnoController {

    private final SturnoService sturnoService;

    public SturnoController(SturnoService service) {
        this.sturnoService = service;
    }

    @PostMapping
    public ResponseEntity<Sturno> cadastrar(
            @RequestBody SturnoDTO dto) {

        Sturno sturnoCadastrado =
                sturnoService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sturnoCadastrado);
    }

    @PutMapping
    public ResponseEntity<Sturno> atualizar(
            @RequestBody SturnoDTO dto) {

        Sturno sturnoAtualizado =
                sturnoService.atualizar(dto);

        return ResponseEntity.ok(sturnoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<Sturno>> listar() {

        return ResponseEntity.ok(
                sturnoService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sturno> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sturnoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        sturnoService.remover(id);

        return ResponseEntity.noContent().build();

    }
}
