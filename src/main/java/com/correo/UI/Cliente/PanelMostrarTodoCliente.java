package com.correo.UI.Cliente;

import javax.swing.table.AbstractTableModel;

import com.correo.Handler.Handler;
import com.correo.Table.ClientesTableModel;
import com.correo.UI.PanelMostrarTodo;

public class PanelMostrarTodoCliente extends PanelMostrarTodo {

	public PanelMostrarTodoCliente(Handler handler) {
		super(handler);
	}
	
	public AbstractTableModel getTableModel(Handler handler) {
		return new ClientesTableModel(handler.mostrarTodoCliente());
	}
}
