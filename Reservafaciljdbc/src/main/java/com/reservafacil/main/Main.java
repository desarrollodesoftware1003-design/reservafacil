package com.reservafacil.main;

import com.reservafacil.dao.UsuarioDAO;
import com.reservafacil.modelo.Usuario;

public class Main {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        // INSERTAR
        Usuario u = new Usuario("Paula", "paula@mail.com", "123");
        //dao.insertarUsuario(u);

        // CONSULTAR
        dao.listarUsuarios().forEach(user ->
                System.out.println(user.getNombre())
        );
    }
}
