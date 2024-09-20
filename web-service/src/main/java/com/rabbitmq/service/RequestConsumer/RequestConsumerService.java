package com.rabbitmq.service.RequestConsumer;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.service.ResponseProducer.ResponseProducerService;

import org.springframework.messaging.Message;

@Component
public class RequestConsumerService {

    @Autowired 
    private ResponseProducerService responseProducer;

    // Escuta a fila mensagem-request-queue
    @RabbitListener(queues = { "mensagem-request-queue"})
    public void receberMensagem(@Payload Message message) {

        System.out.println("\n Mensagem recebida no serviço " + LocalDateTime.now() + ": \n" + message);

        // Randomiza a resposta para exemplificar as filas de sucesso e erro
        if (new Random().nextBoolean()) {
            this.responseProducer.gerarRespostaSucesso("Resposta de sucesso para a mensagem: \n" + message);
        } else {
            this.responseProducer.gerarRespostaErro("Resposta de erro para a mensagem: \n" + message);
        }
    }
    
}
