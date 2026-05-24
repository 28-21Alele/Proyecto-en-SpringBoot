package com.kenaro.kenaros_store.config;

import com.kenaro.kenaros_store.model.Categoria;
import com.kenaro.kenaros_store.model.Producto;
import com.kenaro.kenaros_store.repository.CategoriaRepository;
import com.kenaro.kenaros_store.repository.ProductoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(
        CategoriaRepository categoriaRepository,
        ProductoRepository productoRepository){

            return args -> {
                if(categoriaRepository.count() > 0 ){
                    return;
                }

                Categoria accion = categoriaRepository.save(new Categoria("Acción"));
                Categoria rpg = categoriaRepository.save(new Categoria ("RPG"));
                Categoria aventura = categoriaRepository.save(new Categoria ("Aventura"));
                Categoria estrategia = categoriaRepository.save(new Categoria( "Estrategia"));
                Categoria sandbox = categoriaRepository.save(new Categoria( "Sandbox"));
                Categoria terror = categoriaRepository.save(new Categoria("Terror"));
                Categoria familiar = categoriaRepository.save(new Categoria("Familiar"));

                productoRepository.save(new Producto(
                    "DOOM",
                    "Shooter frenético contra hordas demoníacas.",
                    39.99,
                    20,
                    "doom.jpg",
                    accion
                ));
                productoRepository.save(new Producto(
                    "Devil May Cry",
                    "Accion hack and slash con combates espectaculares.",
                    49.99,
                    15,
                    "dmc5.jpg",
                    accion
                ));
                productoRepository.save(new Producto(
                    "God of War",
                    "Continuacion de la historia de Kratos en tierras Nórdicas",
                    59.99,
                    12,
                    "gow.jpg",
                    accion
                ));
                productoRepository.save(new Producto(
                    "Ghost of Tsuhima",
                    "I am not your son, I am the Ghost.",
                    59.99,
                    10,
                    "ghost.jpg",
                    aventura
                ));
                productoRepository.save(new Producto(
                    "The Last of Us",
                    "Historia de supervivencia en un mundo postapocalíptico.",
                    49.99,
                    10,
                    "tlou.jpg",
                    aventura
                ));
                productoRepository.save(new Producto(
                    "Bloodborne",
                    "RPG de acción con ambientación gótica.",
                    39.99,
                    8,
                    "bloodborne.jpg",
                    rpg
                ));
                productoRepository.save(new Producto(
                    "Red Dead Redemption 2",
                    "Aventura de mundo abierto en el viejo oeste.",
                    59.99,
                    10,
                    "rdr2.jpg",
                    aventura
                ));
                productoRepository.save(new Producto(
                    "Minecraft",
                    "Juego sandbox de construcción y supervivencia.",
                    29.99,
                    50,
                    "minecraft.jpg",
                    sandbox
                ));
                productoRepository.save(new Producto(
                    "Elden Ring",
                    "RPG de acción desarrollado por FromSoftware.",
                    69.99,
                    10,
                    "eldenring.jpg",
                    rpg
                ));
                productoRepository.save(new Producto(
                    "The Elder Scrolls V: Skyrim",
                    "RPG de fantasía de mundo abierto.",
                    39.99,
                    15,
                    "skyrim.jpg",
                    rpg
                ));
                productoRepository.save(new Producto(
                    "Age of Empires III",
                    "Juego de estrategia en tiempo real.",
                    24.99,
                    15,
                    "aoe3.jpg",
                    estrategia
                ));
                productoRepository.save(new Producto(
                    "Spider-Man",
                    "Aventura de superhéroes en Nueva York.",
                    49.99,
                    12,
                    "spiderman.jpg",
                    aventura
                ));
                productoRepository.save(new Producto(
                    "Resident Evil 4",
                    "Survival horror de acción",
                    59.99,
                    10,
                    "re4.jpg",
                    terror
                ));
                productoRepository.save(new Producto(
                    "Astro Bot",
                    "Plataformas divertido para toda la familia.",
                    39.99,
                    15,
                    "astrobot.jpg",
                    familiar
                ));
                productoRepository.save(new Producto(
                    "Lego Batman",
                    "Aventura cooperativa basada en el universo LEGO",
                    29.99,
                    20,
                    "legobatman.jpg",
                    familiar
                ));
                System.out.println("=== DATOS INICIALES CARGADOS ===");
            };
        }
}