package com.correo.UI.PanelesBuscarPedido;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.UI.Botones.ModificarBoton;

public class PanelParaBuscarParaModificar extends PanelParaBuscarGeneralPedido {
	
	public PanelParaBuscarParaModificar(Handler handler) {
		super(handler);
	}
	
	public JButton getBoton() {
        return new ModificarBoton();
	}
	
	public void ejectutarAccion(Handler handler, Pedido pedido) {
		handler.abrirPanelModificarPedido(pedido);
	}

	public String getTitulo() {
		return "Buscar para modificar";
	}
	
}
