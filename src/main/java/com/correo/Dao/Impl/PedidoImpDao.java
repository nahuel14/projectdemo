package com.correo.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.correo.BaseDeDatos.DBManager;
import com.correo.Dao.PedidoDao;
import com.correo.Enum.Estado;
import com.correo.Enum.Lugar;
import com.correo.Enum.Tamano;
import com.correo.Enum.Tipo;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;
import com.correo.Objects.Pedido;

public class PedidoImpDao implements PedidoDao {
	
	public void CrearPedido(Pedido pedido) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Tipo tipo = pedido.getTipo();
		Tamano tamano = pedido.getTamano();
		Estado estado = pedido.getEstado();
		Lugar lugar = pedido.getLugar();
		Integer idCliente = pedido.getCliente().getIdCliente();
		Integer precio = pedido.getPrecio();
		String fechaEntregado = pedido.getFechaEntregado();
		String sql = "INSERT INTO PEDIDOS (tipo, tamano, estado, lugar, id_cliente, precio, fecha_entregado) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, tipo.name());
			stmt.setString(2, tamano.name());
			stmt.setString(3, estado.name());
			stmt.setString(4, lugar.name());
			stmt.setInt(5, idCliente);
			stmt.setInt(6, precio);
			stmt.setString(7, fechaEntregado);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la creacion del pedido", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public void ModificarPedido(Pedido pedido) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Integer id = pedido.getId();
		Tipo tipo = pedido.getTipo();
		Tamano tamano = pedido.getTamano();
		Estado estado = pedido.getEstado();
		Lugar lugar = pedido.getLugar();
		Integer idCliente = pedido.getCliente().getIdCliente();
		Integer precio = pedido.getPrecio();
		String fechaEntregado = pedido.getFechaEntregado();
		String sql = "UPDATE PEDIDOS SET tipo = ?, tamano = ?, estado = ?, lugar = ?, id_cliente = ?, precio = ?, fecha_entregado = ? WHERE id = ?";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, tipo.name());
			stmt.setString(2, tamano.name());
			stmt.setString(3, estado.name());
			stmt.setString(4, lugar.name());
			stmt.setInt(5, idCliente);
			stmt.setInt(6, precio);
			stmt.setString(7, fechaEntregado);
			stmt.setInt(8, id);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la modificacion del pedido", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Pedido> Buscar(String texto) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido;
		Cliente cliente;
		String sql = "SELECT * FROM PEDIDOS P INNER JOIN USUARIOS U ON P.id_cliente = U.id_cliente WHERE id LIKE ? OR UPPER(tipo) LIKE UPPER(?) OR UPPER(tamano) LIKE UPPER(?) OR UPPER(estado) LIKE UPPER(?) OR UPPER(lugar) LIKE UPPER(?) OR id_cliente LIKE ? OR precio LIKE ? OR fecha_entregado LIKE ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + texto + "%");
			stmt.setString(2, "%" + texto + "%");
			stmt.setString(3, "%" + texto + "%");
			stmt.setString(4, "%" + texto + "%");
			stmt.setString(5, "%" + texto + "%");
			stmt.setString(6, "%" + texto + "%");
			stmt.setString(7, "%" + texto + "%");
			stmt.setString(8, "%" + texto + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"));
				pedido = new Pedido(rs.getInt("id"), Tipo.valueOf(rs.getString("tipo")), Tamano.valueOf(rs.getString("tamano")), Estado.valueOf(rs.getString("estado")), Lugar.valueOf(rs.getString("lugar")), cliente, rs.getInt("precio"), rs.getString("fecha_entregado"));
				pedidos.add(pedido);
			}
			return pedidos;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la busqueda de pedidos", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Pedido> MostrarTodo() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido;
		Cliente cliente;
		String sql = "SELECT * FROM PEDIDOS P INNER JOIN USUARIOS U ON P.id_cliente = U.id_cliente";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"));
				pedido = new Pedido(rs.getInt("id"), Tipo.valueOf(rs.getString("tipo")), Tamano.valueOf(rs.getString("tamano")), Estado.valueOf(rs.getString("estado")), Lugar.valueOf(rs.getString("lugar")), cliente, rs.getInt("precio"), rs.getString("fecha_entregado"));
				pedidos.add(pedido);
			}
			return pedidos;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la muestra de todos los pedidos", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public void EliminarPedido(Pedido pedido) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Integer id = pedido.getId();
		String sql = "DELETE FROM PEDIDOS WHERE id = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo eliminando pedido", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public List<Pedido> getPrecioPedidosFecha(String fecha) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido;
		Cliente cliente;
		String sql = "SELECT * FROM PEDIDOS P INNER JOIN USUARIOS U ON P.id_cliente = U.id_cliente WHERE fecha_entregado = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, fecha);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"));
				pedido = new Pedido(rs.getInt("id"), Tipo.valueOf(rs.getString("tipo")), Tamano.valueOf(rs.getString("tamano")), Estado.valueOf(rs.getString("estado")), Lugar.valueOf(rs.getString("lugar")), cliente, rs.getInt("precio"), rs.getString("fecha_entregado"));
				pedidos.add(pedido);
			}
			return pedidos;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la busqueda de pedidos", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Pedido> getPedidosByCliente(Cliente cliente) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido;
		String sql = "SELECT * FROM PEDIDOS WHERE ID_CLIENTE = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, cliente.getIdCliente());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pedido = new Pedido(rs.getInt("id"), Tipo.valueOf(rs.getString("tipo")), Tamano.valueOf(rs.getString("tamano")), Estado.valueOf(rs.getString("estado")), Lugar.valueOf(rs.getString("lugar")), cliente, rs.getInt("precio"), rs.getString("fecha_entregado"));
				pedidos.add(pedido);
			}
			return pedidos;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo buscando pedidos por cliente", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
}
