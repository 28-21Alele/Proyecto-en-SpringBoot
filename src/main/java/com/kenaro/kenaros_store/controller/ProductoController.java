package com.kenaro.kenaros_store.controller;

import com.kenaro.kenaros_store.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kenaro.kenaros_store.model.Producto;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {

        model.addAttribute(
                "productos",
                productoService.obtenerTodos()
        );

        return "catalogo";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return productoService.obtenerTodos()
                .stream()
                .map(p -> p.getNombre())
                .reduce("", (a, b) -> a + "<br>" + b);
    }

    @GetMapping("/producto/{id}")
    public String verDetalle(
        @PathVariable Long id,
        Model model){
            Producto producto = productoService.obtenerPorId(id);
        
        if(producto == null){
            return "redirect:/catalogo";
        }
        model.addAttribute("producto", producto);

        return "detalle";
    }
}