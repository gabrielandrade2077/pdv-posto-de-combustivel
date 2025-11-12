package com.br.pdvpostocombustivel.api.bomba.dto;

public class BicoResponseDTO {

    private Long id;
    private ProdutoResponseDTO combustivel;

    public BicoResponseDTO(Long id, ProdutoResponseDTO combustivel) {
        this.id = id;
        this.combustivel = combustivel;
    }

    public Long getId() {
        return id;
    }

    public ProdutoResponseDTO getCombustivel() {
        return combustivel;
    }
}