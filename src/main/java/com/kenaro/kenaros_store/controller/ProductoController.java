package com.kenaro.kenaros_store.controller;

import com.kenaro.kenaros_store.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.kenaro.kenaros_store.service.CategoriaService;
import com.kenaro.kenaros_store.model.Producto;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(
            @RequestParam(required = false)
            String nombre,

            @RequestParam(required = false)
            Long categoriaId,

            Model model){

                model.addAttribute("productos", productoService.buscarProductos(nombre, categoriaId));

            
            model.addAttribute(
                "categorias", categoriaService.obtenerTodas());

            model.addAttribute("nombre", nombre);
            model.addAttribute("categoriaId", categoriaId);
            return "catalogo";
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
        @GetMapping("/test")
        @ResponseBody
    public String test() {

        return productoService.obtenerTodos()
                .stream()
                .map(p -> p.getNombre())
                .reduce("", (a, b) -> a + "<br>" + b);
    }
}