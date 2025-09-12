package com.br.pdvpostocombustivel.domain.entity;


import java.util.Date;

public class Pessoa {
    //atributos
    private String nomeCompleto;

    private String cpfCnpj;

    private Date dataNascimento;

    private Integer numeroCtps;


    //construtor
    public Pessoa(String nomeCompleto, String cpfCnpj, Date dataNascimento, Integer numeroCtps) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    }


    //getters
    public String getnomeCompleto() {
        return nomeCompleto;
    }

    public String getcpfCnpj() {
        return cpfCnpj;
    }

    public Date getdataNascimento() {
        return dataNascimento;
    }

    public Integer getnumeroCtps() {
        return numeroCtps;
    }


    //setters
    public void setnomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setcpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setdataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setnumeroCtps(Integer numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
}
