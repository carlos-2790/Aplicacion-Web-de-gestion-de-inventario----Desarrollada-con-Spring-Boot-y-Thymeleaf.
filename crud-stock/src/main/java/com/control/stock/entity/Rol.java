package com.control.stock.entity;

import jakarta.persistence.*;
/**
 * La clase Rol representa un rol en la aplicación.
 * Se mapea a la tabla "roles" en la base de datos.
 */
@Entity
@Table(name = "roles")
public class Rol {

    /**
     * El ID del rol. Este campo se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El nombre del rol. Este campo es único en la base de datos.
     */
    @Column(unique = true)
    private String nombre;


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

    public Rol() {
    }
}
