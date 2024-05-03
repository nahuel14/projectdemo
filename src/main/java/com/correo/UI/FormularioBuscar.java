package com.correo.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.correo.Handler.Handler;
import com.correo.UI.Botones.BuscarBoton;
import com.correo.UI.Botones.MostrarTodosBoton;

public abstract class FormularioBuscar extends JPanel {
	
	public FormularioBuscar(Handler handler) {
		initUI(handler);
	}
	
	public void initUI(Handler handler) {
		setLayout(new BorderLayout());
		
		getTable(handler);
		
		// CAMPO PARA BUSCAR
		JTextField campoTextoHaBuscar = new JTextField();
		
		// BOTON BUSCAR
		BuscarBoton botonBuscar = new BuscarBoton();
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAccionBotonBuscar(handler, campoTextoHaBuscar);
				
			}
		});
		
		// BOTON MOSTRAR
		MostrarTodosBoton botonMostrarTodo = new MostrarTodosBoton();
		botonMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAccionBotonMostrarTodo(handler);
				
			}
		});
		
		// AGREGAR BOTONES BUSCAR Y MOSTRAR TODOS
		Box botonesBuscar = Box.createHorizontalBox();
		botonesBuscar.add(campoTextoHaBuscar);
		botonesBuscar.add(botonMostrarTodo);
		botonesBuscar.add(botonBuscar);
		botonesBuscar.add(Box.createHorizontalGlue());
		
		// PANEL COMPLETO
		add(botonesBuscar, BorderLayout.NORTH);
	}
	
	public abstract int getFilaTabla();
	public abstract void getAccionBotonBuscar(Handler handler, JTextField campoTextoHaBuscar);
	public abstract void getAccionBotonMostrarTodo(Handler handler);
	public abstract void getTable(Handler handler);
}
