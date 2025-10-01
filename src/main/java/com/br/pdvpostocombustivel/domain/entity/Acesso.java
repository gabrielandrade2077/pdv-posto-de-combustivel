package com.br.pdvpostocombustivel.domain.entity;


import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "acesso")
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)

    private String usuario;

    @Column(length = 25, nullable = false)

    private String senha;

    public Acesso(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Acesso() {
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}