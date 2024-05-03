package com.correo.UI.Pedido;

import javax.swing.table.AbstractTableModel;

import com.correo.Handler.Handler;
import com.correo.Table.PedidosTableModel;
import com.correo.UI.PanelMostrarTodo;

public class PanelMostrarTodoPedido extends PanelMostrarTodo {
	
	public PanelMostrarTodoPedido(Handler handler) {
		super(handler);
	}
	
	public AbstractTableModel getTableModel(Handler handler) {
		return new PedidosTableModel(handler.mostrarTodoPedido());
	}
}
