package com.br.pdvpostocombustivel.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity
@Table(name = "acesso")
public class Acesso {
    @Column(length = 30, nullable = false)

    private String usuario;

    @Column(length = 25, nullable = false)

    private String senha;

    public Acesso(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
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