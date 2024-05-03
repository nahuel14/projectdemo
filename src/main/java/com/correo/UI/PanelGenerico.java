package com.correo.UI;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.correo.Handler.Handler;

public interface PanelGenerico {
	public Object panelToObject();
	public String getTitulo();
	public void getValoresCampos(Object object);
	public void getCamposDeshabilitados();
	public JButton getBoton();
	public void ejecutarAction(Handler handler, Object object);
	public Boolean isParseable(JTextField campo);
}
