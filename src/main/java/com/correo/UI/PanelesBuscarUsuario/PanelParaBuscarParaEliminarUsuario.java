package com.correo.UI.PanelesBuscarUsuario;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.Botones.EliminarBoton;

public class PanelParaBuscarParaEliminarUsuario extends PanelParaBuscarGeneralUsuario {

	public PanelParaBuscarParaEliminarUsuario(Handler handler) {
		super(handler);
	}

	public JButton getBoton() {
        return new EliminarBoton();
	}
	
	public void ejectutarAccion(Handler handler, Usuario usuario) {
		handler.abrirPanelEliminarUsuario(usuario);
	}
	
	public String getTitulo() {
		return "Buscar para eliminar";
	}
}
