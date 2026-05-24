package com.kenaro.kenaros_store.repository;

import com.kenaro.kenaros_store.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findByNombreContainingIgnoreCaseAndCategoriaId(
        String nombre,
        Long categoriaId
    );
}
