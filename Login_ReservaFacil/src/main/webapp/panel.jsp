<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ReservaFácil - Panel</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="panel.css">
</head>
<body class="panel-body">
    <%
        if(session.getAttribute("usuario") == null){
            response.sendRedirect("index.html");
            return;
        }
        String usuario = (String) session.getAttribute("usuario");
    %>

    <!-- NAVBAR -->
    <nav class="panel-nav">
        <span class="panel-logo">ReservaFácil</span>
        <div class="panel-usuario">
            <span>Hola, <%= usuario %></span>
            <a href="logout" class="btn-logout">Cerrar sesión</a>
        </div>
    </nav>

    <!-- CONTENIDO -->
    <main class="panel-main">
        <h2 class="panel-bienvenida">Bienvenido, <%= usuario %></h2>
        <p class="panel-subtitulo">¿Qué quieres hacer hoy?</p>

        <div class="panel-cards">
            <a href="vuelos.jsp" class="panel-card">
                <div class="card-icono">✈️</div>
                <h3>Buscar Vuelos</h3>
                <p>Encuentra el vuelo ideal para tu próximo destino</p>
            </a>
            <a href="hoteles.jsp" class="panel-card">
                <div class="card-icono">🏨</div>
                <h3>Buscar Hoteles</h3>
                <p>Reserva el alojamiento perfecto donde quieras</p>
            </a>
            <a href="reservas.jsp" class="panel-card">
                <div class="card-icono">📋</div>
                <h3>Mis Reservas</h3>
                <p>Consulta y gestiona todas tus reservas activas</p>
            </a>
        </div>
    </main>
</body>
</html>