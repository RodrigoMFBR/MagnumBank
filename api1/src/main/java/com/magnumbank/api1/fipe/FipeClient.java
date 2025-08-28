package com.magnumbank.api1.fipe;

import com.magnumbank.api1.dto.MarcaDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Component
public class FipeClient {

    private final WebClient webClient;

    public FipeClient() {
        this.webClient = WebClient.create("https://parallelum.com.br/fipe/api/v1/carros");
    }

    public List<MarcaDTO> buscarMarcas() {
        return webClient.get()
                .uri("/marcas")
                .retrieve()
                .bodyToFlux(MarcaDTO.class)
                .collectList()
                .block();
    }
}
