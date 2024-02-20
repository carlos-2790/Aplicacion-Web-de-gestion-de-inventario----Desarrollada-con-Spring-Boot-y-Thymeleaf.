package com.control.stock.controllers;

import com.control.stock.entity.Producto;
import com.control.stock.entity.Usuario;
import com.control.stock.repository.ProductoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * La clase ProductoController es un controlador que maneja las solicitudes HTTP relacionadas con los productos.
 */
@Controller
public class ProductoController {

    /**
     * Inyección de dependencias del repositorio de productos.
     */
    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Maneja la solicitud GET para listar todos los productos.
     */
    @GetMapping("productos")
    public String listarProductos(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() <= 0) {
            return "redirect:/error";
        }
        model.addAttribute("productos", productoRepository.findAll());
        return "productos";
    }

    /**
     * Maneja la solicitud GET para ver un producto específico.
     */
    @GetMapping("/productos/{id}")
    public String verProducto(@PathVariable Long id, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() < 1) {
            return "redirect:/error";
        }
        model.addAttribute("producto", productoRepository.findById(id).orElse(null));
        return "ver_producto";
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de creación de productos.
     */

    @GetMapping("/producto/nuevo")
    public String mostrarFormularioCrearProducto(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() < 2) {
            return "redirect:/error";
        }
        model.addAttribute("producto", new Producto());
        return "crear_producto";
    }

    /**
     * Maneja la solicitud POST para guardar un producto.
     */
    @PostMapping("/guardar")
    public String guardarProducto(Producto producto, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() < 2) {
            return "redirect:/error";
        }
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de edición de productos.
     */
    @GetMapping("/producto/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() < 2) {
            return "redirect:/error";
        }
        model.addAttribute("producto", productoRepository.findById(id).orElse(null));
        return "editar_producto";
    }

    /**
     * Maneja la solicitud POST para actualizar un producto.
     */
    @PostMapping("/producto/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, Producto producto, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() < 2) {
            return "redirect:/error";
        }
        producto.setId(id);
        productoRepository.save(producto);
        return "redirect:/productos";
    }
    /**
     * Maneja la solicitud GET para eliminar un producto.
     */
    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getRol().getId() != 2) {
            return "redirect:/error";
        }
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}