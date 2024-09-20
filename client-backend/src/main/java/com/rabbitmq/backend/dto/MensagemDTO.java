package com.rabbitmq.backend.dto;

import java.math.BigDecimal;

public class MensagemDTO {

    private String id;
    private BigDecimal valor;
    private String descricao;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
