# ReservaFácil

Sistema web de reservas de vuelos y hoteles desarrollado con Java, JSP, MySQL y HTML/CSS/JavaScript.

## Funcionalidades

- Registro de usuarios con validación de contraseñas
- Login seguro con sesiones
- Recuperación de contraseña
- Contraseñas encriptadas con BCrypt
- Interfaz responsive adaptada a móviles y escritorio

## Tecnologías utilizadas

| Frontend | Backend | Base de datos |
|----------|---------|---------------|
| HTML5 | Java Servlets | MySQL |
| CSS3 | JSP | XAMPP |
| JavaScript | Maven | phpMyAdmin |
| | BCrypt | |

## Cómo ejecutar el proyecto

1. Clona el repositorio
2. Abre el proyecto en NetBeans como proyecto Maven
3. Inicia MySQL en XAMPP en el puerto 3307
4. Crea la base de datos ejecutando en phpMyAdmin:

```sql
CREATE DATABASE reservafacil;
USE reservafacil;
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

5. Ejecuta el proyecto con el botón Play de NetBeans
6. Abre en el navegador: `http://localhost:8080/Login_ReservaFacil`

## Autora

**Paula Villar**  
Estudiante de Análisis y Desarrollo de Software  
Barranquilla, Colombia
