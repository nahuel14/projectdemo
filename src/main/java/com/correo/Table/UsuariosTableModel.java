package com.correo.Table;

import java.util.List;
import com.correo.Objects.Usuario;

import javax.swing.table.AbstractTableModel;

public class UsuariosTableModel extends AbstractTableModel {
	
	private List<Usuario> usuarios;
	private String[] titulos = {"Id cliente", "Nombre", "Apellido", "Documento", "Nombre de usuario"};
	private final static int id_cliente_col = 0;
	private final static int nombre_col = 1;
	private final static int apellido_col = 2;
	private final static int documento_col = 3;
	private final static int usuario_nombre_col = 4;

	public UsuariosTableModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public int getRowCount() {
		return usuarios.size();
	}

	public int getColumnCount() {
		return titulos.length;
	}

	public Object getValueAt(int row, int column) {
		Usuario usuario = usuarios.get(row);
		switch(column) {
			case id_cliente_col:
				return usuario.getIdCliente();
			case nombre_col:
				return usuario.getNombre();
			case apellido_col:
				return usuario.getApellido();
			case documento_col:
				return usuario.getDocumento();
			case usuario_nombre_col:
				return usuario.getNombreUsuario();
		}
		return "";
	}
	
	public String getColumnName(int column) {
		return titulos[column];
	}
	
	public Usuario getElement(int index) {
		return usuarios.get(index);
	}

}
