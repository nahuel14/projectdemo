package com.correo.UI.Usuario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.correo.Handler.Handler;
import com.correo.Objects.Usuario;
import com.correo.UI.PanelGenerico;

public abstract class PanelUsuario extends JPanel implements PanelGenerico {
	private JLabel labelIdCliente;
	private JTextField idCampo;
	private JLabel labelNombre;
	private JTextField nombreCampo;
	private JLabel labelApellido;
	private JTextField apellidoCampo;
	private JLabel labelDocumento;
	private JTextField documentoCampo;
	private JLabel labelNombreUsuario;
	private JTextField nombreUsuarioCampo;
	private JLabel labelContrasena;
	private JTextField contrasenaCampo;
	
	public PanelUsuario(Handler handler) {
		Usuario usuario = new Usuario();
		initUI(handler, usuario);
	}

	public PanelUsuario(Handler handler, Usuario usuario) {
		initUI(handler, usuario);
	}
	
	public void initUI(Handler handler, Usuario usuario) {
		setLayout(new BorderLayout());
		
		// CAMPOS
		labelIdCliente = new JLabel("Id");
		idCampo = new JTextField();
		labelNombre = new JLabel("Nombre");
		nombreCampo = new JTextField();
		labelApellido = new JLabel("Apellido");
		apellidoCampo = new JTextField();
		labelDocumento = new JLabel("Documento");
		documentoCampo = new JTextField();
		labelNombreUsuario = new JLabel("Nombre del usuario");
		nombreUsuarioCampo = new JTextField();
		labelContrasena = new JLabel("Contrasena");
		contrasenaCampo = new JTextField();
		
		// COMPLETAR CAMPOS
		getValoresCampos(usuario);
		
		// CAMPOS DESHABILITADOS
		getCamposDeshabilitados();
		
		// BOTON MODIFICAR
		JButton boton = getBoton();
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelToObject() != null) {
					ejecutarAction(handler, (Usuario) panelToObject());
				}
				else {
					handler.alertaCampoInvalido();
				}	
				
			}
		});
		
		// ID
		Box idHorizontal = Box.createHorizontalBox();
		idHorizontal.add(labelIdCliente);
		idHorizontal.add(idCampo);
		
		// NOMBRE
		Box nombreHorizontal = Box.createHorizontalBox();
		nombreHorizontal.add(labelNombre);
		nombreHorizontal.add(nombreCampo);
		
		// APELLIDO 
		Box apellidoHorizontal = Box.createHorizontalBox();
		apellidoHorizontal.add(labelApellido);
		apellidoHorizontal.add(apellidoCampo);
		
		// DOCUMENTO
		Box documentoHorizontal = Box.createHorizontalBox();
		documentoHorizontal.add(labelDocumento);
		documentoHorizontal.add(documentoCampo);
		
		// NOMBRE USUARIO
		Box nombreUsuarioHorizontal = Box.createHorizontalBox();
		nombreUsuarioHorizontal.add(labelNombreUsuario);
		nombreUsuarioHorizontal.add(nombreUsuarioCampo);
		
		// CONTRASENA 
		Box contrasenaHorizontal = Box.createHorizontalBox();
		contrasenaHorizontal.add(labelContrasena);
		contrasenaHorizontal.add(contrasenaCampo);
		
		// AGREGAR CAMPOS
		Box campos = Box.createVerticalBox();
		campos.add(idHorizontal);
		campos.add(nombreHorizontal);
		campos.add(apellidoHorizontal);
		campos.add(documentoHorizontal);
		campos.add(nombreUsuarioHorizontal);
		campos.add(contrasenaHorizontal);
		
		// AGREGAR BOTONES
		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());
		botonera.add(boton);
		botonera.add(Box.createHorizontalStrut(10));
		
		// TITULO
		JLabel tituloSuperior = new JLabel(getTitulo());
		
		// PANEL COMPLETO
		add(tituloSuperior, BorderLayout.NORTH);
		add(campos, BorderLayout.CENTER);
		add(botonera, BorderLayout.SOUTH);
	}
	
	public Object panelToObject() {
		if(isParseable(getDocumentoCampo())) {
			Integer id = getIdCampo().getText().equals("") ? null : Integer.parseInt(getIdCampo().getText());
			String nombre = getNombreCampo().getText();
			String apellido = getApellidoCampo().getText();
			Integer documento = getDocumentoCampo().getText().equals("") ? 0 : Integer.parseInt(getDocumentoCampo().getText());
			String nombreUsuario = getNombreUsuarioCampo().getText();
			String contrasena = getContrasenaCampo().getText();
			Usuario usuario = new Usuario(id, nombre, apellido, documento, nombreUsuario, contrasena);
			return usuario;
		}
		return null;
	}
	
	public Boolean isParseable(JTextField campo) {
		try {
			Integer valorCampo = campo.getText().equals("") ? 0 : Integer.parseInt(campo.getText());
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public JTextField getIdCampo() {
		return idCampo;
	}

	public JTextField getNombreCampo() {
		return nombreCampo;
	}

	public JTextField getApellidoCampo() {
		return apellidoCampo;
	}

	public JTextField getDocumentoCampo() {
		return documentoCampo;
	}

	public JTextField getNombreUsuarioCampo() {
		return nombreUsuarioCampo;
	}

	public JTextField getContrasenaCampo() {
		return contrasenaCampo;
	}
}
