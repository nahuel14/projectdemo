package com.correo.UI.Usuario;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.Botones.AltaBoton;

public class PanelAltaUsuario extends PanelUsuario {
	
	public PanelAltaUsuario(Handler handler) {
		super(handler);
	}
	
	public String getTitulo() {
		return "Panel alta";
	}
	
	public void getValoresCampos(Object object) {}
	
	public void getCamposDeshabilitados() {
		getIdCampo().setEnabled(false);
	}
	
	public JButton getBoton() {
		return new AltaBoton();
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.crearUsuario((Usuario) object);
	}
}
