Sistema de Gestión de Ventas

Este proyecto es una aplicación web diseñada para la administración eficiente de inventarios, transacciones comerciales y control de usuarios. Está desarrollado con el ecosistema de Spring y sigue el patrón de diseño Modelo-Vista-Controlador (MVC).

Funcionalidades Principales

Control de Acceso y Seguridad

* Autenticación de usuarios mediante validación de credenciales.
* Manejo de sesiones activas con HttpSession.
* Control de permisos según roles: ADMIN y VENDEDOR.
* Registro de nuevos usuarios en el sistema.

Gestión de Usuarios y Perfil

* Edición de datos personales: nombre de usuario, correo y contraseña.
* Carga de imagen para foto de perfil.
* Visualización de avatar dinámico en encabezado y menú lateral.

Operaciones de Negocio

Inventario

* Registro de productos (altas).
* Eliminación de productos (bajas).
* Actualización de información (modificaciones).

Ventas

* Registro de transacciones comerciales.
* Generación de comprobantes de venta.

Clientes

* Administración de clientes frecuentes.
* Gestión de la base de datos de compradores.

Reportes

* Consulta detallada de ventas realizadas.
* Apoyo para auditorías internas.

Tecnologías Utilizadas

* Backend: Java con Spring Boot 3 (Spring Data JPA, Spring Web).
* Frontend: HTML5, CSS3, JavaScript y Thymeleaf.
* Base de Datos: MySQL (con procedimientos almacenados).
* Estilos: CSS personalizado y FontAwesome para iconografía.

Estructura del Proyecto

* Entity: Representación de tablas de la base de datos (Usuario, Producto, etc.).
* Repository: Interfaces para acceso y persistencia de datos con Spring Data.
* Service: Lógica de negocio que conecta controladores con repositorios.
* Controller: Manejo de rutas y peticiones HTTP.
* Resources: Archivos estáticos, plantillas Thymeleaf, CSS e imágenes.

Requisitos de Instalación

1. Tener instalado Java JDK 17 o superior.
2. Instalar MySQL Server.
3. Ejecutar el script de base de datos incluido para crear tablas y procedimientos.
