package com.br.SAM.SAM_FullStack.repository;

import com.br.SAM.SAM_FullStack.model.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<MentorEntity, Long> {

    List<MentorEntity> findByNomeIgnoreCaseContaining(String nome);

    List<MentorEntity> findByAreaDeAtuacao(AreaDeAtuacao area);
}
