package com.correo.UI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.correo.Handler.Handler;

public abstract class PanelMostrarTodo extends JPanel {
	
	private JTable tabla;
	private JScrollPane scroll;
	
	public PanelMostrarTodo(Handler handler) {
		initUI(handler);
	}
	
	public void initUI(Handler handler) {
		setLayout(new BorderLayout());
		
		// TITULO
		JLabel tiloSuperior = new JLabel("Panel mostrar todos los registros");
		
		tabla = new JTable(getTableModel(handler));
		scroll = new JScrollPane(tabla);
		
		add(tiloSuperior, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}

	public abstract AbstractTableModel getTableModel(Handler handler);
}
