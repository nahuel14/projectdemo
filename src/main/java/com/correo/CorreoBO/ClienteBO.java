package com.correo.CorreoBO;

import java.util.List;

import com.correo.Dao.ClienteDao;
import com.correo.Dao.PedidoDao;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;

public class ClienteBO {
	private ClienteDao clienteDao;
	private PedidoDao pedidoDao;
	
	public void crearCliente(Cliente cliente) throws CorreoException {
		clienteDao.crearCliente(cliente);
	}

	public void eliminarCliente(Cliente cliente) throws CorreoException {
		validarClientesSinPedidos(cliente);
		clienteDao.EliminarCliente(cliente);
	}
	
	public void modificarCliente(Cliente cliente) throws CorreoException {
		clienteDao.ModificarCliente(cliente);	
	}
	
	public List<Cliente> buscarCliente(String texto) throws CorreoException {
		return clienteDao.Buscar(texto);
	}
	
	public List<Cliente> mostrarTodoCliente() throws CorreoException {
		return clienteDao.MostrarTodo();
	}
	
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	
	private void validarClientesSinPedidos(Cliente cliente) throws CorreoException {
		if(!pedidoDao.getPedidosByCliente(cliente).isEmpty()) {
			throw new CorreoException("Cliente relacionado con pedido");
		}
	}
}
