CREATE DATABASE IF NOT exists stock_productos;
USE stock_productos;

CREATE TABLE IF not exists producto(

id bigint auto_increment primary Key,
nombre varchar(100),
cantidad int,
precio_unitario decimal
);

CREATE TABLE usuarios(
id INT Primary Key auto_increment,
nombre varchar(255) not null,
correo varchar(255)not null,
contrasena varchar(255) not null,
rol_id INT,
constraint FK_usuario_rol foreign key (rol_id) references roles(id)
);

CREATE TABLE roles(
id INT primary key auto_increment,
nombre varchar(255) not null unique
);

CREATE TABLE roles_permisos(
rol_id INT,
permiso_id INT,
foreign key (rol_id) REFERENCES roles(id),
foreign key (permiso_id) references permisos(id)
);

/*INSERT INTO roles (nombre) VALUES ('Administrador');
INSERT INTO roles (nombre) VALUES ('Gerente');
INSERT INTO roles (nombre) VALUES ('Cajero');*/

-- TRUNCATE TABLE usuarios;


/*ALTER TABLE usuarios DROP FOREIGN KEY FKdx3q9geysrtun4ybgi1rptbkx;
ALTER TABLE usuarios DROP COLUMN rol;*/

/*
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Detergente líquido', 50, 2.50);
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador multiusos', 75, 1.60);
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Desinfectante de superficies', 80, 3.30);
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Jabón de manos', 100, 1.00);
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador de vidrios', 120, 1.50);
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador de baño', 9, 2.00); -- Menos de 10 productos
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador de cocina', 7, 1.20); -- Menos de 10 productos
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador de pisos', 6, 2.50); -- Menos de 10 productos
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador de alfombras', 30, 3.00);
INSERT INTO producto (nombre, cantidad, precioUnitario) VALUES ('Limpiador de madera', 40, 2.75);
*/
