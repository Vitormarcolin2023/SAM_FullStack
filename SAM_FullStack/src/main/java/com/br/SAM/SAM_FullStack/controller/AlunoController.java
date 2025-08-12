package com.br.SAM.SAM_FullStack.controller;

import com.br.SAM.SAM_FullStack.model.AlunoModel;
import com.br.SAM.SAM_FullStack.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<AlunoModel>> findAll(){
        try {
            List<AlunoModel> result = alunoService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            // É uma boa prática logar o erro para depuração
            ex.printStackTrace(); // Ou usar um logger: log.error("Erro ao buscar alunos", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // Status 500
        }
    }

    @PostMapping("/save")
    public ResponseEntity<AlunoModel> save(@RequestBody AlunoModel aluno) {
        try {
            AlunoModel result = alunoService.save(aluno);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception ex) {
            // Logar o erro
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // Status 500
        }
    }


}
