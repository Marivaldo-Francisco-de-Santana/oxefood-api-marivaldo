package br.edu.ifpe.oxefood.api.itempedido;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository repository;

    public ItemPedidoService(ItemPedidoRepository repository) {
        this.repository = repository;
    }

    public ItemPedido build(ItemPedidoDTO dto) {

        ItemPedido itemPedido = null;

        if (dto.getId() == null) {

            // Cadastro
            itemPedido = new ItemPedido();

        } else {

            // Alteração
            itemPedido =
                    repository.findById(dto.getId()).get();
        }

        itemPedido.setQuantidade(dto.getQuantidade());
        itemPedido.setValorUnitarioItem(dto.getValorUnitarioItem());
        itemPedido.setValorTotalItem(dto.getValorTotalItem());
        itemPedido.setObservacaoItem(dto.getObservacaoItem());

        return itemPedido;
    }

    @Transactional
    public ItemPedido cadastrar(ItemPedidoDTO dto) {

        ItemPedido itemPedido = build(dto);

        itemPedido.setHabilitado(true);

        return repository.save(itemPedido);
    }

    public List<ItemPedido> listar() {

        return repository.findAll();
    }

    public ItemPedido buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public ItemPedido atualizar(ItemPedidoDTO dto) {

        ItemPedido itemPedido = build(dto);

        return repository.save(itemPedido);
    }

    @Transactional
    public void remover(Long id) {

        ItemPedido itemPedido =
                repository.findById(id).get();

        itemPedido.setHabilitado(false);

        repository.save(itemPedido);
    }
}


