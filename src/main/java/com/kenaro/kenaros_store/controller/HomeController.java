package com.kenaro.kenaros_store.controller;

import com.kenaro.kenaros_store.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    private final ProductoService productoService;

    public HomeController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute(
            "productos",
            productoService.obtenerTodos()
        );
        return "index";
    }
}