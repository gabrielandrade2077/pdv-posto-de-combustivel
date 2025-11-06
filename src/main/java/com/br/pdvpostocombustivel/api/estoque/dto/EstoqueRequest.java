package com.br.pdvpostocombustivel.api.estoque.dto;

import java.math.BigDecimal;
import java.util.Date;

public record EstoqueRequest(
        Long produtoId,
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        Date dataValidade
) {
}
