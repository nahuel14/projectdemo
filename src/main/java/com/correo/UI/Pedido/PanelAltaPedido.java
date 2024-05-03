package com.correo.UI.Pedido;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.UI.Botones.AltaBoton;

public class PanelAltaPedido extends PanelPedido {
	
	public PanelAltaPedido(Handler handler) {
		super(handler);
	}
	
	public String getTitulo() {
		return "Panel Alta";
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.crearPedido((Pedido) object);
	}
	
	public void getCamposDeshabilitados() {
		getCampoId().setEnabled(false);
		getCampoPrecio().setEnabled(false);
		getCampoFechaEntrega().setEnabled(false);
	}
	
	public void getValoresCampos(Object object) {}
	
	public JButton getBoton() {
		return new AltaBoton();
	}
}
