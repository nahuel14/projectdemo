package com.correo.UI.PanelesBuscarUsuario;

import javax.swing.JPanel;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.FormularioBuscar;
import com.correo.UI.PanelParaBuscarGeneral;

public abstract class PanelParaBuscarGeneralUsuario extends PanelParaBuscarGeneral {
	
	public PanelParaBuscarGeneralUsuario(Handler handler) {
		super(handler);
	}
	
	public JPanel getFormularioBuscar(Handler handler) {
		return new FormularioBuscarUsuario(handler);
	}
	
	public void ejecutarAccionEntidad(Handler handler, FormularioBuscar formulario, int fila) {
		Usuario usuarioSeleccionado = ((FormularioBuscarUsuario) formulario).getIdRegistroSeleccionado(fila);
		ejectutarAccion(handler, usuarioSeleccionado);
	}
	
	public abstract void ejectutarAccion(Handler handler, Usuario usuario);
}
