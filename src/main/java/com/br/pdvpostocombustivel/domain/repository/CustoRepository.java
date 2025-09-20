package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Long> {
    Optional<Custo> findByImposto(Double imposto);

    Optional<Custo> findByCustoVariavel(Double custoVariavel);

    Optional<Custo> findByCustoFixo(Double custoFixo);

    Optional<Custo> findByMargemLucro(Double margemLucro);

    Optional<Custo> findBydataProcessamento(Date dataProcessamento);

    boolean existsByCustoVariavel(Double custoVariavel);

    boolean existsByImposto(Double imposto);

    boolean existsByCustoFixo(Double custoFixo);

    boolean existsByMargemLucro(Double margemLucro);

    boolean existsBydataProcessamento(Double dataProcessamento);


}
