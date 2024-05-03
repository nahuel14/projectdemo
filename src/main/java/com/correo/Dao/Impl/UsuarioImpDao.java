package com.correo.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.correo.BaseDeDatos.DBManager;
import com.correo.Dao.UsuarioDao;

import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Usuario;

public class UsuarioImpDao implements UsuarioDao {
	
	public void CrearUsuario(Usuario usuario) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String nombre = usuario.getNombre();
		String apellido = usuario.getApellido();
		Integer documento = usuario.getDocumento();
		String nombreUsuario = usuario.getNombreUsuario();
		String contrasena = usuario.getContrasena();
		String sql = "INSERT INTO USUARIOS (nombre, apellido, documento, nombre_usuario, contrasena) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setInt(3, documento);
			stmt.setString(4, nombreUsuario);
			stmt.setString(5, contrasena);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la creacion del usuario", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public void ModificarUsuario(Usuario usuario) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Integer idCliente = usuario.getIdCliente();
		String nombre = usuario.getNombre();
		String apellido = usuario.getApellido();
		Integer documento = usuario.getDocumento();
		String nombreUsuario = usuario.getNombreUsuario();
		String contrasena = usuario.getContrasena();
		String sql = "UPDATE USUARIOS SET nombre = ?, apellido = ?, documento = ?, nombre_usuario = ?, contrasena = ? WHERE id_cliente = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setInt(3, documento);
			stmt.setString(4, nombreUsuario);
			stmt.setString(5, contrasena);
			stmt.setInt(6, idCliente);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la modificacion del usuario", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Usuario> Buscar(String texto) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario;
		String sql = "SELECT * FROM USUARIOS WHERE id_cliente LIKE ? OR UPPER(nombre) LIKE UPPER(?) OR UPPER(apellido) LIKE UPPER(?) OR documento LIKE ? OR UPPER(nombre_usuario) LIKE UPPER(?)";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + texto + "%");
			stmt.setString(2, "%" + texto + "%");
			stmt.setString(3, "%" + texto + "%");
			stmt.setString(4, "%" + texto + "%");
			stmt.setString(5, "%" + texto + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuario = new Usuario(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"), rs.getString("nombre_usuario"), rs.getString("contrasena"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la busqueda de usuarios", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public List<Usuario> MostrarTodo() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "SELECT * FROM USUARIOS;";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario;
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				usuario = new Usuario(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"), rs.getString("nombre_usuario"), rs.getString("contrasena"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo la muestra de todos los usuarios", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	public void EliminarUsuario(Usuario usuario) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		Integer idCliente = usuario.getIdCliente();
		String sql = "DELETE FROM USUARIOS WHERE id_cliente = ?;";
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			stmt.execute();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo eliminando usuario", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public Usuario getUsuarioByNombreAndPass(String nombreUsuario, String contrasena) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "SELECT * FROM USUARIOS WHERE nombre_usuario = ? AND contrasena = ?;";
		Usuario usuario = null;
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, nombreUsuario);
			stmt.setString(2, contrasena);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("documento"), rs.getString("nombre_usuario"), rs.getString("contrasena"));
			}
			return usuario;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo validando usuario", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public String getNombreUsuario(Usuario usuario) throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String nombre_usuario = null;
		String sql = "SELECT nombre_usuario FROM USUARIOS WHERE nombre_usuario = ?;";
		if(usuario.getIdCliente() != null) {
			sql = "SELECT nombre_usuario FROM USUARIOS WHERE nombre_usuario = ? and id_cliente != ?;";
		}
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			if(usuario.getIdCliente() != null) {
				stmt.setInt(2, usuario.getIdCliente());	
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				nombre_usuario = rs.getString("nombre_usuario");
			}
			return nombre_usuario;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Fallo buscando nombre de usuario", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
}
