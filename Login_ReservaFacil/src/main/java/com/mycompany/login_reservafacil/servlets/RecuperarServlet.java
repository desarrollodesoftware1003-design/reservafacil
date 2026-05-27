package com.mycompany.login_reservafacil.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recuperar")
public class RecuperarServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3307/reservafacil";
    String user = "root";
    String pass = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT * FROM usuarios WHERE usuario = ? OR correo = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, usuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Usuario encontrado
                response.sendRedirect("recuperar.html?msg=ok");
            } else {
                // Usuario no encontrado
                response.sendRedirect("recuperar.html?msg=error");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("recuperar.html?msg=error");
        }
    }
}