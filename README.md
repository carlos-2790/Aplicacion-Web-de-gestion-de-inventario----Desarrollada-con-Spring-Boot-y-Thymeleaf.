# aplicacion-web-de-gestion-de-inventario-desarrollada-con-Spring-Boot-y-Thymeleaf.
Este proyecto es una aplicación web de gestión de inventario desarrollada con Spring Boot y Thymeleaf. La aplicación permite a los usuarios interactuar con una base de datos de productos, roles y usuarios.
Aquí hay una descripción más detallada:

Entidades:

Producto: Representa un producto en la base de datos con atributos como id, nombre, cantidad y precio unitario.
Rol: Representa un rol de usuario en la aplicación.
Usuario: Representa un usuario en la aplicación con atributos como id, nombre, correo electrónico, contraseña y rol.
Repositorios:

ProductoRepository: Proporciona métodos CRUD para la entidad Producto.
RolRepository: Proporciona métodos CRUD para la entidad Rol, incluyendo un método personalizado para buscar un Rol por su nombre.
UsuarioRepository: Proporciona métodos CRUD para la entidad Usuario, incluyendo un método personalizado para buscar un Usuario por su correo electrónico.
Servicios:

RolService: Proporciona métodos para interactuar con los roles en la base de datos.
UsuarioService: Proporciona métodos para interactuar con los usuarios en la base de datos, incluyendo un método para autenticar a un usuario.
Controladores:

ProductoController: Maneja las solicitudes HTTP relacionadas con los productos.
RolController: Maneja las solicitudes HTTP relacionadas con los roles.
UsuarioController: Maneja las solicitudes HTTP relacionadas con los usuarios, incluyendo el inicio de sesión y el registro de usuarios.
La aplicación utiliza Thymeleaf para la generación de vistas HTML en el servidor, Bootstrap para el diseño y estilos CSS personalizados para la estética. La seguridad de las contraseñas de los usuarios se maneja mediante BCrypt.

