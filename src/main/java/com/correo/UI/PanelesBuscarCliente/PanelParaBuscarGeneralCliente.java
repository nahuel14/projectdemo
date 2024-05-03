package com.correo.UI.PanelesBuscarCliente;

import javax.swing.JPanel;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.UI.FormularioBuscar;
import com.correo.UI.PanelParaBuscarGeneral;

public abstract class PanelParaBuscarGeneralCliente extends PanelParaBuscarGeneral {

	public PanelParaBuscarGeneralCliente(Handler handler) {
		super(handler);
	}
	
	public JPanel getFormularioBuscar(Handler handler) {
		return new FormularioBuscarCliente(handler);
	}
	
	public void ejecutarAccionEntidad(Handler handler, FormularioBuscar formulario, int fila) {
		Cliente clienteSeleccionado = ((FormularioBuscarCliente) formulario).getIdRegistroSeleccionado(fila);
		ejectutarAccion(handler, clienteSeleccionado);
	}
	
	public abstract void ejectutarAccion(Handler handler, Cliente cliente);
}
