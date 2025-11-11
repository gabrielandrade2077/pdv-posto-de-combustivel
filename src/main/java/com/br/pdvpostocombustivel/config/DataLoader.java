package com.br.pdvpostocombustivel.config;

import com.br.pdvpostocombustivel.domain.entity.Bico;
import com.br.pdvpostocombustivel.domain.entity.Bomba;
import com.br.pdvpostocombustivel.domain.entity.Combustivel;
import com.br.pdvpostocombustivel.domain.repository.BicoRepository;
import com.br.pdvpostocombustivel.domain.repository.BombaRepository;
import com.br.pdvpostocombustivel.domain.repository.CombustivelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    @Transactional
    public CommandLineRunner loadData(BombaRepository bombaRepository, CombustivelRepository combustivelRepository, BicoRepository bicoRepository) {
        return args -> {
            if (bombaRepository.count() > 0) {
                return; // Se já existem bombas, não faz nada.
            }

            // 1. Salva os combustíveis
            Combustivel gasolina = new Combustivel("Gasolina", new BigDecimal("5.89"));
            Combustivel etanol = new Combustivel("Etanol", new BigDecimal("3.89"));
            Combustivel diesel = new Combustivel("Diesel", new BigDecimal("4.89"));
            combustivelRepository.saveAll(List.of(gasolina, etanol, diesel));

            // 2. Salva as bombas
            Bomba bomba1 = new Bomba(1);
            Bomba bomba2 = new Bomba(2);
            Bomba bomba3 = new Bomba(3);
            bombaRepository.saveAll(List.of(bomba1, bomba2, bomba3));

            // 3. Cria e salva os bicos, que ligam Bomba e Combustivel
            Bico bico1 = new Bico(bomba1, gasolina);
            Bico bico2 = new Bico(bomba2, etanol);
            Bico bico3 = new Bico(bomba3, diesel);
            bicoRepository.saveAll(List.of(bico1, bico2, bico3));
        };
    }
}
