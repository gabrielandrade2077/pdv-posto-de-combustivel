package com.br.pdvpostocombustivel.api.abastecimento.dto;

import java.math.BigDecimal;

public class AbastecimentoInputDTO {

    private Long bicoId;
    private BigDecimal litros;
    private BigDecimal precoPorLitro;
    private BigDecimal valorTotal;
    private String formaPagamento;

    public Long getBicoId() {
        return bicoId;
    }

    public void setBicoId(Long bicoId) {
        this.bicoId = bicoId;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public BigDecimal getPrecoPorLitro() {
        return precoPorLitro;
    }

    public void setPrecoPorLitro(BigDecimal precoPorLitro) {
        this.precoPorLitro = precoPorLitro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}