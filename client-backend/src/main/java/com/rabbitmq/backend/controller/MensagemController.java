package com.rabbitmq.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.backend.dto.MensagemDTO;
import com.rabbitmq.backend.facade.MensagemFacade;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
    
    @Autowired private MensagemFacade mensagemFacade;

    @PostMapping
    public String processar (@RequestBody MensagemDTO request) {
        return mensagemFacade.enviarMensagem(request);
    }

}