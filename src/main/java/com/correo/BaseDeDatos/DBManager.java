package com.correo.BaseDeDatos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	/*
	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver"; // el string
	private static final String DB_URL = "jdbc:hsqldb:file:sql/testdb;shutdown=true;hsqldb.default_table_type=cached"; // contra que base me voy a conectar
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	*/ 
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/nahueltest"; 
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";

	
	private static DBManager dbManager;
	
	private DBManager() {}
	
	public static DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager; 
	}
	
	public Connection connect() {
		Connection c = null;
		if(c == null) {
			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				c.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}

	public void close() throws Exception {
		Connection c = connect();
        Statement s = c.createStatement();
        s.execute("SHUTDOWN");
        c.close();
	}
}
