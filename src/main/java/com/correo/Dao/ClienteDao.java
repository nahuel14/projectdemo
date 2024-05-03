package com.correo.Dao;

import java.util.List;

import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;

public interface ClienteDao {
	public void crearCliente(Cliente cliente) throws CorreoException;
	public void ModificarCliente(Cliente cliente) throws CorreoException;
	public List<Cliente> Buscar(String texto) throws CorreoException;
	public List<Cliente> MostrarTodo() throws CorreoException;
	public void EliminarCliente(Cliente cliente) throws CorreoException;
}
