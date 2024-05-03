package com.correo.Table;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.correo.Objects.Usuario;

public class TablaUsuarioFormulario {
	
	private List<Usuario> usuarios;
	private UsuariosTableModel usuariosTableModel;
	private JTable tabla;
	private JScrollPane scroll;

	public TablaUsuarioFormulario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
		usuariosTableModel = new UsuariosTableModel(usuarios);
		tabla = new JTable(usuariosTableModel);
		scroll = new JScrollPane(tabla);
	}
	
	public void rePaintScroll() {
		this.getScroll().repaint();
	}
	
	public Integer getIdRegistroSeleccionado(Integer fila) {
		Usuario usuario = ((UsuariosTableModel) tabla.getModel()).getElement(tabla.getSelectedRow());
		return usuario.getIdCliente();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuariosTableModel getUsuariosTableModel() {
		return usuariosTableModel;
	}

	public void setUsuariosTableModel(UsuariosTableModel usuariosTableModel) {
		this.usuariosTableModel = usuariosTableModel;
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
