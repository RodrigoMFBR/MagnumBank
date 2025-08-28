package com.magnumbank.api2.fipe;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
@Component
public class FipeClient {

    private final WebClient webClient;

    public FipeClient() {
        this.webClient = WebClient.create("https://parallelum.com.br/fipe/api/v1/carros");
    }

    public List<Map<String, Object>> buscarModelosPorMarca(String codigoMarca) {
        var response = webClient.get()
                .uri("/marcas/{codigo}/modelos", codigoMarca)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response != null && response.containsKey("modelos")) {
            return (List<Map<String, Object>>) response.get("modelos");
        }
        return List.of();
    }
}
