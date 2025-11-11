package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "abastecimento")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bico_id", nullable = false)
    private Bico bico;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal litros;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoPorLitro;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(length = 50, nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    public Abastecimento() {
    }

    public Abastecimento(Bico bico, BigDecimal litros, BigDecimal precoPorLitro, BigDecimal valorTotal, String formaPagamento) {
        this.bico = bico;
        this.litros = litros;
        this.precoPorLitro = precoPorLitro;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Bico getBico() {
        return bico;
    }

    public void setBico(Bico bico) {
        this.bico = bico;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}