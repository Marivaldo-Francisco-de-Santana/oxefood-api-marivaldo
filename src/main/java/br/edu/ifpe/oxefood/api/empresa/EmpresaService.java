package br.edu.ifpe.oxefood.api.empresa;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa build(EmpresaDTO dto) {

        Empresa empresa = new Empresa();

        empresa.setRazaoSocial(dto.getRazaoSocial());
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setCnpj(dto.getCnpj());
        empresa.setEmail(dto.getEmail());
        empresa.setTelefone(dto.getTelefone());
        empresa.setEndereco(dto.getEndereco());

        return empresa;
    }

    @Transactional
    public Empresa cadastrar(EmpresaDTO dto) {

        Empresa empresa = build(dto);

        empresa.setHabilitado(true);

        return repository.save(empresa);
    }
}
