package com.correo.UI.Cliente;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.UI.Botones.ModificarBoton;

public class PanelAltaCliente extends PanelCliente {
	
	public PanelAltaCliente(Handler handler) {
		super(handler);
	}
	
	public String getTitulo() {
		return "Panel alta";
	}
	
	public void getValoresCampos(Object object) {}
	
	public void getCamposDeshabilitados() {
		getIdCampo().setEnabled(false);
	}

	public void ejecutarAction(Handler handler, Object object) {
		handler.crearCliente((Cliente) object);
	}
	
	public JButton getBoton() {
		return new ModificarBoton();
	}
}
