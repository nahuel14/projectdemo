package com.correo.UI.Usuario;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.Botones.EliminarBoton;

public class PanelEliminarUsuario extends PanelUsuario {

	public PanelEliminarUsuario(Handler handler, Usuario usuario) {
		super(handler, usuario);
	}
	
	public String getTitulo() {
		return "Panel eliminar";
	}
	
	public void getValoresCampos(Object object) {
		Usuario usuario = (Usuario) object;
		getIdCampo().setText(String.valueOf(usuario.getIdCliente()));
		getNombreCampo().setText(String.valueOf(usuario.getNombre()));
		getApellidoCampo().setText(String.valueOf(usuario.getApellido()));
		getDocumentoCampo().setText(String.valueOf(usuario.getDocumento()));
		getNombreUsuarioCampo().setText(String.valueOf(usuario.getNombreUsuario()));
		getContrasenaCampo().setText(String.valueOf(usuario.getContrasena()));
	}
	
	public void getCamposDeshabilitados() {
		getIdCampo().setEnabled(false);
		getNombreCampo().setEnabled(false);
		getApellidoCampo().setEnabled(false);
		getDocumentoCampo().setEnabled(false);
		getNombreUsuarioCampo().setEnabled(false);
		getContrasenaCampo().setEnabled(false);
	}
	
	public JButton getBoton() {
		return new EliminarBoton();
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.eliminarUsuario((Usuario) object);
	}
}
