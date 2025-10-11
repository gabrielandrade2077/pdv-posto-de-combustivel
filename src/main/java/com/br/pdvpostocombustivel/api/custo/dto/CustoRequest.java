package com.br.pdvpostocombustivel.api.custo.dto;

import java.util.Date;

public record CustoRequest(
    double imposto,
    double custoVariavel,
    double custoFixo,
    double margemLucro,
    Date dataProcessamento
) {}
