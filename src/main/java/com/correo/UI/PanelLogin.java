package com.correo.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.correo.Handler.Handler;

public class PanelLogin extends JPanel{
	private JLabel labelNombreUsuario;
	private JTextField campoNombreUsuario;
	private JLabel laberContrasena;
	private JTextField campoContrasena;

	public PanelLogin(Handler handler) {
		initUI(handler);
	}
	
	public void initUI(Handler handler) {
		setLayout(new BorderLayout());
		
		labelNombreUsuario = new JLabel("Usuario");
		campoNombreUsuario = new JTextField();
		laberContrasena = new JLabel("Contrasena");
		campoContrasena = new JTextField();
		
		JButton botonLogueo = new JButton("Ok");
		botonLogueo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = campoNombreUsuario.getText();
				String contrasena = campoContrasena.getText();
				handler.validarUsuario(nombreUsuario, contrasena);
			}
		});
		
		// NOMBRE USUARIO
		Box nombreUsuarioHorizontal = Box.createHorizontalBox();
		nombreUsuarioHorizontal.add(labelNombreUsuario);
		nombreUsuarioHorizontal.add(campoNombreUsuario);
		
		// CONTRASENA
		Box contrasenaHorizontal = Box.createHorizontalBox();
		contrasenaHorizontal.add(laberContrasena);
		contrasenaHorizontal.add(campoContrasena);
		
		
		// CAMPOS
		Box campos = Box.createVerticalBox();
		campos.add(nombreUsuarioHorizontal);
		campos.add(contrasenaHorizontal);
		
		// PANEL COMPLETO
		add(campos, BorderLayout.CENTER);
		add(botonLogueo, BorderLayout.SOUTH);
		
	}

}
