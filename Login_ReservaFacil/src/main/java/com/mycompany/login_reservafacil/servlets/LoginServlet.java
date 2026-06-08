package com.mycompany.login_reservafacil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

// IMPORTS SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("correo");
        String password = request.getParameter("password");

        String url= "jdbc:mysql://localhost:3307/reservafacil";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
           Connection conexion = DriverManager.getConnection(url, "root", "ae020912");
        String sql = "SELECT nombre, password FROM usuarios WHERE correo=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

        String nombre = rs.getString("nombre");
        String passwordGuardada = rs.getString("password");

        if (BCrypt.checkpw(password, passwordGuardada)) {

        request.getSession().setAttribute("usuario", nombre);
        response.sendRedirect("panel.jsp");

    }   else {

        response.sendRedirect("index.html?error=1");
    }

}       else {

        response.sendRedirect("index.html?error=1");
}

        } catch (IOException | SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}