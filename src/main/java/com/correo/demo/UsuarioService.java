package com.correo.demo;

import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Usuario;

public interface UsuarioService {
    void crearUsuario(Usuario usuario) throws CorreoException;
    void modificarUsuario(Usuario usuario) throws CorreoException;
    void eliminarUsuario(Usuario usuario) throws CorreoException;
    void login(String nombreUsuario, String contrasena) throws CorreoException;
}
