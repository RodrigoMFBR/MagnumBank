package com.magnumbank.api2.consumer;

import com.magnumbank.api2.queue.MarcaMessage;
import com.magnumbank.api2.service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MarcaConsumer {

    private static final Logger log = LoggerFactory.getLogger(MarcaConsumer.class);
    private final VeiculoService veiculoService;

    public MarcaConsumer(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @RabbitListener(queues = "${queue.marca.name}")
    public void consumirMarca(MarcaMessage message) {
        log.info("Processando marca " + message.getCodigo() + " - " + message.getNome());
        veiculoService.processarMarca(message.getCodigo(), message.getNome());
    }


}
