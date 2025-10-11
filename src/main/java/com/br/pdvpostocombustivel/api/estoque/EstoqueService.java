package com.br.pdvpostocombustivel.api.estoque;

import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueResponse;
import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.repository.EstoqueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstoqueService {

    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    public EstoqueResponse create(EstoqueRequest req) {
        Estoque novoEstoque = toEntity(req);
        return toResponse(repository.save(novoEstoque));
    }

    @Transactional(readOnly = true)
    public EstoqueResponse getById(Long id) {
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id=" + id));
        return toResponse(e);
    }

    @Transactional(readOnly = true)
    public Page<EstoqueResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public EstoqueResponse update(Long id, EstoqueRequest req) {
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id=" + id));

        e.setQuantidade(req.quantidade());
        e.setLocalTanque(req.localTanque());
        e.setLocalEndereco(req.localEndereco());
        e.setLoteFabricacao(req.loteFabricacao());
        e.setDataValidade(req.dataValidade());

        return toResponse(repository.save(e));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Estoque não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    private Estoque toEntity(EstoqueRequest req) {
        return new Estoque(
                req.quantidade(),
                req.localTanque(),
                req.localEndereco(),
                req.loteFabricacao(),
                req.dataValidade()
        );
    }

    private EstoqueResponse toResponse(Estoque e) {
        return new EstoqueResponse(
                e.getQuantidade(),
                e.getLocalTanque(),
                e.getLocalEndereco(),
                e.getLoteFabricacao(),
                e.getDataValidade()
        );
    }
}
