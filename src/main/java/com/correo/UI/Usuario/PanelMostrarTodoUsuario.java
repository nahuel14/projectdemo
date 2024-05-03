package com.correo.UI.Usuario;

import javax.swing.table.AbstractTableModel;

import com.correo.Handler.Handler;
import com.correo.Table.UsuariosTableModel;
import com.correo.UI.PanelMostrarTodo;

public class PanelMostrarTodoUsuario extends PanelMostrarTodo {

	public PanelMostrarTodoUsuario(Handler handler) {
		super(handler);
	}
	
	public AbstractTableModel getTableModel(Handler handler) {
		return new UsuariosTableModel(handler.mostrarTodoUsuario());
	}
}
