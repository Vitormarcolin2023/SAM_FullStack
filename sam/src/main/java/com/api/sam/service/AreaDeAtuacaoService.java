package com.api.sam.service;

import com.api.sam.model.AreaDeAtuacao;
import com.api.sam.repository.AreaDeAtuacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaDeAtuacaoService {

    private final AreaDeAtuacaoRepository areaDeAtuacaoRepository;

    public AreaDeAtuacaoService(AreaDeAtuacaoRepository areaDeAtuacaoRepository) {
        this.areaDeAtuacaoRepository = areaDeAtuacaoRepository;
    }

    // Listar todos
    public List<AreaDeAtuacao> listAll() {
        return areaDeAtuacaoRepository.findAll();
    }

    // Buscar por ID
    public AreaDeAtuacao findById(Long id) {
        return areaDeAtuacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área de atuação não encontrada"));
    }

    // Salvar
    public AreaDeAtuacao save(AreaDeAtuacao areaDeAtuacao) {
        return areaDeAtuacaoRepository.save(areaDeAtuacao);
    }

    // Atualizar
    public AreaDeAtuacao update(Long id, AreaDeAtuacao areaUpdate) {
        AreaDeAtuacao existente = findById(id);
        existente.setNome(areaUpdate.getNome());
        existente.setDescricao(areaUpdate.getDescricao());
        return areaDeAtuacaoRepository.save(existente);
    }

    // Deletar
    public void delete(Long id) {
        AreaDeAtuacao existente = findById(id);
        areaDeAtuacaoRepository.delete(existente);
    }
}
