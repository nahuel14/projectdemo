package com.correo.demo;

import org.springframework.stereotype.Service;

import com.correo.CorreoBO.UsuarioBO;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioBO usuarioBO;

    public UsuarioServiceImpl(UsuarioBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

    @Override
    public void crearUsuario(Usuario usuario) throws CorreoException {
        usuarioBO.crearUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws CorreoException {
        usuarioBO.modificarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws CorreoException {
        usuarioBO.eliminarUsuario(usuario);
    }

    @Override
    public void login(String nombreUsuario, String contrasena) throws CorreoException {
        usuarioBO.login(nombreUsuario, contrasena);
    }
}
