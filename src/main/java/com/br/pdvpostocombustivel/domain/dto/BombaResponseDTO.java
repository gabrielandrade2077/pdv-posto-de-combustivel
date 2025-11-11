package com.br.pdvpostocombustivel.domain.dto;

import java.util.List;

public class BombaResponseDTO {

    private Long id;
    private Integer numero;
    private List<BicoResponseDTO> bicos;

    public BombaResponseDTO(Long id, Integer numero, List<BicoResponseDTO> bicos) {
        this.id = id;
        this.numero = numero;
        this.bicos = bicos;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }

    public List<BicoResponseDTO> getBicos() {
        return bicos;
    }
}