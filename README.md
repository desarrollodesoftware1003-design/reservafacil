# ReservaFácil 

Aplicación web desarrollada en Java que permite a los usuarios registrarse, iniciar sesión y recuperar su contraseña dentro de un sistema de reservas.

Este proyecto forma parte del proceso de formación en Análisis y Desarrollo de Software.

---

## Funcionalidades principales

* Registro de usuarios
* Inicio de sesión
* Recuperación de contraseña
* Validación de datos desde formularios
* Conexión a base de datos MySQL
* Interfaz moderna y responsiva

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
│       │       ├── LoginServlet.java
│       │       ├── RegistroServlet.java
│       │       └── RecuperarServlet.java
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

## Configuración del proyecto

1. Clonar el repositorio:

```
git clone https://github.com/desarrollodesoftware1003-design/reservafacil.git
```

2. Importar el proyecto en NetBeans

3. Configurar la conexión a la base de datos en los Servlets:

```java
String url = "jdbc:mysql://localhost:3307/reservafacil";
```

4. Ejecutar el proyecto con Apache Tomcat

---

## Base de datos

```sql
CREATE DATABASE reservafacil;

USE reservafacil;

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

---

## Autora

**Paula Villar**
Estudiante de Análisis y Desarrollo de Software - SENA

---

## Estado del proyecto

* Funcional
* Proyecto académico
* Escalable

---

## Mejoras futuras

* Encriptación de contraseñas
* Validación avanzada de formularios
* Sistema de roles (admin / usuario)
* Módulo completo de reservas
* Panel administrativo

---

## Objetivo del proyecto

Este sistema fue desarrollado con el propósito de aplicar conceptos de desarrollo web backend con Java, manejo de bases de datos y diseño de interfaces funcionales.

---
