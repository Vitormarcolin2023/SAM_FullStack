package com.br.SAM.SAM_FullStack.controller;

import com.br.SAM.SAM_FullStack.model.MentorEntity;
import com.br.SAM.SAM_FullStack.service.MentorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mentores")
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService){
        this.mentorService = mentorService;
    }

    //listar todos
    @GetMapping
    public ResponseEntity<List<MentorEntity>> listAll(){
        return ResponseEntity.ok(mentorService.listAll());
    }










}
