package com.api.sam.service;

import com.api.sam.model.Coordenador;
import com.api.sam.repository.CoordenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    public String save(Coordenador coordenador){
        this.coordenadorRepository.save(coordenador);
        return "Coordenador salvo com sucesso!";
    }

    public String update(Coordenador coordenador, long id){
        coordenador.setId(id);
        this.coordenadorRepository.save(coordenador);
        return "Coordenador atualizado com sucesso!";
    }
}
