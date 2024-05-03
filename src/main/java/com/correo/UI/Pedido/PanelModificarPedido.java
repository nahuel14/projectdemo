package com.correo.UI.Pedido;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.UI.Botones.ModificarBoton;

public class PanelModificarPedido extends PanelPedido {

	public PanelModificarPedido(Handler handler, Pedido pedido) {
		super(handler, pedido);
	}
	
	public String getTitulo() {
		return "Panel modificar";
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.modificarPedido((Pedido) object);
	}
	
	public void getCamposDeshabilitados() {
		getCampoId().setEnabled(false);
		getCampoTipo().setEnabled(false);
		getCampoPrecio().setEnabled(false);
		getCampoFechaEntrega().setEnabled(false);
	}
	
	public void getValoresCampos(Object object) {
		Pedido pedido = (Pedido) object;
		getCampoId().setText(String.valueOf(pedido.getId()));
		getCampoTipo().setSelectedItem(pedido.getTipo());
		getCampoTamano().setSelectedItem(pedido.getTamano());
		getCampoEstado().setSelectedItem(pedido.getEstado());
		getCampoLugar().setSelectedItem(pedido.getLugar());
		getCampoCliente().setSelectedItem(pedido.getCliente());
		getCampoPrecio().setText(String.valueOf(pedido.getPrecio()));
		getCampoFechaEntrega().setText(pedido.getFechaEntregado());
	}
	
	public JButton getBoton() {
		return new ModificarBoton();
	}
}
