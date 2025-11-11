package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.dto.BicoResponseDTO;
import com.br.pdvpostocombustivel.domain.dto.BombaResponseDTO;
import com.br.pdvpostocombustivel.domain.dto.ProdutoResponseDTO;
import com.br.pdvpostocombustivel.domain.entity.Bomba;
import com.br.pdvpostocombustivel.domain.repository.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BombaService {

    @Autowired
    private BombaRepository bombaRepository;

    public List<BombaResponseDTO> findAllBombasForPdv() {
        List<Bomba> bombas = bombaRepository.findAll();
        return bombas.stream()
                .map(this::convertToBombaResponseDTO)
                .collect(Collectors.toList());
    }

    private BombaResponseDTO convertToBombaResponseDTO(Bomba bomba) {
        List<BicoResponseDTO> bicosDTO = bomba.getBicos().stream()
                .map(bico -> new BicoResponseDTO(
                        bico.getId(),
                        new ProdutoResponseDTO(bico.getCombustivel().getId(), bico.getCombustivel().getNome(), bico.getCombustivel().getPreco())
                ))
                .collect(Collectors.toList());

        return new BombaResponseDTO(bomba.getId(), bomba.getNumero(), bicosDTO);
    }
}