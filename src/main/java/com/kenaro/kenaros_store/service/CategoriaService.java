package com.kenaro.kenaros_store.service;

import com.kenaro.kenaros_store.model.Categoria;
import com.kenaro.kenaros_store.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> obtenerTodas(){
        return categoriaRepository.findAll();
    }
}