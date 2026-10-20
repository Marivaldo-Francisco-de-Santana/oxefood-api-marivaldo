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
@RequestMapping("/api/itempedidos")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService service) {
        this.itemPedidoService = service;
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<ItemPedido> cadastrar(
            @RequestBody ItemPedidoDTO dto) {

        ItemPedido itemPedidoCadastrado =
                itemPedidoService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemPedidoCadastrado);
    }

    // LISTAR
    @GetMapping
    public ResponseEntity<List<ItemPedido>> listar() {

        List<ItemPedido> itemPedidos =
                itemPedidoService.listar();

        return ResponseEntity.ok(itemPedidos);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarPorId(
            @PathVariable Long id) {

        ItemPedido itemPedido =
                itemPedidoService.buscarPorId(id);

        return ResponseEntity.ok(itemPedido);
    }

    // ATUALIZAR
    @PutMapping
    public ResponseEntity<ItemPedido> atualizar(
            @RequestBody ItemPedidoDTO dto) {

        ItemPedido itemPedidoAtualizado =
                itemPedidoService.atualizar(dto);

        return ResponseEntity.ok(itemPedidoAtualizado);
    }

    // REMOVER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        itemPedidoService.remover(id);

        return ResponseEntity.noContent().build();
    }
}
