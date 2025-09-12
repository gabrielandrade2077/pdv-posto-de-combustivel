package com.br.pdvpostocombustivel.domain.entity;


import java.util.Date;

public class Custo {
    private double imposto;
    private double custoVariavel;
    private double custoFixo;
    private double margemlucro;
    private Date dataProcessamento;

    public Custo(double imposto,double custoFixo,double custoVariavel,double margemlucro, Date dataProcessamento){
        this.custoFixo = custoFixo;
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.margemlucro = margemlucro;
        this.dataProcessamento = dataProcessamento;
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

    public double getMargemlucro() {
        return margemlucro;
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

    public void setMargemlucro(double margemlucro) {
        this.margemlucro = margemlucro;
    }
}