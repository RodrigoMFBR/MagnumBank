package com.magnumbank.api2.service;

import com.magnumbank.api2.fipe.FipeClient;
import com.magnumbank.api2.model.Veiculo;
import com.magnumbank.api2.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class VeiculoService {

    private final FipeClient fipeClient;
    private final VeiculoRepository repository;

    public VeiculoService(FipeClient fipeClient, VeiculoRepository repository) {
        this.fipeClient = fipeClient;
        this.repository = repository;
    }

    @Transactional
    public void processarMarca(String codigo, String nome) {
        List<Map<String, Object>> modelos = fipeClient.buscarModelosPorMarca(codigo);

        for (Map<String, Object> modelo : modelos) {
            String codigoModelo = modelo.get("codigo").toString();
            String nomeModelo = modelo.get("nome").toString();

            Veiculo veiculo = new Veiculo(codigoModelo, nome, nomeModelo);
            repository.save(veiculo);
        }
    }
}
