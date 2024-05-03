package com.correo.BaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.correo.Exceptions.CorreoException;

public class TableManager {
	
	public void createPedidosTable() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "CREATE TABLE PEDIDOS ( id INTEGER IDENTITY, tipo VARCHAR(256), tamano VARCHAR(256), lugar VARCHAR(256), estado VARCHAR(256), id_cliente INTEGER, precio INTEGER, fecha_entregado VARCHAR(256))";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println("Tabla PEDIDOS creada");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Tabla PEDIDOS ya existe", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public void dropPedidosTable() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "DROP TABLE PEDIDOS";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
			System.out.println("Tabla PEDIDOS borrada");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void createUsuariosTable() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "CREATE TABLE USUARIOS ( id_cliente INTEGER IDENTITY, nombre VARCHAR(256), apellido VARCHAR(256), documento INTEGER, nombre_usuario VARCHAR(256), contrasena VARCHAR(256))";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println("Tabla USUARIOS creada");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Tabla USUARIOS ya existe", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public void dropUsuariosTable() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "DROP TABLE USUARIOS";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
			System.out.println("Tabla USUARIOS borrada");
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void createCartasTable() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "CREATE TABLE CARTAS ( id INTEGER IDENTITY, tipo_carta VARCHAR(256))";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println("Tabla CARTAS creada");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new CorreoException("Tabla CARTAS ya existe", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
	
	public void dropCartasTable() throws CorreoException {
		Connection c = DBManager.getInstance().connect();
		String sql = "DROP TABLE CARTAS";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}
}
