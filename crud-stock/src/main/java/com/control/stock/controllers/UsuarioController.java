package com.control.stock.controllers;

import com.control.stock.entity.Producto;
import com.control.stock.entity.Rol;
import com.control.stock.entity.Usuario;
import com.control.stock.repository.ProductoRepository;
import com.control.stock.service.RolService;
import com.control.stock.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * La clase UsuarioController es un controlador que maneja las solicitudes HTTP relacionadas con los usuarios.
 */
@Controller
public class UsuarioController {

    /**
     * Inyección de dependencias del servicio de usuarios y roles, y del repositorio de productos.
     */
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Maneja la solicitud GET para mostrar la página de inicio de sesión.
     */
    @GetMapping("/login")
    public String login() {
        return "login/index";
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de registro.
     */
    @GetMapping("/registrar")
    public String mostrarFormRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getAllRoles());
        return "registrar/index";
    }

    /**
     * Maneja la solicitud POST para registrar un nuevo usuario.
     */
    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        Rol rol = rolService.findByNombre(usuario.getRol().getNombre());
        if (rol == null) {
            rol = rolService.save(usuario.getRol());
        }
        usuario.setRol(rol);
        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("success", "Registro exitoso! Por favor inicia sesión.");
        return "redirect:/login";
    }

    /**
     * Maneja la solicitud POST para iniciar sesión.
     */
    @PostMapping("/login")
    public String login(String correo, String contrasena, HttpSession session, Model model) {
        Usuario usuario = usuarioService.autenticar(correo, contrasena);
        if (usuario == null) {
            return "login-error-correo";
        } else if (!BCrypt.checkpw(contrasena, usuario.getContrasena())) {
            return "login-error-contrasena";
        } else {
            session.setAttribute("usuario", usuario);
            Long rolId = usuario.getRol().getId();
            if (rolId == 3) {
                return "redirect:/admin";
            } else if (rolId == 2) {
                model.addAttribute("productos", productoRepository.findAll());
                return "redirect:/gerente";
            } else if (rolId == 1) {
                return "redirect:/cajero";
            } else {
                return "redirect:/error";
            }
        }
    }

    /**
     * Maneja la solicitud GET para mostrar la página de administrador.
     */
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("producto", new Producto()); // Agrega un nuevo Producto al modelo
        return "admin/index";
    }

    /**
     * Maneja la solicitud GET para mostrar la página de cajero.
     */
    @GetMapping("/cajero")
    public String cajero(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("producto", new Producto()); // Agrega un nuevo Producto al modelo
        return "cajero/index";
    }

    /**
     * Maneja la solicitud GET para mostrar la página de gerente.
     */
    @GetMapping("/gerente")
    public String gerente(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("producto", new Producto()); // Agrega un nuevo Producto al modelo
        return "gerente/index";
    }
}
