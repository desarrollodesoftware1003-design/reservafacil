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

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3307/reservafacil";
    String user = "root";
    String pass = "ae020912";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String token = request.getParameter("token");

        String password = request.getParameter("password");

        String passwordEncriptada =
                BCrypt.hashpw(password, BCrypt.gensalt());

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, pass);

            String sql =
            "UPDATE usuarios SET password=?, token_recuperacion=NULL WHERE token_recuperacion=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, passwordEncriptada);

            ps.setString(2, token);

            int filas = ps.executeUpdate();

            if (filas > 0) {

                response.sendRedirect("index.html?reset=ok");

            } else {

                response.sendRedirect("reset-password.html?error=1");

            }

            ps.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("reset-password.html?error=1");
        }
    }
}