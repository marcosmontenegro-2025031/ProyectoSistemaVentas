package com.marcosmontenegro.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer id;

    @NotNull(message = "La fecha es obligatoria")
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @NotNull(message = "El total es obligatorio")
    @DecimalMin(value = "0.0")
    @Column(name = "total")
    private Double total;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado")
    private Integer estado;

    @NotNull(message = "El cliente es obligatorio")
    @ManyToOne
    @JoinColumn(name = "FKdpi_cliente", referencedColumnName = "dpi_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FKcodigo_usuario")
    @JsonIgnoreProperties({"password", "email", "rol", "estado"}) // Ignora estos campos en el JSON
    private Usuario usuario;


// GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
}