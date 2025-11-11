package com.br.pdvpostocombustivel.api.produto.dto;

import java.math.BigDecimal;

public record ProdutoResponse(
    Long id, // Adicionado
    String nome,
    String referencia,
    String fornecedor,
    String categoria,
    String marca,
    BigDecimal precoVenda
) {}
