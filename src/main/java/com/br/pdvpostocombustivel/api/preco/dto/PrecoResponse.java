package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.domain.entity.Produto;

import java.math.BigDecimal;
import java.util.Date;

public record PrecoResponse(
        Produto produto,
        BigDecimal valor,
        Date dataAlteracao,
        Date horaAlteracao
) {
}
