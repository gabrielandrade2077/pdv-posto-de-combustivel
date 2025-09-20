package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface PrecoRepository extends JpaRepository<Preco, Long>{
    Optional<Preco> findByValor(BigDecimal valor);

    Optional<Preco> findByDataAlteracao(LocalDate dataAlteracao);

    Optional<Preco> findByHoraAlteracao(LocalDate horaAlteracao);

    boolean existsByValor(BigDecimal valor);

    boolean existsBydataAlteracao(LocalDate dataAlteracao);

    boolean existsByhoraAlteracao(LocalDate horaAlteracao);
}
