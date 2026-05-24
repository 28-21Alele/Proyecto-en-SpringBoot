package com.kenaro.kenaros_store.model;

import jakarta.persistence.*;

@Entity
@Table(name="productos")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 1000)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    private Integer stock;

    private String imagen;

    @ManyToOne
    @JoinColumn( name = "categoria_id")
    private Categoria categoria;

    public  Producto(){
    }

    public Producto(String nombre, String descripcion, Double precio, Integer stock, 
        String imagen, Categoria categoria){

            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.stock = stock;
            this.imagen = imagen;
            this.categoria = categoria;
        }
    
    public Long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public String getImagen(){
        return imagen;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
}
