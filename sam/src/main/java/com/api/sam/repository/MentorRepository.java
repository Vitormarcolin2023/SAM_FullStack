package com.api.sam.repository;

import com.api.sam.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    // Nenhum metodo customizado por enquanto
}
