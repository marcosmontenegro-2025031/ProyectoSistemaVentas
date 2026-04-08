package com.marcosmontenegro.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Integer id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Column(name = "nombre_producto")
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0)
    @Column(name = "precio")
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0)
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado")
    private Integer estado;
    
// GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}