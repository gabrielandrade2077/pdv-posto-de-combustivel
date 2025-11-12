package com.br.pdvpostocombustivel.api.bomba;

import com.br.pdvpostocombustivel.api.bomba.dto.BombaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bombas")
@Tag(name = "Bomba", description = "Endpoints para visualizar bombas de combustível")
public class BombaController {

    @Autowired
    private BombaService bombaService;

    @GetMapping
    @Operation(summary = "Listar todas as bombas e seus bicos para o PDV", description = "Retorna uma lista de bombas com seus respectivos bicos e combustíveis, formatada para uso no frontend.")
    public ResponseEntity<List<BombaResponseDTO>> getAllForPdv() {
        return ResponseEntity.ok(bombaService.findAllBombasForPdv());
    }
}