package com.correo.UI;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.correo.Handler.Handler;

public class PanelCalcularRecaudacion extends JPanel {
	
	private String pattern = "dd-MM-yyyy";
	private String dateInString = new SimpleDateFormat(pattern).format(new Date());

	public PanelCalcularRecaudacion(Handler handler) {
		initUI(handler);
	}
	
	public void initUI(Handler handler) {
		setLayout(new BorderLayout());
		
		// TITULO 
		JLabel tituloSuperior = new JLabel("Panel calcular recaudacion");
		
		// FECHA 
		JLabel fechaHoy = new JLabel(dateInString);
		
		// CAMPO CON EL VALOR RECAUDADO
		JLabel labelCalcularRecaudacion = new JLabel(handler.calcularRecaudacion());
		
		// PARTE SUPERIOR
		Box parteSuperior = Box.createVerticalBox();
		parteSuperior.add(tituloSuperior);
		parteSuperior.add(fechaHoy);
		parteSuperior.add(labelCalcularRecaudacion);
		
		// PANEL COMPLETO
	    add(parteSuperior, BorderLayout.NORTH);
	}
}
