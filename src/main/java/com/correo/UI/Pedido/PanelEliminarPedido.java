package com.correo.UI.Pedido;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.UI.Botones.EliminarBoton;

public class PanelEliminarPedido extends PanelPedido {

	public PanelEliminarPedido(Handler handler, Pedido pedido) {
		super(handler, pedido);
	}
	
	public String getTitulo() {
		return "Panel eliminar";
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.eliminarPedido((Pedido) object);
	}
		
	public void getCamposDeshabilitados() {
		getCampoId().setEnabled(false);
		getCampoTipo().setEnabled(false);
		getCampoTamano().setEnabled(false);
		getCampoEstado().setEnabled(false);
		getCampoLugar().setEnabled(false);
		getCampoCliente().setEnabled(false);
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
		return new EliminarBoton();
	}
}
