package com.correo.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.correo.Handler.Handler;

public abstract class PanelParaBuscarGeneral extends JPanel {
	
	public PanelParaBuscarGeneral(Handler handler) {
		initUI(handler);
	}

	public void initUI(Handler handler) {
		setLayout(new BorderLayout());

		// TITULO
		JLabel tituloSuperior = new JLabel(getTitulo());
		
		// FORMULARIO
		FormularioBuscar formulario = (FormularioBuscar) getFormularioBuscar(handler);
		
		// BOTON
		JButton boton = getBoton();
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = formulario.getFilaTabla();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione un registro");
				} else {
					ejecutarAccionEntidad(handler, formulario, fila);
				}
			}
		});

		// PARTE INFERIOR
		Box parteInferior = Box.createHorizontalBox();
		parteInferior.add(Box.createHorizontalGlue());
		parteInferior.add(boton);
		parteInferior.add(Box.createHorizontalStrut(5));

		// PANEL COMPLETO
		add(tituloSuperior, BorderLayout.NORTH);
		add(formulario, BorderLayout.CENTER);
		add(parteInferior, BorderLayout.SOUTH);
	}

	// Particular de cada "Accion" (Modificar/Eliminar)
	public abstract JButton getBoton();
	public abstract String getTitulo();
	
	// Particular de cada Entidad
	public abstract JPanel getFormularioBuscar(Handler handler);
	public abstract void ejecutarAccionEntidad(Handler handler, FormularioBuscar formulario, int fila);
}
