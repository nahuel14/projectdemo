package com.correo.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.correo.BaseDeDatos.DBManager;
import com.correo.Dao.ClienteDao;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;

public class ClienteImpDao implements ClienteDao {

	public void crearCliente(Cliente cliente) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String nombre = cliente.getNombre();
		String apellido = cliente.getApellido();
		Integer documento = cliente.getDocumento();
		String sql = "INSERT INTO USUARIOS (nombre, apellido, documento) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setInt(3, documento);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la creacion del cliente", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public void ModificarCliente(Cliente cliente) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Integer idCliente = cliente.getIdCliente();
		String nombre = cliente.getNombre();
		String apellido = cliente.getApellido();
		Integer documento = cliente.getDocumento();
		String sql = "UPDATE USUARIOS SET nombre = ?, apellido = ?, documento = ? WHERE id_cliente = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setInt(3, documento);
			stmt.setInt(4, idCliente);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la modificacion del cliente", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Cliente> Buscar(String texto) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente;
		String sql = "SELECT * FROM USUARIOS WHERE id_cliente LIKE ? OR UPPER(nombre) LIKE UPPER(?) OR UPPER(apellido) LIKE UPPER(?) OR documento LIKE ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + texto + "%");
			stmt.setString(2, "%" + texto + "%");
			stmt.setString(3, "%" + texto + "%");
			stmt.setString(4, "%" + texto + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"));
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la busqueda de clientes", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Cliente> MostrarTodo() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "SELECT * FROM USUARIOS";
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente;
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"));
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la muestra de todos los clientes", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public void EliminarCliente(Cliente cliente) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Integer idCliente = cliente.getIdCliente();
		String sql = "DELETE FROM USUARIOS WHERE id_cliente = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo eliminando cliente", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
}
