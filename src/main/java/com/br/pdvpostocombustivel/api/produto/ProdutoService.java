package com.br.pdvpostocombustivel.api.produto;

import com.br.pdvpostocombustivel.api.produto.dto.ProdutoRequest;
import com.br.pdvpostocombustivel.api.produto.dto.ProdutoResponse;
import com.br.pdvpostocombustivel.domain.entity.Produto;
import com.br.pdvpostocombustivel.domain.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponse create(ProdutoRequest req) {
        Produto novoProduto = toEntity(req);
        return toResponse(repository.save(novoProduto));
    }

    @Transactional(readOnly = true)
    public ProdutoResponse getById(Long id) {
        Produto p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado. id=" + id));
        return toResponse(p);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public ProdutoResponse update(Long id, ProdutoRequest req) {
        Produto p = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado. id=" + id));

        p.setNome(req.nome());
        p.setReferencia(req.referencia());
        p.setFornecedor(req.fornecedor());
        p.setCategoria(req.categoria());
        p.setMarca(req.marca());
        p.setPrecoVenda(req.precoVenda());

        return toResponse(repository.save(p));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    private Produto toEntity(ProdutoRequest req) {
        return new Produto(
                req.nome(),
                req.referencia(),
                req.fornecedor(),
                req.categoria(),
                req.marca(),
                req.precoVenda()
        );
    }

    private ProdutoResponse toResponse(Produto p) {
        return new ProdutoResponse(
                p.getId(), // Corrigido
                p.getNome(),
                p.getReferencia(),
                p.getFornecedor(),
                p.getCategoria(),
                p.getMarca(),
                p.getPrecoVenda()
        );
    }
}
