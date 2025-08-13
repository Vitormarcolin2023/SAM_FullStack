package com.br.SAM.SAM_FullStack.controller;

import com.br.SAM.SAM_FullStack.dto.ErrorResponse;
import com.br.SAM.SAM_FullStack.model.MentorEntity;
import com.br.SAM.SAM_FullStack.service.MentorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentores")
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService){
        this.mentorService = mentorService;
    }

    //listar
    @GetMapping
    public ResponseEntity<?> listAll(){
        try{
            List<MentorEntity> mentorList = mentorService.listAll();
            return ResponseEntity.ok(mentorList);
        }catch (Exception e){
            return new ResponseEntity<>(
             new ErrorResponse("Erro ao listar mentores: " + e.getMessage(),HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId (@PathVariable Long id){
        try{
            MentorEntity mentorEntity = mentorService.buscarPorId(id);
            return ResponseEntity.ok(mentorEntity);
        }catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse("Erro ao buscar mentor: " + e.getMessage(), HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
        }
    }

    //salvar
    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody MentorEntity mentorEntity){
        try{
            MentorEntity mentorSave = mentorService.save(mentorEntity);
            return new ResponseEntity<>(mentorSave, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse("Erro ao salvar mentor: " + e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @Valid @RequestBody MentorEntity mentorUpdate){
        try{
            MentorEntity mentorAtualizado = mentorService.update(id, mentorUpdate);
            return ResponseEntity.ok(mentorAtualizado);
        }catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse("Erro ao atualizar mentor: " + e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            mentorService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return new ResponseEntity<>(new ErrorResponse("Erro ao deletar mentor: " + e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }
}
