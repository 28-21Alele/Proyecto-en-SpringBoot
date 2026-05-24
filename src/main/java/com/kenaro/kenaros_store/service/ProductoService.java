package com.kenaro.kenaros_store.service;

import com.kenaro.kenaros_store.model.Producto;
import com.kenaro.kenaros_store.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
@Service

public class ProductoService {
    
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public  Producto obtenerPorId(Long id){
    return productoRepository.findById(id)
        .orElse(null);
    }
}