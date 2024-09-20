package com.rabbitmq.service.ResponseProducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    // Envia a mensagem de sucesso
    //    fila: mensagem-response-sucesso-queue
    //    exchange: mensagem-response-sucesso-exchange
    public void gerarRespostaSucesso(String mensagem){
        amqpTemplate.convertAndSend(
            "mensagem-response-sucesso-exchange",
            "mensagem-response-sucesso-rout-key",
            mensagem);
    }

    // Envia a mensagem de erro
    //    fila: mensagem-response-erro-queue
    //    exchange: mensagem-response-erro-exchange
    public void gerarRespostaErro(String mensagem){
        amqpTemplate.convertAndSend(
            "mensagem-response-erro-exchange",
            "mensagem-response-erro-rout-key",
            mensagem);
    }
    
}
