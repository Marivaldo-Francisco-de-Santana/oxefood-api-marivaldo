package br.edu.ifpe.oxefood.api.sturno;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class SturnoService {

    private final SturnoRepository repository;

    public SturnoService(SturnoRepository repository) {
        this.repository = repository;
    }

    public Sturno build(SturnoDTO dto) {

        Sturno sturno = null;

        if (dto.getId() == null) {
            // Montado para o cadastro
            sturno = new Sturno();

        } else {
            // Consultado para a alteração
            sturno = repository.findById(dto.getId()).get();
        }

        
        sturno.setNumeroCandidatoPresidente(dto.getNumeroCandidatoPresidente());

        return sturno;
    }

    @Transactional
    public Sturno cadastrar(SturnoDTO dto) {

        Sturno sturno = build(dto);

        sturno.setHabilitado(true);

        sturno.setDataVotacao(LocalDate.now());

        return repository.save(sturno);
    }

    public List<Sturno> listar() {

        return repository.findAll();
    }

    public Sturno buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public Sturno atualizar(SturnoDTO dto) {

        Sturno sturno = build(dto);

        return repository.save(sturno);
    }

    @Transactional
    public void remover(Long id) {

        Sturno sturno = repository.findById(id).get();

        sturno.setHabilitado(false);

        repository.save(sturno);
    }
}

