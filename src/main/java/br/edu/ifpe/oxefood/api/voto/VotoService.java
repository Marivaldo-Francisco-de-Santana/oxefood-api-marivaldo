package br.edu.ifpe.oxefood.api.voto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class VotoService {

    private final votoRepository repository;

    public votoService(votoRepository repository) {
        this.repository = repository;
    }

    public voto build(votoDTO dto) {

        voto voto = null;

        if (dto.getId() == null) {
            // Montado para o cadastro
            voto = new voto();

        } else {
            // Consultado para a alteração
            voto = repository.findById(dto.getId()).get();
        }

        voto.nomeEleitor(dto.getnomeEleitor());
        voto.setnumeroRegistroEleitoral(dto.getnumeroRegistroEleitoral());
        voto.setdataVotacao(dto.getdataVotacao());
        voto.setnumeroCandidatoDepFederal(dto.getnumeroCandidatoDepFederal());
        voto.setnumeroCandidatoDepEstadual(dto.getnumeroCandidatoDepEstadual());
        voto.setnumeroCandidatoSenador(dto.getnumeroCandidatoSenador());
        voto.setnumeroCandidatoGovernador(dto.getnumeroCandidatoGovernador()); 
        voto.setnumeroCandidatoPresidente(dto.getnumeroCandidatoPresidente());

        return voto;
    }

    @Transactional
    public voto cadastrar(votoDTO dto) {

        voto voto = build(dto);

        voto.setHabilitado(true);

        return repository.save(voto);
    }

    public List<voto> listar() {

        return repository.findAll();
    }

    public voto buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public voto atualizar(votoDTO dto) {

        voto voto = build(dto);

        return repository.save(voto);
    }

    @Transactional
    public void remover(Long id) {

        voto voto = repository.findById(id).get();

        voto.setHabilitado(false);

        repository.save(voto);
    }
}
