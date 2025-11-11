package com.br.pdvpostocombustivel.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "bico")
public class Bico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    @JsonBackReference
    private Bomba bomba;

    @ManyToOne
    @JoinColumn(name = "combustivel_id", nullable = false)
    private Combustivel combustivel;

    public Bico(Bomba bomba, Combustivel combustivel) {
        this.bomba = bomba;
        this.combustivel = combustivel;
    }

    public Bico() {
    }

    public Long getId() {
        return id;
    }

    public Bomba getBomba() {
        return bomba;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setBomba(Bomba bomba) {
        this.bomba = bomba;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
}
