package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByQuantidade(BigDecimal quantidade);

    Optional<Estoque> findByLocalTanque(String localTanque);

    Optional<Estoque> findByLocalEndereco(String localEndereco);

    Optional<Estoque> findByLoteFabricacao(String loteFabricacao);

    Optional<Estoque> findByDataValidade(Date dataValidade);

    boolean existsByQuantidade(BigDecimal quantidade );

    boolean existsByLocalEndereco(String localEndereco);
    boolean existsByLocalTanque(String localTanque);


    boolean existsByLoteFabricacao(String loteFabricacao);

    boolean existsByDataValidade(Date dataValidade);


}
