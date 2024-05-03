package com.correo.UI.PanelesBuscarCliente;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.UI.Botones.ModificarBoton;

public class PanelParaBuscarParaModificarCliente extends PanelParaBuscarGeneralCliente {

	public PanelParaBuscarParaModificarCliente(Handler handler) {
		super(handler);
	}
	
	public JButton getBoton() {
        return new ModificarBoton();
	}
	
	public void ejectutarAccion(Handler handler, Cliente cliente) {
		handler.abrirPanelModificarCliente(cliente);
	}
	
	public String getTitulo() {
		return "Buscar para modificar";
	}
}
