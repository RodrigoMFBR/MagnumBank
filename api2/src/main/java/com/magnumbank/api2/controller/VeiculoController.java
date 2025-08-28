package com.magnumbank.api2.controller;

import com.magnumbank.api2.model.Veiculo;
import com.magnumbank.api2.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository repository;

    public VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    // 1. Buscar todas as marcas únicas
    @GetMapping("/marcas")
    public List<String> listarMarcas() {
        return repository.findDistinctMarcas();
    }

    // 2. Buscar veículos por marca
    @GetMapping("/marca/{nome}")
    public List<Veiculo> buscarPorMarca(@PathVariable String nome) {
        return repository.findByMarcaIgnoreCase(nome);
    }

    // 3. Atualizar veículo (modelo e observações)
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo novo) {
        return repository.findById(id).map(veiculo -> {
            veiculo.setModelo(novo.getModelo());
            veiculo.setObservacoes(novo.getObservacoes());
            return ResponseEntity.ok(veiculo);
        }).orElse(ResponseEntity.notFound().build());
    }
}
