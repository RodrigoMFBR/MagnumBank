package com.magnumbank.api1.service;


import com.magnumbank.api1.dto.VeiculoDTO;
import com.magnumbank.api1.model.Veiculo;
import com.magnumbank.api1.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "veiculosPorMarca", key = "#nome.toLowerCase()")
    public List<VeiculoDTO> buscarPorMarca(String nome) {
        return repository.findByMarcaIgnoreCase(nome);
    }

    @Cacheable(value = "marcas")
    public List<String> listarMarcas(){
        return repository.findDistinctMarcas();
    }

    @Transactional
    @CachePut(value = "veiculos", key = "#id")
    public ResponseEntity<Veiculo> atualizar(Long id, String modelo, String observacoes){
        return repository.findById(id).map(veiculo -> {
            veiculo.setModelo(modelo);
            veiculo.setObservacoes(observacoes);
            return ResponseEntity.ok(veiculo);
        }).orElse(ResponseEntity.notFound().build());
    }
}
