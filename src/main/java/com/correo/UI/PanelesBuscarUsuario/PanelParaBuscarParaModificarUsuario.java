package com.correo.UI.PanelesBuscarUsuario;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.Botones.ModificarBoton;

public class PanelParaBuscarParaModificarUsuario extends PanelParaBuscarGeneralUsuario {

	public PanelParaBuscarParaModificarUsuario(Handler handler) {
		super(handler);
	}
	
	public JButton getBoton() {
        return new ModificarBoton();
	}
	
	public void ejectutarAccion(Handler handler, Usuario usuario) {
		handler.abrirPanelModificarUsuario(usuario);
	}
	
	public String getTitulo() {
		return "Buscar para modificar";
	}
}
