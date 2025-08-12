package com.br.SAM.SAM_FullStack.service;

import com.br.SAM.SAM_FullStack.model.MentorEntity;
import com.br.SAM.SAM_FullStack.repository.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    public List<MentorEntity> listAll(){
        return mentorRepository.findAll();
    }

    public MentorEntity buscarPorId(long id){
        return mentorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Mentor não encontrado"));
    }

    public MentorEntity save(MentorEntity mentor){
        // Regra de negócio: definir status baseado no telefone
        if (mentor.getTelefone() == null || mentor.getTelefone().isBlank()) {
            mentor.setTipoDeVinculo("INCOMPLETO");
        } else {
            mentor.setTipoDeVinculo("COMPLETO");
        }
        return mentorRepository.save(mentor);
    }

    public MentorEntity update(Long id, MentorEntity mentorUpdate){

        MentorEntity mentorExistente = buscarPorId(id);
        mentorExistente.setNome(mentorUpdate.getNome());
        mentorExistente.setCpf(mentorUpdate.getCpf());
        mentorExistente.setEmail(mentorUpdate.getEmail());
        mentorExistente.setSenha(mentorUpdate.getSenha());
        mentorExistente.setTipoDeVinculo(mentorUpdate.getTipoDeVinculo());
        mentorExistente.setTipoDeUsuario(mentorUpdate.getTipoDeUsuario());
        mentorExistente.setTempoDeExperiencia(mentorUpdate.getTempoDeExperiencia());
        mentorExistente.setAreaDeAtuacao(mentorUpdate.getAreaDeAtuacao());
        //endereco

        return mentorRepository.save(mentorExistente);
    }

    public void delete(Long id){
        MentorEntity mentor = buscarPorId(id);
        mentorRepository.delete(mentor);
    }

}
