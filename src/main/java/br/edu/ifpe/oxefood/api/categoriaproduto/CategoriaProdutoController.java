package br.edu.ifpe.oxefood.api.categoriaproduto;

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

import br.edu.ifpe.oxefood.api.categoriaproduto.CategoriaProduto;
import br.edu.ifpe.oxefood.api.categoriaproduto.CategoriaProdutoDTO;
import br.edu.ifpe.oxefood.api.categoriaproduto.CategoriaProdutoService;

@RestController
@RequestMapping("/api/categoriaproduto")
public class CategoriaProdutoController {

    private final CategoriaProdutoService categoriaprodutoService;

    public CategoriaProdutoController(CategoriaProdutoService service) {
        this.categoriaprodutoService = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaProduto> cadastrar(
            @RequestBody CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaProdutoCadastrado =
                categoriaprodutoService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaProdutoCadastrado);
    }

    @PutMapping
    public ResponseEntity<CategoriaProduto> atualizar(
            @RequestBody CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaProdutoAtualizado =
                categoriaprodutoService.atualizar(dto);

        return ResponseEntity.ok(categoriaProdutoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProduto>> listar() {

        return ResponseEntity.ok(
                categoriaprodutoService.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                categoriaprodutoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        categoriaprodutoService.remover(id);

        return ResponseEntity.noContent().build();

    }
}
