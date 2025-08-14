package com.api.sam.controller;

import com.api.sam.model.Mentor;
import com.api.sam.service.MentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    //listar
    @GetMapping("/findAll")
    public ResponseEntity<List<Mentor>> findAll() {
        try {
            var result = mentorService.listAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //buscar por id
    @GetMapping("/findById{id}")
    public ResponseEntity<Mentor> findById(@PathVariable Long id){
        try{
            var result = mentorService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //salvar
    @PostMapping("/save")
    public ResponseEntity<Mentor> save (@RequestBody Mentor mentor){
        try{
            var result = mentorService.save(mentor);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //update
    @PutMapping("update/{id}")
    public ResponseEntity<Mentor> update (@PathVariable Long id, @RequestBody Mentor mentorUpdate){
        try{
            var result = mentorService.update(id, mentorUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable long id){
        try{
            mentorService.delete(id);
            return ResponseEntity.noContent().build(); // 204
        }catch (Exception ex){
            return ResponseEntity.badRequest().build(); // 400
        }
    }



}
