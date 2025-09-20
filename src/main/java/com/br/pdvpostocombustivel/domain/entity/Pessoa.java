package com.br.pdvpostocombustivel.domain.entity;


import com.br.pdvpostocombustivel.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.websocket.OnMessage;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "pessoa")



public class Pessoa {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)

    private String nomeCompleto;

    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @Column(length = 20, nullable = true)
    private Long numeroCtps;
    @Column(length = 10, nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", length = 15,nullable = false)
    private TipoPessoa tipoPessoa;

    //construtor
    public Pessoa(String nomeCompleto, String cpfCnpj, LocalDate dataNascimento, Long numeroCtps) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    }

    public Pessoa() {

    }

    public Long getId() {
        return id;
    }

    //getters
    public String getnomeCompleto() {
        return nomeCompleto;
    }

    public String getcpfCnpj() {
        return cpfCnpj;
    }

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public Long getnumeroCtps() {
        return numeroCtps;
    }


    //setters
    public void setnomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setcpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setnumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;

    }

    public void setId(Long id) {
        this.id = id;
    }
}
