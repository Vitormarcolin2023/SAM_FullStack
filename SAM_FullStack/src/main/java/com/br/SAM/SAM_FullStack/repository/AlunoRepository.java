package com.br.SAM.SAM_FullStack.repository;

import com.br.SAM.SAM_FullStack.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
