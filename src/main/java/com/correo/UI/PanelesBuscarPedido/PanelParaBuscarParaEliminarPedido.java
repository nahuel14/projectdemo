package com.correo.UI.PanelesBuscarPedido;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.UI.Botones.EliminarBoton;

public class PanelParaBuscarParaEliminarPedido extends PanelParaBuscarGeneralPedido {

	public PanelParaBuscarParaEliminarPedido(Handler handler) {
		super(handler);
	}
	
	public JButton getBoton() {
        return new EliminarBoton();    
	}
	
	public void ejectutarAccion(Handler handler, Pedido pedido) {
		handler.abrirPanelEliminarPedido(pedido);
	}
	
	public String getTitulo() {
		return "Buscar para eliminar";
	}
}
