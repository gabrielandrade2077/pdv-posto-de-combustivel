package com.br.pdvpostocombustivel.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bomba")
public class Bomba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @OneToMany(mappedBy = "bomba", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Bico> bicos = new ArrayList<>();

    public Bomba() {
    }

    public Bomba(Integer numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Bico> getBicos() {
        return bicos;
    }

    public void setBicos(List<Bico> bicos) {
        this.bicos = bicos;
    }
}
