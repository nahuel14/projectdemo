package com.correo.UI.PanelesBuscarPedido;

import javax.swing.JPanel;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.UI.FormularioBuscar;
import com.correo.UI.PanelParaBuscarGeneral;

public abstract class PanelParaBuscarGeneralPedido extends PanelParaBuscarGeneral {

	public PanelParaBuscarGeneralPedido(Handler handler) {
		super(handler);
	}
	
	public JPanel getFormularioBuscar(Handler handler) {
		return new FormularioBuscarPedido(handler);
	}
	
	public void ejecutarAccionEntidad(Handler handler, FormularioBuscar formulario, int fila) {
		Pedido pedidoSeleccionado = ((FormularioBuscarPedido) formulario).getIdRegistroSeleccionado(fila);
		ejectutarAccion(handler, pedidoSeleccionado);
	}
	
	public abstract void ejectutarAccion(Handler handler, Pedido pedido);
}
