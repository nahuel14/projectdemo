package com.correo.UI.Botones;

import javax.swing.JButton;

public abstract class BotonesAbs extends JButton {
	
	public BotonesAbs() {
		setText(getTextButton());
	}
	
	public abstract String getTextButton();
}
