package com.correo.UI.PanelesBuscarCliente;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.UI.Botones.EliminarBoton;

public class PanelParaBuscarParaEliminarCliente extends PanelParaBuscarGeneralCliente {

	public PanelParaBuscarParaEliminarCliente(Handler handler) {
		super(handler);
	}
	
	public JButton getBoton() {
        return new EliminarBoton();
	}
	
	public void ejectutarAccion(Handler handler, Cliente cliente) {
		handler.abrirPanelEliminarCliente(cliente);
	}
	
	public String getTitulo() {
		return "Buscar para eliminar";
	}
}
