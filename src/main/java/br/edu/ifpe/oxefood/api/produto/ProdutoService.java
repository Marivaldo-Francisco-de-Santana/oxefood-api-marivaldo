package br.edu.ifpe.oxefood.api.produto;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto build(ProdutoDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());

        return produto;
    }

    @Transactional
    public Produto cadastrar(ProdutoDTO dto) {

        Produto produto = build(dto);

        produto.setHabilitado(true);

        return repository.save(produto);
    }
}

