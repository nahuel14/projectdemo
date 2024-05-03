package com.correo.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.correo.Handler.Handler;

public class PrincipalMenuBar extends JMenuBar {

	public PrincipalMenuBar(Handler handler) {
		super();
		initUI(handler);
	}

	private void initUI(Handler handler) {

		// JMENU
		JMenu menuPedidos = new JMenu("Pedidos");
		JMenu menuUsuarios = new JMenu("Usuarios");
		JMenu menuClientes = new JMenu("Clientes");

		// ITEM ALTA
		JMenuItem menuPedidoAlta = new JMenuItem("Alta");
		menuPedidoAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelAlta();
			}
		});

		// ITEM MODIFICAR
		JMenuItem menuPedidoModificar = new JMenuItem("Modificar");
		menuPedidoModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelBuscarParaModificarPedido();
			}
		});

		// ITEM ELIMINAR
		JMenuItem menuPedidoEliminar = new JMenuItem("Eliminar");
		menuPedidoEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelBuscarParaEliminarPedido();
			}
		});

		// ITEM MOSTRAR
		JMenuItem menuPedidoMostrarTodo = new JMenuItem("Mostrar todo");
		menuPedidoMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTodoPanel();	
			}
		});
		
		// ITEM CALCULAR RECAUDACION
		JMenuItem menuPedidoCalcularRecaudacion = new JMenuItem("Calcular recaudacion");
		menuPedidoCalcularRecaudacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelCalularRecaudacion();
			}
		});
		
		// ITEM ALTA USUARIO
		JMenuItem menuUsuarioAlta = new JMenuItem("Alta");
		menuUsuarioAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelAltaUsuario();
			}
		});
		
		// ITEM MODICIAR USUARIO
		JMenuItem menuUsuarioModificar = new JMenuItem("Modificar");
		menuUsuarioModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelBuscarParaModificarUsuario();
			}
		});
		
		// ITEM ELIMINAR USUARIO
		JMenuItem menuUsuarioEliminar = new JMenuItem("Eliminar");
		menuUsuarioEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelBuscarParaEliminarUsuario();
			}
		});
		
		// ITEM MOSTRAR TODOS LOS USUARIOS
		JMenuItem menuUsuarioMostrarTodo = new JMenuItem("Mostrar todo");
		menuUsuarioMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTodoPanelUsuario();	
			}
		});
		
		// ITEM ALTA CLIENTE
		JMenuItem menuClienteAlta = new JMenuItem("Alta");
		menuClienteAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelAltaCliente();
			}
		});
		
		// ITEM MODIFICAR CLIENTE
		JMenuItem menuClienteModificar = new JMenuItem("Modificar");
		menuClienteModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelBuscarParaModificarCliente();
			}
		});
		
		// ITEM ELIMINAR CLIENTE
		JMenuItem menuClienteEliminar = new JMenuItem("Eliminar");
		menuClienteEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirPanelBuscarParaEliminarCliente();
			}
		});
		
		// ITEM MOSTRAR TODOS CLIENTES
		JMenuItem menuClienteMostrarTodo = new JMenuItem("Mostrar todo");
		menuClienteMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.mostrarTodoPanelCliente();
			}
		});
		
		// ITEM CERRAR SESION
		JMenuItem cerrarSesion = new JMenuItem("Cerrar sesion");
		cerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handler.abrirFrameLoginCerrandoSesion();
			}
		});
				
		// MENU
		this.add(menuPedidos);
		menuPedidos.add(menuPedidoAlta);
		menuPedidos.add(menuPedidoModificar);
		menuPedidos.add(menuPedidoEliminar);
		menuPedidos.add(menuPedidoMostrarTodo);
		menuPedidos.add(menuPedidoCalcularRecaudacion);
		this.add(menuUsuarios);
		menuUsuarios.add(menuUsuarioAlta);
		menuUsuarios.add(menuUsuarioEliminar);
		menuUsuarios.add(menuUsuarioModificar);
		menuUsuarios.add(menuUsuarioMostrarTodo);
		this.add(menuClientes);
		menuClientes.add(menuClienteAlta);
		menuClientes.add(menuClienteEliminar);
		menuClientes.add(menuClienteModificar);
		menuClientes.add(menuClienteMostrarTodo);
		this.add(cerrarSesion);
	}
}
