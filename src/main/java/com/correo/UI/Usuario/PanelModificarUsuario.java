package com.correo.UI.Usuario;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.Botones.ModificarBoton;

public class PanelModificarUsuario extends PanelUsuario {

	public PanelModificarUsuario(Handler handler, Usuario usuario) {
		super(handler, usuario);
	}
	
	public String getTitulo() {
		return "Panel modificar";
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
	}
	
	public JButton getBoton() {
		return new ModificarBoton();
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.modificarUsuario((Usuario) object);
	}
}
