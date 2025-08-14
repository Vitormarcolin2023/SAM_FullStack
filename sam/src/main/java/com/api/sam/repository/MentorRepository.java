package com.api.sam.repository;

import com.api.sam.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    List<Mentor> findByNomeIgnoreCaseContaining(String nome);
    List<Mentor> findByAreaDeAtuacao(AreaDeAtuacao area);
}
