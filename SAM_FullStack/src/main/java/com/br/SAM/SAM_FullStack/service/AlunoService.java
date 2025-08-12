package com.br.SAM.SAM_FullStack.service;

import com.br.SAM.SAM_FullStack.model.AlunoModel;
import com.br.SAM.SAM_FullStack.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    private EmailService emailService;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoModel> findAll(){
        return alunoRepository.findAll();
    }


    public AlunoModel save(AlunoModel aluno){
        emailService.enviarEmailTexto(aluno.getEmail(), "Novo aluno cadastrado", "Aluno: "+ aluno.getNome()+", RA: "+ aluno.getRa() +" cadastrado com sucesso");
        return  alunoRepository.save(aluno);
    }

}

