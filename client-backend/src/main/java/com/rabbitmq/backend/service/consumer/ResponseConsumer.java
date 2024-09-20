package com.rabbitmq.backend.service.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rabbitmq.backend.facade.MensagemFacade;

@Service
public class ResponseConsumer {
    
    @Autowired 
    private MensagemFacade mensagemFacade;

    // Escuta a fila: mensagem-response-sucesso-queue
    @RabbitListener(queues = {"mensagem-response-sucesso-queue"})
    public void receiveSucess(@Payload Message message) {

        String payload = String.valueOf(message.getPayload());

        mensagemFacade.sucessoMensagem(payload);
    }

      // Escuta a fila: mensagem-response-erro-queue
      @RabbitListener(queues = {"mensagem-response-erro-queue"})
      public void receiveError(@Payload Message message) {
  
          String payload = String.valueOf(message.getPayload());
  
          mensagemFacade.erroMensagem(payload);
      }
}
