package com.correo.UI.PanelesBuscarUsuario;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTextField;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.Table.TablaUsuarioFormulario;
import com.correo.Table.UsuariosTableModel;
import com.correo.UI.FormularioBuscar;

public class FormularioBuscarUsuario extends FormularioBuscar {
	
	protected TablaUsuarioFormulario tablaUsuarioFormulario;
	protected List<Usuario> usuarios;

	public FormularioBuscarUsuario(Handler handler) {
		super(handler);
	}
	
	public Usuario getIdRegistroSeleccionado(Integer fila) {
		return ((UsuariosTableModel) tablaUsuarioFormulario.getTabla().getModel()).getElement(tablaUsuarioFormulario.getTabla().getSelectedRow());
	}
	
	public int getFilaTabla() {
		return tablaUsuarioFormulario.getTabla().getSelectedRow();
	}
	
	public void getAccionBotonBuscar(Handler handler, JTextField campoTextoHaBuscar) {
		usuarios = handler.buscarUsuario(campoTextoHaBuscar.getText());
		tablaUsuarioFormulario.setUsuariosTableModel(new UsuariosTableModel(usuarios));
		tablaUsuarioFormulario.getTabla().setModel(tablaUsuarioFormulario.getUsuariosTableModel());
		tablaUsuarioFormulario.rePaintScroll();
	}
	
	public void getAccionBotonMostrarTodo(Handler handler) {
		usuarios = handler.mostrarTodoUsuario();
		tablaUsuarioFormulario.setUsuariosTableModel(new UsuariosTableModel(usuarios));
		tablaUsuarioFormulario.getTabla().setModel(tablaUsuarioFormulario.getUsuariosTableModel());
		tablaUsuarioFormulario.rePaintScroll();
	}
	
	public void getTable(Handler handler) {
		tablaUsuarioFormulario = new TablaUsuarioFormulario(handler.mostrarTodoUsuario());
		add(tablaUsuarioFormulario.getScroll(), BorderLayout.CENTER);
	}
}
