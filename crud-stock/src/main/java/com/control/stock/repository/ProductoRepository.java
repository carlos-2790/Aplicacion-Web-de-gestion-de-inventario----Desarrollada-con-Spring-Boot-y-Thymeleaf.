package com.control.stock.repository;

import com.control.stock.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * La interfaz ProductoRepository es un repositorio que proporciona métodos CRUD para la entidad Producto.
 * Extiende JpaRepository, lo que significa que hereda una gran cantidad de operaciones, incluyendo métodos básicos de CRUD,
 * así como operaciones de paginación y clasificación.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
