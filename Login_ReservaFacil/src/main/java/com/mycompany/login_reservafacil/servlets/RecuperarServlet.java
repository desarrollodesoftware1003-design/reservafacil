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
import com.mycompany.login_reservafacil.util.ConfigUtil;

@WebServlet("/recuperar")
public class RecuperarServlet extends HttpServlet {

    private String dbUrl;
    private String dbUser;
    private String dbPass;

    @Override
    public void init() throws ServletException {
        dbUrl = ConfigUtil.get("db.url");
        dbUser = ConfigUtil.get("db.user");
        dbPass = ConfigUtil.get("db.password");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String sql = "SELECT id_usuario, correo FROM usuarios WHERE correo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String correo = rs.getString("correo");
                String token = UUID.randomUUID().toString();

                String updateSql = "UPDATE usuarios SET token_recuperacion=? WHERE correo=?";
                PreparedStatement psUpdate = con.prepareStatement(updateSql);
                psUpdate.setString(1, token);
                psUpdate.setString(2, correo);
                psUpdate.executeUpdate();
                psUpdate.close();

                String enlace = "http://localhost:8080/Login_ReservaFacil/reset-password.html?token=" + token;
                
                EmailUtil.enviarCorreo(correo, enlace);

                response.sendRedirect("recuperar.html?msg=ok");
            } else {
                response.sendRedirect("recuperar.html?msg=error");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("recuperar.html?msg=error");
        }
    }
}