package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.domain.entity.Produto;

import java.math.BigDecimal;
import java.util.Date;

public record EstoqueResponse(
        Produto produto,
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        Date dataValidade
) {
}
