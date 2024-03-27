package com.projeto.biblioteca.repository;

import com.projeto.biblioteca.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    Optional<LivroEntity> getLivroByNome(String nome);
}
