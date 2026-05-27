package com.mycompany.login_reservafacil.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3307/reservafacil?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String confirmarPassword = request.getParameter("confirmarPassword");
        
        if (!password.equals(confirmarPassword)) {
        response.sendRedirect("registro.html?error=1");
        return;
    }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO usuarios (usuario, correo, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, correo);
            String passwordEncriptada = BCrypt.hashpw(password, BCrypt.gensalt());
            ps.setString(3, passwordEncriptada);

            ps.executeUpdate();

            ps.close();
            con.close();

            // Redirige a página de éxito
            response.sendRedirect("registro_exitoso.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registro.html?error=1");
        }
    }
}