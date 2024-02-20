package com.control.stock.repository;

import com.control.stock.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La interfaz UsuarioRepository es un repositorio que proporciona métodos CRUD para la entidad Usuario.
 * Extiende JpaRepository, lo que significa que hereda una gran cantidad de operaciones, incluyendo métodos básicos de CRUD,
 * así como operaciones de paginación y clasificación.
 *
 * Además, define un método personalizado para buscar un Usuario por su correo electrónico.
 */
public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {

    /**
     * Busca un Usuario por su correo electrónico.
     *
     * @param correo El correo electrónico del Usuario a buscar.
     * @return El Usuario con el correo electrónico dado, o null si no se encuentra ningún Usuario con ese correo electrónico.
     */
    Usuario findByCorreo(String correo);
}
