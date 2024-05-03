package com.correo.Table;

import java.util.List;
import com.correo.Objects.Cliente;

import javax.swing.table.AbstractTableModel;

public class ClientesTableModel extends AbstractTableModel {
	
	private List<Cliente> clientes;
	private String[] titulos = {"Id cliente", "Nombre", "Apellido", "Documento"};
	private final static int id_cliente_col = 0;
	private final static int nombre_col = 1;
	private final static int apellido_col = 2;
	private final static int documento_col = 3;

	public ClientesTableModel(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getRowCount() {
		return clientes.size();
	}

	public int getColumnCount() {
		return titulos.length;
	}

	public Object getValueAt(int row, int column) {
		Cliente cliente = clientes.get(row);
		switch(column) {
			case id_cliente_col:
				return cliente.getIdCliente();
			case nombre_col:
				return cliente.getNombre();
			case apellido_col:
				return cliente.getApellido();
			case documento_col:
				return cliente.getDocumento();
		}
		return "";
	}
	
	public String getColumnName(int column) {
		return titulos[column];
	}
	
	public Cliente getElement(int index) {
		return clientes.get(index);
	}

}