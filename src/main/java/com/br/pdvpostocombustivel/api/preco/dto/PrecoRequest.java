package com.br.pdvpostocombustivel.api.preco.dto;

import java.math.BigDecimal;
import java.util.Date;

public record PrecoRequest(
        Long produtoId,
        BigDecimal valor,
        Date dataAlteracao,
        Date horaAlteracao
) {
}
