package com.kenaro.kenaros_store.model;

public class CarritoItem {

    private Producto producto;
    private Integer cantidad;

    public CarritoItem(){
    }

    public CarritoItem(
        Producto producto,
        Integer cantidad){
            this.producto = producto;
            this.cantidad = cantidad;
        }
    public Producto getProducto(){
        return producto;
    }

    public void setProducto(
        Producto producto){
            this.producto = producto;
        }
    
    public Integer getCantidad(){
        return cantidad;
    }

    public void setCantidad(
        Integer cantidad
    ){
        this.cantidad = cantidad;
    }

    public Double getSubtotal(){
        return producto.getPrecio() * cantidad;
    }
}