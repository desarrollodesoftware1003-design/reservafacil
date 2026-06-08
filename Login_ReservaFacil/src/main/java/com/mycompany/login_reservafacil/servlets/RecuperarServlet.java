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
import java.util.UUID;
import com.mycompany.login_reservafacil.util.EmailUtil;

@WebServlet("/recuperar")
public class RecuperarServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3307/reservafacil";
    String user = "root";
    String pass = "ae020912";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT * FROM usuarios WHERE correo = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, usuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

            String correo = rs.getString("correo");

            String token = UUID.randomUUID().toString();

            String updateSql = "UPDATE usuarios SET token_recuperacion=? WHERE correo=?";

            PreparedStatement psUpdate =
            con.prepareStatement(updateSql);

            psUpdate.setString(1, token);
            psUpdate.setString(2, correo);

            psUpdate.executeUpdate();

            String enlace = "http://localhost:8080/Login_ReservaFacil/reset-password.html?token="
            + token;

            EmailUtil.enviarCorreo(correo, enlace);

            psUpdate.close();

            response.sendRedirect("recuperar.html?msg=ok");

} else {

            response.sendRedirect("recuperar.html?msg=error");

}

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("recuperar.html?msg=error");
        }
    }
}