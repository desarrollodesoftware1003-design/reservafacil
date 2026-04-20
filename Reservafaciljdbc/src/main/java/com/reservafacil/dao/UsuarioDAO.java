package com.reservafacil.dao;

import com.reservafacil.conexion.ConexionBD;
import com.reservafacil.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // INSERTAR
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario(usuario, correo, password) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPassword());
            ps.executeUpdate();

            System.out.println("Usuario insertado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // CONSULTAR
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));

                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET usuario=?, correo=?, password=? WHERE id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getId());

            ps.executeUpdate();
            System.out.println("Usuario actualizado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Usuario eliminado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
