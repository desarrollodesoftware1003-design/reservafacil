# ReservaFácil

Sistema web desarrollado en Java que permite a los usuarios registrarse, iniciar sesión y recuperar su contraseña dentro de una plataforma de reservas.

---

## Funcionalidades

✔ Registro de usuarios
✔ Inicio de sesión
✔ Recuperación de contraseña
✔ Conexión a base de datos MySQL
✔ Interfaz moderna con HTML y CSS

---

## Tecnologías utilizadas

* Java (Servlets)
* Apache Tomcat
* MySQL
* HTML5
* CSS3
* Maven

---

## Estructura del proyecto

```
Login_ReservaFacil/
│── src/
│   └── main/
│       ├── java/
│       │   └── com/mycompany/login_reservafacil/servlets/
│       └── webapp/
│           ├── index.html
│           ├── registro.html
│           ├── recuperar.html
│           ├── registro_exitoso.html
│           ├── panel.jsp
│           ├── styles.css
│── pom.xml
```

---

## Configuración

1. Clonar el repositorio:

```
git clone https://github.com/desarrollodesoftware1003-design/reservafacil.git
```

2. Importar el proyecto en NetBeans

3. Configurar la base de datos en MySQL

4. Ejecutar el proyecto con Apache Tomcat

---

## Base de datos

```sql
CREATE DATABASE reservafacil;

USE reservafacil;

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    password VARCHAR(100)
);
```

## Autor

**Paula Villar**
Estudiante de Análisis y Desarrollo de Software - SENA

---

## Estado del proyecto

✔ Funcional
✔ En desarrollo

---

## Mejoras futuras

* Encriptación de contraseñas
* Sistema de roles (administrador/cliente)
* Panel de administración
* Gestión completa de reservas

---
