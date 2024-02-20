package com.control.stock.service;

import com.control.stock.entity.Rol;
import com.control.stock.entity.Usuario;
import com.control.stock.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * La clase UsuarioService es un servicio que proporciona métodos para interactuar con los usuarios en la base de datos.
 * Se inyecta el repositorio de usuarios y el codificador de contraseñas para realizar las operaciones de base de datos.
 */
@Service
public class UsuarioService {

    /**
     * Inyección de dependencias del repositorio de usuarios y del codificador de contraseñas.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Autentica a un usuario verificando su correo electrónico y contraseña.
     *
     * @param correo El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @return El Usuario si la autenticación es exitosa, o null si no lo es.
     */
    public Usuario autenticar(String correo, String contrasena){
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null && BCrypt.checkpw(contrasena,usuario.getContrasena())){
            return usuario;
        }
        return null;
    }

    /**
     * Guarda un Usuario en la base de datos. Antes de guardar, codifica la contraseña del usuario.
     *
     * @param usuario El Usuario a guardar.
     * @return El Usuario guardado.
     */
    public Usuario save(Usuario usuario){
        String encoderPassword = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encoderPassword);
        return usuarioRepository.save(usuario);
    }

}
