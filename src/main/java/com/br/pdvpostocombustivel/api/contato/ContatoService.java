package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.repository.ContatoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public ContatoResponse create(ContatoRequest req) {
        Contato novoContato = toEntity(req);
        return toResponse(repository.save(novoContato));
    }

    @Transactional(readOnly = true)
    public ContatoResponse getById(Long id) {
        Contato c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));
        return toResponse(c);
    }

    @Transactional(readOnly = true)
    public Page<ContatoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public ContatoResponse update(Long id, ContatoRequest req) {
        Contato c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id=" + id));

        c.setTelefone(req.telefone());
        c.setEmail(req.email());
        c.setEndereco(req.endereco());

        return toResponse(repository.save(c));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Contato não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    private Contato toEntity(ContatoRequest req) {
        return new Contato(
                req.telefone(),
                req.email(),
                req.endereco()
        );
    }

    private ContatoResponse toResponse(Contato c) {
        return new ContatoResponse(
                c.getTelefone(),
                c.getEmail(),
                c.getEndereco()
        );
    }
}
