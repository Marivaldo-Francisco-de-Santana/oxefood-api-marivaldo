package br.edu.ifpe.oxefood.api.categoriaproduto;



import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class CategoriaProdutoService {

    private final CategoriaProdutoRepository repository;

    public CategoriaProdutoService(CategoriaProdutoRepository repository) {
        this.repository = repository;
    }

    public CategoriaProduto build(CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaproduto = null;

        if (dto.getId() == null) {
            // Montado para o cadastro
            categoriaproduto = new CategoriaProduto();

        } else {
            // Consultado para a alteração
            categoriaproduto = repository.findById(dto.getId()).get();
        }

        
        categoriaproduto.setDescricao(dto.getDescricao());

        return categoriaproduto;
    }

    @Transactional
    public CategoriaProduto cadastrar(CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaproduto = build(dto);

        categoriaproduto.setHabilitado(true);

        categoriaproduto.setDescricao(dto.getDescricao());

        return repository.save(categoriaproduto);
    }

    public List<CategoriaProduto> listar() {

        return repository.findAll();
    }

    public CategoriaProduto buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public CategoriaProduto atualizar(CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaproduto = build(dto);

        return repository.save(categoriaproduto);
    }

    @Transactional
    public void remover(Long id) {

        CategoriaProduto categoriaproduto = repository.findById(id).get();

        categoriaproduto.setHabilitado(false);

        repository.save(categoriaproduto);
    }
}

