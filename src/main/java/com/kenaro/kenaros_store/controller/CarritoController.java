package com.kenaro.kenaros_store.controller;

import com.kenaro.kenaros_store.model.CarritoItem;
import com.kenaro.kenaros_store.model.Producto;
import com.kenaro.kenaros_store.service.CarritoService;
import com.kenaro.kenaros_store.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class CarritoController {
    private final CarritoService carritoService;
    private final ProductoService productoService;

    public CarritoController( CarritoService carritoService,
        ProductoService productoService
    ){
        this.carritoService = carritoService;
        this.productoService = productoService;
    }

    @SuppressWarnings("unchecked")
    private List<CarritoItem> obtenerCarrito(HttpSession session){
        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute("carrito");

    if (carrito == null){
        carrito = carritoService.obtenerCarritoVacio();

        session.setAttribute("carrito", carrito);
    }
        return carrito;
    }

    @GetMapping("/agregar-carrito/{id}")
    public String agregarProducto(
        @PathVariable Long id,
        HttpSession session){

            Producto producto = productoService.obtenerPorId(id);
        if (producto != null){

            List<CarritoItem> carrito = obtenerCarrito(session);

            carritoService.agregarProducto(carrito, producto);
            }
            return "redirect:/carrito";
        }
    @GetMapping("/carrito")
    public String verCarrito( HttpSession session, Model model){
        List<CarritoItem> carrito = obtenerCarrito(session);

        model.addAttribute("items", carrito);

        model.addAttribute("total", carritoService.calcularTotal(carrito)
    );
        return "carrito";
    }
    @GetMapping("/eliminar-carrito/{id}")
    public String eliminarProducto(
        @PathVariable Long id, HttpSession session){
            List<CarritoItem> carrito = obtenerCarrito(session);

            carritoService.eliminarProducto(carrito, id
            );
            return "redirect:/carrito";
        }
    @GetMapping("/vaciar-carrito")
    public String vaciarCarrito(
        HttpSession session){
            List<CarritoItem> carrito = obtenerCarrito(session);

                carritoService.vaciarCarrito(carrito);

                return "redirect:/carrito";
        }
}