package com.br.pdvpostocombustivel.api.abastecimento;

import com.br.pdvpostocombustivel.api.abastecimento.dto.AbastecimentoInputDTO;
import com.br.pdvpostocombustivel.domain.entity.Abastecimento;
import com.br.pdvpostocombustivel.domain.entity.Bico;
import com.br.pdvpostocombustivel.domain.repository.AbastecimentoRepository;
import com.br.pdvpostocombustivel.domain.repository.BicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private BicoRepository bicoRepository;

    public List<Abastecimento> findAll() {
        return abastecimentoRepository.findAll();
    }

    @Transactional
    public Abastecimento save(AbastecimentoInputDTO abastecimentoInput) {
        Bico bico = bicoRepository.findById(abastecimentoInput.getBicoId())
                .orElseThrow(() -> new EntityNotFoundException("Bico não encontrado com o ID: " + abastecimentoInput.getBicoId()));

        Abastecimento novoAbastecimento = new Abastecimento(
                bico,
                abastecimentoInput.getLitros(),
                abastecimentoInput.getPrecoPorLitro(),
                abastecimentoInput.getValorTotal(),
                abastecimentoInput.getFormaPagamento()
        );

        return abastecimentoRepository.save(novoAbastecimento);
    }
}