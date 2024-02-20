package com.control.stock.entity;

import jakarta.persistence.*;

/**
 * La clase Usuario representa un usuario en la aplicación.
 * Se mapea a la tabla "usuarios" en la base de datos.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    /**
     * El ID del usuario. Este campo se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    /**
     * El nombre del usuario.
     */
    private String nombre;

    /**
     * El correo electrónico del usuario.
     */
    private String correo;

    /**
     * La contraseña del usuario.
     */
    private String contrasena;

    /**
     * El rol del usuario. Este campo se mapea a la columna "rol_id" en la tabla "usuarios".
     * La columna "id" en la tabla "rol" es la clave foránea.
     */
@ManyToOne
@JoinColumn(name = "rol_id", referencedColumnName = "id")
private Rol rol;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}