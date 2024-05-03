package com.correo.UI.Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.UI.PanelGenerico;

public abstract class PanelCliente extends JPanel implements PanelGenerico {
	private JLabel labelIdCliente;
	private JTextField idCampo;
	private JLabel labelNombre;
	private JTextField nombreCampo;
	private JLabel labelApellido;
	private JTextField apellidoCampo;
	private JLabel labelDocumento;
	private JTextField documentoCampo;
	
	public PanelCliente(Handler handler) {
		Cliente cliente = new Cliente();
		initUI(handler, cliente);
	}

	public PanelCliente(Handler handler, Cliente cliente) {
		initUI(handler, cliente);
	}
	
	public void initUI(Handler handler, Cliente cliente) {
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
		
		// COMPLETAR CAMPOS
		getValoresCampos(cliente);
				
		// CAMPOS DESHABILITADOS
		getCamposDeshabilitados();
				
		// BOTON
		JButton boton = getBoton();
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelToObject() != null) {
					ejecutarAction(handler, (Cliente) panelToObject());
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
		
		// AGREGAR CAMPOS
		Box campos = Box.createVerticalBox();
		campos.add(idHorizontal);
		campos.add(nombreHorizontal);
		campos.add(apellidoHorizontal);
		campos.add(documentoHorizontal);
		
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
			Cliente cliente = new Cliente(id, nombre, apellido, documento);
			return cliente;	
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
}
