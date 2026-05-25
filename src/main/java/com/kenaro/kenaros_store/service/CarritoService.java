package com.kenaro.kenaros_store.service;

import com.kenaro.kenaros_store.model.CarritoItem;
import com.kenaro.kenaros_store.model.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {
    
    public void agregarProducto(
        List<CarritoItem> carrito,
        Producto producto){
            for(CarritoItem item: carrito){
                if(item.getProducto().getId()
                    .equals(producto.getId())){
                        item.setCantidad(item.getCantidad()+1);

                        return;
                    }
            }
            carrito.add( new CarritoItem(producto,1)
            );
        }
        public void eliminarProducto(
            List<CarritoItem> carrito, Long productoId) {
            carrito.removeIf( 
                item -> item.getProducto()
                .getId()
                .equals(productoId)
            );
        }
        public void vaciarCarrito( 
            List<CarritoItem> carrito){
            carrito.clear();
        }

        public Double calcularTotal(
                List<CarritoItem> carrito) {

            return carrito.stream()
                .mapToDouble(
                        CarritoItem::getSubtotal
            )
            .sum();
}
        public List<CarritoItem> obtenerCarritoVacio(){
            return new ArrayList<>();
        }

        public Integer contarProductos(
            List<CarritoItem> carrito){
                return carrito.stream().mapToInt(CarritoItem::getCantidad).sum();
            }
}