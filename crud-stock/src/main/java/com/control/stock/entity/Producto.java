package com.control.stock.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * La clase Producto representa un producto en la aplicación.
 * Se mapea a la tabla "producto" en la base de datos.
 */
@Entity
@Table(name = "producto")
public class Producto {

    /**
     * El ID del producto. Este campo se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El nombre del producto.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * La cantidad del producto en stock.
     */
    @Column(name = "cantidad")
    private Integer cantidad;

    /**
     * El precio unitario del producto.
     */
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
