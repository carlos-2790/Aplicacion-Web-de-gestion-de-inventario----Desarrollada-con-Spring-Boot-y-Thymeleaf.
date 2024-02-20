package com.control.stock.repository;

import com.control.stock.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La interfaz RolRepository es un repositorio que proporciona métodos CRUD para la entidad Rol.
 * Extiende JpaRepository, lo que significa que hereda una gran cantidad de operaciones, incluyendo métodos básicos de CRUD,
 * así como operaciones de paginación y clasificación.
 *
 * Además, define un método personalizado para buscar un Rol por su nombre.
 */
public interface RolRepository extends JpaRepository<Rol, Long> {
    /**
     * Busca un Rol por su nombre.
     *
     * @param name El nombre del Rol a buscar.
     * @return El Rol con el nombre dado, o null si no se encuentra ningún Rol con ese nombre.
     */
    Rol findByNombre(String name);
}
