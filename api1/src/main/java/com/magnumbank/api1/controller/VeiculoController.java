package com.magnumbank.api1.controller;

import com.magnumbank.api1.dto.VeiculoDTO;
import com.magnumbank.api1.dto.VeiculoRequest;
import com.magnumbank.api1.model.Veiculo;
import com.magnumbank.api1.repository.VeiculoRepository;
import com.magnumbank.api1.service.VeiculoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    // 1. Buscar todas as marcas únicas
    @GetMapping("/marcas")
    public List<String> listarMarcas() {
        return service.listarMarcas();
    }

    // 2. Buscar veículos por marca
    @GetMapping("/marca/{nome}")
    public List<VeiculoDTO> buscarPorMarca(@PathVariable String nome) {
        return service.buscarPorMarca(nome);
    }

    // 3. Atualizar veículo (modelo e observações)
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoRequest novo) {
        return service.atualizar(id, novo.getModelo(), novo.getObservacoes());
    }
}
