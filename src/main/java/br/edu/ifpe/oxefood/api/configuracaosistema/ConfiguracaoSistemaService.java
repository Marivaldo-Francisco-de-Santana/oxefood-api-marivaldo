package br.edu.ifpe.oxefood.api.configuracaosistema;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ConfiguracaoSistemaService {

    private final ConfiguracaoSistemaRepository repository;

    public ConfiguracaoSistemaService(ConfiguracaoSistemaRepository repository) {
        this.repository = repository;
    }

    public ConfiguracaoSistema build(ConfiguracaoSistemaDTO dto) {

        ConfiguracaoSistema configuracaosistema = null;

        if (dto.getId() == null) {

            configuracaosistema = new ConfiguracaoSistema();

        } else {

            configuracaosistema =
                    repository.findById(dto.getId()).get();
        }

        configuracaosistema.setNomeEmpresa(dto.getNomeEmpresa());
        configuracaosistema.setCnpj(dto.getCnpj());
        configuracaosistema.setSite(dto.getSite());
        configuracaosistema.setEmailContato(dto.getEmailContato());
        configuracaosistema.setTempoMinimoAgendamentoPedidos(dto.getTempoMinimoAgendamentoPedidos());
        configuracaosistema.setLigarAceitePedidos(dto.getLigarAceitePedidos());
        configuracaosistema.setDataEntradaSistema(dto.getDataEntradaSistema());

        return configuracaosistema;
    }

    @Transactional
    public ConfiguracaoSistema cadastrar(ConfiguracaoSistemaDTO dto) {

        ConfiguracaoSistema configuracaosistema = build(dto);

        configuracaosistema.setHabilitado(true);

        return repository.save(configuracaosistema);
    }

    public List<ConfiguracaoSistema> listar() {

        return repository.findAll();
    }

    public ConfiguracaoSistema buscarPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public ConfiguracaoSistema atualizar(ConfiguracaoSistemaDTO dto) {

        ConfiguracaoSistema configuracaosistema = build(dto);

        return repository.save(configuracaosistema);
    }

    @Transactional
    public void remover(Long id) {

        ConfiguracaoSistema configuracaosistema =
                repository.findById(id).get();

        configuracaosistema.setHabilitado(false);

        repository.save(configuracaosistema);
    }
}