package br.edu.ifpe.oxefood.api.empresa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService service) {
        this.empresaService = service;
    }

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(
            @RequestBody EmpresaDTO dto) {

        Empresa empresaCadastrada = empresaService.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empresaCadastrada);
    }
}
