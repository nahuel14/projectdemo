package com.correo.Table;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.correo.Objects.Cliente;

public class TablaClienteFormulario {

	private List<Cliente> clientes;
	private ClientesTableModel clientesTableModel;
	private JTable tabla;
	private JScrollPane scroll;

	public TablaClienteFormulario(List<Cliente> clientes) {
		this.clientes = clientes;
		clientesTableModel = new ClientesTableModel(clientes);
		tabla = new JTable(clientesTableModel);
		scroll = new JScrollPane(tabla);
	}
	
	public void rePaintScroll() {
		this.getScroll().repaint();
	}
	
	public Integer getIdRegistroSeleccionado(Integer fila) {
		Cliente cliente = ((ClientesTableModel) tabla.getModel()).getElement(tabla.getSelectedRow());
		return cliente.getIdCliente();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClientesTableModel getClientesTableModel() {
		return clientesTableModel;
	}

	public void setClientesTableModel(ClientesTableModel clientesTableModel) {
		this.clientesTableModel = clientesTableModel;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
}
