package com.correo.UI.Pedido;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.correo.Enum.Estado;
import com.correo.Enum.Lugar;
import com.correo.Enum.Tamano;
import com.correo.Enum.Tipo;
import com.correo.Handler.Handler;
import com.correo.Objects.Cliente;
import com.correo.Objects.Pedido;
import com.correo.UI.PanelGenerico;

public abstract class PanelPedido extends JPanel implements PanelGenerico {
	private JLabel labelIdPedido;
	private JTextField campoId;
	private JComboBox<Tipo> campoTipo;
	private JComboBox<Tamano> campoTamano;
	private JComboBox<Estado> campoEstado;
	private JComboBox<Lugar> campoLugar;
	private JComboBox<Cliente> campoCliente;
	private JLabel labelPrecio;
	private JTextField campoPrecio;
	private JLabel labelFechaEntrega;
	private JTextField campoFechaEntrega;
	
	public PanelPedido(Handler handler) {
		Pedido pedido = new Pedido();
		initUI(handler, pedido);
	}

	public PanelPedido(Handler handler, Pedido pedido) {
		initUI(handler, pedido);
	}
	
	public void initUI(Handler handler, Pedido pedido){
		setLayout(new BorderLayout());
		
		// CAMPOS 
		labelIdPedido = new JLabel("Id pedido: ");
		campoId = new JTextField();
		campoTipo = new JComboBox<Tipo>();
		campoTipo.addItem(Tipo.carta);
		campoTipo.addItem(Tipo.caja);
		campoTamano = new JComboBox<Tamano>();
		campoTamano.addItem(Tamano.chica);
		campoTamano.addItem(Tamano.mediana);
		campoTamano.addItem(Tamano.grande);
		campoEstado = new JComboBox<Estado>();
		campoEstado.addItem(Estado.creado);
		campoEstado.addItem(Estado.enviando_central);
		campoEstado.addItem(Estado.central);
		campoEstado.addItem(Estado.enviando_cliente);
		campoEstado.addItem(Estado.entregado);
		campoLugar = new JComboBox<Lugar>();
		campoLugar.addItem(Lugar.sucursal);
		campoLugar.addItem(Lugar.distribucion);
		campoLugar.addItem(Lugar.central);
		campoLugar.addItem(Lugar.cliente);
		campoCliente = new JComboBox<Cliente>();
		List<Cliente> clientes = handler.mostrarTodoCliente();
		for (int i = 0; i < clientes.size(); i++) {
			campoCliente.addItem(clientes.get(i));
		}
		labelPrecio = new JLabel("Precio");
		campoPrecio = new JTextField();
		labelFechaEntrega = new JLabel("Fecha Entrega");
		campoFechaEntrega = new JTextField();
		
		// COMPLETAR CAMPOS
		getValoresCampos(pedido);
		
		// CAMPOS DESHABILITADOS
		getCamposDeshabilitados();
		
		// BOTON
		JButton boton = getBoton();
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelToObject() != null) {
					ejecutarAction(handler, (Pedido) panelToObject());
				}
				else {
					handler.alertaCampoInvalido();
				}
			}
		});
		
		// TITULO
		JLabel tituloTitulo = new JLabel(getTitulo());
		
		// BOX CAMPO PEDIDO
		Box campoPedido = Box.createHorizontalBox();
		campoPedido.add(labelIdPedido);
		campoPedido.add(campoId);
		
		// BOX CAMPO CLIENTE
		Box campoClienteHorizontal = Box.createHorizontalBox();
		campoClienteHorizontal.add(campoCliente);
		
		// BOX CAMPO PRECIO
		Box boxPrecio = Box.createHorizontalBox();
		boxPrecio.add(labelPrecio);
		boxPrecio.add(campoPrecio);
				
		// BOX CAMPO PRECIO
		Box boxFechaEntrega = Box.createHorizontalBox();
		boxFechaEntrega.add(labelFechaEntrega);
		boxFechaEntrega.add(campoFechaEntrega);
		
		// AGREGAR CAMPOS AL PANEL
		Box campos = Box.createVerticalBox();
		campos.add(campoPedido);
		campos.add(campoTipo);
		campos.add(campoTamano);
		campos.add(campoEstado);
		campos.add(campoLugar);
		campos.add(campoClienteHorizontal);
		campos.add(boxPrecio);
		campos.add(boxFechaEntrega);
		
		// AGREGAR BOTONES 
		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());
		botonera.add(boton);
	    botonera.add(Box.createHorizontalStrut(10));
	    
		// PANEL COMPLETO		
	    add(tituloTitulo, BorderLayout.NORTH);
	    add(campos, BorderLayout.CENTER);
	    add(botonera, BorderLayout.SOUTH);
	}
	
	public Object panelToObject() {
		Integer id = getCampoId().getText().equals("") ? null : Integer.parseInt(getCampoId().getText());
		Tipo tipo = Tipo.valueOf(getCampoTipo().getSelectedItem().toString());
		Tamano tamano = Tamano.valueOf(getCampoTamano().getSelectedItem().toString());
		Estado estado = Estado.valueOf(getCampoEstado().getSelectedItem().toString());
		Lugar lugar = Lugar.valueOf(getCampoLugar().getSelectedItem().toString());
		Cliente cliente = (Cliente) getCampoCliente().getSelectedItem();
		Integer precio = getCampoPrecio().getText().equals("") ? 0 : Integer.parseInt(getCampoPrecio().getText());
		String fechaEntregado = getCampoFechaEntrega().getText().equals(null) ? "" : getCampoFechaEntrega().getText();
		Pedido pedido = new Pedido(id, tipo, tamano, estado, lugar, cliente, precio, fechaEntregado);
		return pedido;
	}
	
	public Boolean isParseable(JTextField campo) {
		return null;
	};
	
	public JTextField getCampoId() {
		return campoId;
	}

	public JComboBox<Tipo> getCampoTipo() {
		return campoTipo;
	}

	public JComboBox<Tamano> getCampoTamano() {
		return campoTamano;
	}

	public JComboBox<Estado> getCampoEstado() {
		return campoEstado;
	}

	public JComboBox<Lugar> getCampoLugar() {
		return campoLugar;
	}

	public JComboBox<Cliente> getCampoCliente() {
		return campoCliente;
	}

	public JTextField getCampoPrecio() {
		return campoPrecio;
	}

	public JTextField getCampoFechaEntrega() {
		return campoFechaEntrega;
	}
}
