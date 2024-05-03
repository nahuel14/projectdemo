package com.correo.UI.Cliente;

import javax.swing.JButton;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.UI.Botones.EliminarBoton;

public class PanelEliminarCliente extends PanelCliente {

	public PanelEliminarCliente(Handler handler, Cliente cliente) {
		super(handler, cliente);
	}
	
	public String getTitulo() {
		return "Panel eliminar";
	}
	
	public void getValoresCampos(Object object) {
		Cliente cliente = (Cliente) object;
		getIdCampo().setText(String.valueOf(cliente.getIdCliente()));
		getNombreCampo().setText(String.valueOf(cliente.getNombre()));
		getApellidoCampo().setText(String.valueOf(cliente.getApellido()));
		getDocumentoCampo().setText(String.valueOf(cliente.getDocumento()));
	}
	
	public void getCamposDeshabilitados() {
		getIdCampo().setEnabled(false);
		getNombreCampo().setEnabled(false);
		getApellidoCampo().setEnabled(false);
		getDocumentoCampo().setEnabled(false);
	}
	
	public void ejecutarAction(Handler handler, Object object) {
		handler.eliminarCliente((Cliente) object);
	}
	
	public JButton getBoton() {
		return new EliminarBoton();
	}
}