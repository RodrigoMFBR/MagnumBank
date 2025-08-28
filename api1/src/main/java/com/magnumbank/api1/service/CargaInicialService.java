package com.magnumbank.api1.service;

import com.magnumbank.api1.dto.MarcaDTO;
import com.magnumbank.api1.queue.MarcaMessage;
import com.magnumbank.api1.queue.MarcaProducer;
import com.magnumbank.api1.fipe.FipeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargaInicialService {

    private FipeClient fipeClient;
    private final MarcaProducer marcaProducer;

    private static final Logger log = LoggerFactory.getLogger(CargaInicialService.class);

    public CargaInicialService(FipeClient fipeClient, MarcaProducer marcaProducer) {
        this.fipeClient = fipeClient;
        this.marcaProducer = marcaProducer;
    }

    public void executarCargaInicial() {
        log.info("Buscando Marcas");
        List<MarcaDTO> marcas = fipeClient.buscarMarcas();

        marcas.stream()
                .filter(this::marcaValida) // << Validação aqui
                .forEach(marca -> {
                    MarcaMessage message = new MarcaMessage(marca.codigo(), marca.nome());
                    marcaProducer.enviarMarca(message);
                });


    }

    private boolean marcaValida(MarcaDTO marca) {
        return marca.codigo() != null &&
                !marca.codigo().isBlank() &&
                marca.nome() != null &&
                !marca.nome().isBlank() &&
                !marca.nome().equalsIgnoreCase("outros");
    }
}
