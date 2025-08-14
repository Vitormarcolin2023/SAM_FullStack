package com.api.sam.service;

import com.api.sam.model.Mentor;
import com.api.sam.repository.MentorRepository;

import java.util.List;

public class MentorService {

    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> listAll(){
        return mentorRepository.findAll();
    }

    public Mentor findById(long id){
        return mentorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Mentor não encontrado"));
    }

    public Mentor save(Mentor mentor) {
        // Regra de negócio: só pode finalizar o cadastro após aprovação da coordenação
        // OBS: Lógica de aprovação será implementada quando a classe Coordenação estiver disponível.

        mentor.setTipoDeVinculo("PENDENTE_APROVACAO"); // Status inicial até coordenação aprovar

        // No futuro, aqui terá a verificação, por exemplo:
        // if (coordenacaoService.aprovou(mentor)) {
        //     mentor.setTipoDeVinculo("COMPLETO");
        // } else {
        //     mentor.setTipoDeVinculo("PENDENTE_APROVACAO");
        // }

        return mentorRepository.save(mentor);
    }

    public Mentor update(Long id, Mentor mentorUpdate){

        Mentor mentorExistente = findById(id);
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
        Mentor mentor = findById(id);
        mentorRepository.delete(mentor);
    }

}
