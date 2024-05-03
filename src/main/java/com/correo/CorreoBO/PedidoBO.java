package com.correo.CorreoBO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.correo.Dao.PedidoDao;
import com.correo.Enum.Estado;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Pedido;

public class PedidoBO {
	private PedidoDao pedidoDao;

	public void crearPedido(Pedido pedido) throws CorreoException {
		validarEstadoYLugar(pedido);
		pedidoDao.CrearPedido(pedido);
	}

	public void modificarPedido(Pedido pedido) throws CorreoException {
		validarEstadoYLugar(pedido);
		ultimoEstado(pedido);
		pedidoDao.ModificarPedido(pedido);
	}
	
	public void eliminarPedido(Pedido pedido) throws CorreoException {
		pedidoDao.EliminarPedido(pedido);
	}
	
	public List<Pedido> mostrarTodoPedido() throws CorreoException {
		List<Pedido> pedidos = pedidoDao.MostrarTodo();
		return pedidos;
	}

	public List<Pedido> buscar(String texto) throws CorreoException {
		return pedidoDao.Buscar(texto);
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	
	public void ultimoEstado(Pedido pedido) {
		String pattern = "dd-MM-yyyy";
		String dateInString;
		if(pedido.getEstado().equals(Estado.entregado)) {
			// INSERTAR CON FECHA DE HOY
			dateInString = new SimpleDateFormat(pattern).format(new Date());
			pedido.setFechaEntregado(dateInString);
			
			// INSERTAR CON PRECIO
			switch(pedido.getTipo()) {
			  case carta:
				switch(pedido.getTamano()) {
				  	case chica:
				  		pedido.setPrecio(100);
				  		break;
				  	case mediana:
				  		pedido.setPrecio(150);
				  		break;
				  	case grande:
				  		pedido.setPrecio(200);
				  		break;
				  	}
				  break;
			  case caja:
				  switch(pedido.getTamano()) {
				  	case chica:
				  		pedido.setPrecio(300);
				  		break;
				  	case mediana:
				  		pedido.setPrecio(350);
				  		break;
				  	case grande:
				  		pedido.setPrecio(400);
				  		break;
				  	}
				  break;
			}
		}
	}
	
	private void validarEstadoYLugar(Pedido pedido) throws CorreoException {
		if(! pedido.getEstado().validateLugar(pedido.getLugar())) {
		      throw new CorreoException("Datos del lugar y el estado incorrectos");
		}
	}

	public Integer calularRecaudacion() throws CorreoException {
		String pattern = "dd-MM-yyyy";
		String dateInString;
		dateInString = new SimpleDateFormat(pattern).format(new Date());
		List<Pedido> listaPrecios = pedidoDao.getPrecioPedidosFecha(dateInString);
		return this.calcularRecaudacion(listaPrecios);
	}
	
	private Integer calcularRecaudacion(List<Pedido> pedidos) {
		Integer suma = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			suma += pedidos.get(i).getPrecio();
		}
		return suma;
	}

}
