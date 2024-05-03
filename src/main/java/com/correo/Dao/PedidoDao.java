package com.correo.Dao;

import java.util.List;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;
import com.correo.Objects.Pedido;

public interface PedidoDao {
	public void CrearPedido(Pedido pedido) throws CorreoException;
	public void ModificarPedido(Pedido pedido) throws CorreoException;
	public List<Pedido> Buscar(String texto) throws CorreoException;
	public List<Pedido> MostrarTodo() throws CorreoException;
	public void EliminarPedido(Pedido pedido) throws CorreoException;
	public List<Pedido> getPrecioPedidosFecha(String fecha) throws CorreoException;
	public List<Pedido> getPedidosByCliente(Cliente cliente) throws CorreoException;
}
