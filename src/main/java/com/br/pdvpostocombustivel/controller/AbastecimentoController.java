package com.br.pdvpostocombustivel.controller;

import com.br.pdvpostocombustivel.domain.dto.AbastecimentoInputDTO;
import com.br.pdvpostocombustivel.domain.entity.Abastecimento;
import com.br.pdvpostocombustivel.domain.service.AbastecimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abastecimentos")
@Tag(name = "Abastecimento", description = "Endpoints para gerenciar abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @GetMapping
    @Operation(summary = "Listar todos os abastecimentos", description = "Retorna uma lista com todos os abastecimentos registrados.")
    public ResponseEntity<List<Abastecimento>> getAll() {
        return ResponseEntity.ok(abastecimentoService.findAll());
    }

    @PostMapping
    @Operation(summary = "Registrar um novo abastecimento", description = "Cria um novo registro de abastecimento no sistema.")
    public ResponseEntity<Abastecimento> create(@RequestBody AbastecimentoInputDTO abastecimentoInput) {
        Abastecimento novoAbastecimento = abastecimentoService.save(abastecimentoInput);
        return new ResponseEntity<>(novoAbastecimento, HttpStatus.CREATED);
    }
}