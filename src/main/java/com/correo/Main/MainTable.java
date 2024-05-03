package com.correo.Main;

import com.correo.BaseDeDatos.TableManager;
import com.correo.Exceptions.CorreoException;

public class MainTable {

	public static void main(String[] args) {
		
		/* CREAR TABLA (NO va en el main) */
		TableManager tm = new TableManager();
		try {
			tm.createUsuariosTable();
		} catch (CorreoException e) {
			e.printStackTrace();
		}
		try {
			tm.createCartasTable();
		} catch (CorreoException e) {
			e.printStackTrace();
		}
		try {
			tm.createPedidosTable();
		} catch (CorreoException e) {
			e.printStackTrace();
		}
	}
}
