package com.br.pdvpostocombustivel.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "estoque")
public class Estoque {

    @Column(length = 10, nullable = false)
    private BigDecimal quantidade;
    @Column(length = 100, nullable = false)
    private String localTanque;

    @Column(length = 100, nullable = false)
    private String localEndereco;

    @Column(length = 25, nullable = false)
    private String loteFabricacao;

    @Column(length = 25, nullable = false)
    private Date dataValidade;

    public Estoque(BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao, Date dataValidade) {
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.dataValidade = dataValidade;
        this.loteFabricacao = loteFabricacao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public String getLocalTanque() {
        return localTanque;
    }

    public String getLocalEndereco() {
        return localEndereco;
    }

    public String getLoteFabricacao() {
        return loteFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }

    public void setLocalTanque(String localTanque) {
        this.localTanque = localTanque;
    }

    public void setLoteFabricacao(String loteFabricacao) {
        this.loteFabricacao = loteFabricacao;
    }
}