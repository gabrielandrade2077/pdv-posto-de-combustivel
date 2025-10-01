package com.br.pdvpostocombustivel.domain.entity;


import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "custo")
public class Custo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000, nullable = false)
    private double imposto;
    @Column(length = 1000, nullable = false)
    private double custoVariavel;
    @Column(length = 1000, nullable = false)
    private double custoFixo;
    @Column(length = 5, nullable = false)
    private double margemLucro;
    @Column(length = 8, nullable = false)
    private Date dataProcessamento;

    public Custo(double imposto,double custoFixo,double custoVariavel,double margemLucro, Date dataProcessamento){
        this.custoFixo = custoFixo;
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.margemLucro = margemLucro;
        this.dataProcessamento = dataProcessamento;
    }

    public Custo() {
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }

    public double getCustoFixo() {
        return custoFixo;
    }

    public double getCustoVariavel() {
        return custoVariavel;
    }

    public double getImposto() {
        return imposto;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setCustoFixo(double custoFixo) {
        this.custoFixo = custoFixo;
    }

    public void setCustoVariavel(double custoVariavel) {
        this.custoVariavel = custoVariavel;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }
}