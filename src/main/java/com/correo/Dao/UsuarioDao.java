package com.correo.Dao;

import java.util.List;

import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Usuario;

public interface UsuarioDao {
	public void CrearUsuario(Usuario usuario) throws CorreoException;
	public void ModificarUsuario(Usuario usuario) throws CorreoException;
	public List<Usuario> Buscar(String texto) throws CorreoException;
	public List<Usuario> MostrarTodo() throws CorreoException;
	public void EliminarUsuario(Usuario usuario) throws CorreoException;
	public Usuario getUsuarioByNombreAndPass(String nombreUsuario, String contrasena) throws CorreoException;
	public String getNombreUsuario(Usuario usuario) throws CorreoException;
}
