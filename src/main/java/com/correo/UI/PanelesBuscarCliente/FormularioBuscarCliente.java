package com.correo.UI.PanelesBuscarCliente;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTextField;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.Table.ClientesTableModel;
import com.correo.Table.TablaClienteFormulario;
import com.correo.UI.FormularioBuscar;

public class FormularioBuscarCliente extends FormularioBuscar {

	protected TablaClienteFormulario tablaClienteFormulario;
	protected List<Cliente> clientes;

	public FormularioBuscarCliente(Handler handler) {
		super(handler);
	}

	public Cliente getIdRegistroSeleccionado(Integer fila) {
		return ((ClientesTableModel) tablaClienteFormulario.getTabla().getModel()).getElement(tablaClienteFormulario.getTabla().getSelectedRow());
	}
	
	public int getFilaTabla() {
		return tablaClienteFormulario.getTabla().getSelectedRow();
	}

	public void getAccionBotonBuscar(Handler handler, JTextField campoTextoHaBuscar) {
		clientes = handler.buscarCliente(campoTextoHaBuscar.getText());
		tablaClienteFormulario.setClientesTableModel(new ClientesTableModel(clientes));
		tablaClienteFormulario.getTabla().setModel(tablaClienteFormulario.getClientesTableModel());
		tablaClienteFormulario.rePaintScroll();
	}

	public void getAccionBotonMostrarTodo(Handler handler) {
		clientes = handler.mostrarTodoCliente();
		tablaClienteFormulario.setClientesTableModel(new ClientesTableModel(clientes));
		tablaClienteFormulario.getTabla().setModel(tablaClienteFormulario.getClientesTableModel());
		tablaClienteFormulario.rePaintScroll();
	}
	
	public void getTable(Handler handler) {
		tablaClienteFormulario = new TablaClienteFormulario(handler.mostrarTodoCliente());
		add(tablaClienteFormulario.getScroll(), BorderLayout.CENTER);
	}
}
