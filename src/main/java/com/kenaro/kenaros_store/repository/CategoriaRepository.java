package com.kenaro.kenaros_store.repository;

import com.kenaro.kenaros_store.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
