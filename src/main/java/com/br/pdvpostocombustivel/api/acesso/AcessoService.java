package com.br.pdvpostocombustivel.api.acesso;

import com.br.pdvpostocombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostocombustivel.api.acesso.dto.AcessoResponse;
import com.br.pdvpostocombustivel.domain.entity.Acesso;
import com.br.pdvpostocombustivel.domain.repository.AcessoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcessoService {

    private final AcessoRepository repository;

    public AcessoService(AcessoRepository repository) {
        this.repository = repository;
    }

    public AcessoResponse create(AcessoRequest req) {
        Acesso novoAcesso = toEntity(req);
        // Aqui você deveria adicionar lógica para criptografar a senha antes de salvar
        return toResponse(repository.save(novoAcesso));
    }

    @Transactional(readOnly = true)
    public AcessoResponse getById(Long id) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));
        return toResponse(a);
    }

    @Transactional(readOnly = true)
    public Page<AcessoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public AcessoResponse update(Long id, AcessoRequest req) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));

        a.setUsuario(req.usuario());
        a.setSenha(req.senha()); // Lembre-se de criptografar

        return toResponse(repository.save(a));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Acesso não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    private Acesso toEntity(AcessoRequest req) {
        return new Acesso(
                req.usuario(),
                req.senha()
        );
    }

    private AcessoResponse toResponse(Acesso a) {
        return new AcessoResponse(
                a.getUsuario()
        );
    }
}
