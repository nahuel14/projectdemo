package com.correo.UI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.correo.Handler.Handler;

public class PanelPrincipal extends JPanel {
	
	public PanelPrincipal(Handler handler) {
		initUI(handler);
	}

	public void initUI(Handler handler) {
		JLabel bienvenido = new JLabel("Bienvenido");
		add(bienvenido);
	}
}
