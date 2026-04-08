package com.marcosmontenegro.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DetalleVenta")
public class DetalleVenta {

    @Id
    @Column(name = "codigo_detalle_venta")
    private Integer id;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1)
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El precio unitario es obligatorio")
    @Min(value = 0)
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull(message = "El subtotal es obligatorio")
    @Min(value = 0)
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull(message = "El producto es obligatorio")
    @ManyToOne
    @JoinColumn(name = "FKcodigo_producto", referencedColumnName = "codigo_producto")
    private Producto producto;

    @NotNull(message = "La venta es obligatoria")
    @ManyToOne
    @JoinColumn(name = "FKcodigo_venta", referencedColumnName = "codigo_venta")
    private Venta venta;

// GETTERS AND SETTERS

public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

}
