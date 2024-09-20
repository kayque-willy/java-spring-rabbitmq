package com.rabbitmq.backend.facade;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.backend.dto.MensagemDTO;
import com.rabbitmq.backend.service.producer.RequestProducer;

@Service
public class MensagemFacade {

    @Autowired private RequestProducer mensagemRequestProducer;

    public String enviarMensagem(MensagemDTO request) {
        try {
            this.mensagemRequestProducer.enviarMensagem(request);
        } catch (JsonProcessingException e) {
            return "Ocorreu um erro ao enviar a mensagem .. " + e.getMessage();
        }
        return "Mensagem aguardando confirmacao...";
    }

    public void erroMensagem(String payload) {
        System.err.println("\n ==== MENSAGEM DE ERRO RECEBIDA ===== " + LocalDateTime.now() + "\n" + payload);
    }

    public void sucessoMensagem(String payload) {
        System.out.println("\n ==== MENSAGEM DE SUCESSO RECEBIDA ===== " + LocalDateTime.now() + "\n" + payload);
    }
    
}
