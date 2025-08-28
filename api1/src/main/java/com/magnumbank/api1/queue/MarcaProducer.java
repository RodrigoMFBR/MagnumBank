package com.magnumbank.api1.queue;

import com.magnumbank.api1.service.CargaInicialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MarcaProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${queue.marca.name}")
    private String queueName;

    private static final Logger log = LoggerFactory.getLogger(MarcaProducer.class);

    public MarcaProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMarca(MarcaMessage message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
