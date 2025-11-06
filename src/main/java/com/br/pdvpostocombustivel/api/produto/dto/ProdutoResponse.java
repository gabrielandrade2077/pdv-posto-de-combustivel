package com.br.pdvpostocombustivel.api.produto.dto;

public record ProdutoResponse(
    Long id, // Adicionado
    String nome,
    String referencia,
    String fornecedor,
    String categoria,
    String marca
) {}
