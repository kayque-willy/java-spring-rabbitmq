package com.rabbitmq.backend.service.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.backend.dto.MensagemDTO;

@Service
public class RequestProducer {

    @Autowired private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Envia a mensagem para a fila com o objeto MensagemDTO para o exchange
    //    fila: mensagem-request-queue
    //    exchange: mensagem-request-exchange
    public void enviarMensagem(MensagemDTO mensagem) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
            "mensagem-request-exchange",
            "mensagem-request-rout-key",
            objectMapper.writeValueAsString(mensagem)
        );
    }
    
}
