package br.edu.ifpe.oxefood.api.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
       this.repository = repository;
    }

    public Cliente build(ClienteDTO dto) {

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setCpf(dto.getCpf());
        cliente.setFoneCelular(dto.getFoneCelular());
        cliente.setFoneFixo(dto.getFoneFixo());

        return cliente;
    }

    @Transactional
    public Cliente cadastrar(ClienteDTO dto) {

        
        Cliente cliente = build(dto);
        cliente.setHabilitado(true);
        return repository.save(cliente);
    }
    public List<Cliente> listar() {

        return repository.findAll();
    }

    public Cliente buscarPorId(Long id) {

        return repository.findById(id).get();

} 
  @Transactional
   public void remover(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(false);

        repository.save(cliente);
   }

}
