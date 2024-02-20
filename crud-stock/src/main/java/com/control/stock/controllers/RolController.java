package com.control.stock.controllers;

import com.control.stock.entity.Rol;
import com.control.stock.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * La clase RolController es un controlador que maneja las solicitudes HTTP relacionadas con los roles.
 * Se mapea a la ruta "/roles" en la aplicación.
 */
@RestController
@RequestMapping("/roles")
public class RolController {

    /**
     * Inyección de dependencias del servicio de roles.
     */
    @Autowired
    private RolService rolService;

    /**
     * Maneja la solicitud GET para obtener todos los roles.
     *
     * @return una lista de todos los roles.
     */
    @GetMapping
    public List<Rol> getAllRoles(){
        return rolService.getAllRoles();
    }


}
