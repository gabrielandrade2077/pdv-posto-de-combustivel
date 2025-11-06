package com.br.pdvpostocombustivel.domain.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "preco")

public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private BigDecimal valor;
    @Column(length = 8, nullable = false)
    private Date dataAlteracao;
    @Column(nullable = false)
    private Date horaAlteracao;

    public Preco(BigDecimal valor, Date dataAlteracao, Date horaAlteracao) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }

    public Preco() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public Date getHoraAlteracao() {
        return horaAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setHoraAlteracao(Date horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}