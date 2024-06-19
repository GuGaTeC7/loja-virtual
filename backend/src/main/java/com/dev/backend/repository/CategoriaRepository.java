package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.backend.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
