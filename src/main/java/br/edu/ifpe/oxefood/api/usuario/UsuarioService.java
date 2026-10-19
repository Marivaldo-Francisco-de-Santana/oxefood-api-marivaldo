package br.edu.ifpe.oxefood.api.usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario build(UsuarioDTO dto) {

        Usuario usuario = null;

        if (dto.getId() == null) {

            // Cadastro
            usuario = new Usuario();

        } else {

            // Alteração
            usuario =
                    repository.findById(dto.getId()).get();
        }

        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setRoles(dto.getRoles());

        return usuario;
    }

    @Transactional
    public Usuario cadastrar(UsuarioDTO dto) {

        Usuario usuario = build(dto);

        return repository.save(usuario);
    }

    public List<Usuario> listar() {

        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public Usuario atualizar(UsuarioDTO dto) {

        Usuario usuario = build(dto);

        return repository.save(usuario);
    }

    @Transactional
    public void remover(Long id) {

        Usuario usuario =
                repository.findById(id).get();

        usuario.setHabilitado(false);

        repository.save(usuario);
    }
}


