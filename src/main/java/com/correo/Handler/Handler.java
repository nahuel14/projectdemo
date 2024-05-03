package com.correo.Handler;

import java.util.List;

import javax.swing.JOptionPane;

import com.correo.CorreoBO.ClienteBO;
import com.correo.CorreoBO.PedidoBO;
import com.correo.CorreoBO.UsuarioBO;
import com.correo.Dao.Impl.ClienteImpDao;
import com.correo.Dao.Impl.PedidoImpDao;
import com.correo.Dao.Impl.UsuarioImpDao;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;
import com.correo.Objects.Pedido;
import com.correo.Objects.Usuario;
import com.correo.UI.FrameLogin;
import com.correo.UI.FramePrincipal;
import com.correo.UI.PanelCalcularRecaudacion;
import com.correo.UI.PanelLogin;
import com.correo.UI.PanelPrincipal;
import com.correo.UI.Cliente.PanelAltaCliente;
import com.correo.UI.Cliente.PanelEliminarCliente;
import com.correo.UI.Cliente.PanelModificarCliente;
import com.correo.UI.Cliente.PanelMostrarTodoCliente;
import com.correo.UI.PanelesBuscarCliente.PanelParaBuscarParaEliminarCliente;
import com.correo.UI.PanelesBuscarCliente.PanelParaBuscarParaModificarCliente;
import com.correo.UI.PanelesBuscarPedido.PanelParaBuscarParaEliminarPedido;
import com.correo.UI.PanelesBuscarPedido.PanelParaBuscarParaModificar;
import com.correo.UI.PanelesBuscarUsuario.PanelParaBuscarParaEliminarUsuario;
import com.correo.UI.PanelesBuscarUsuario.PanelParaBuscarParaModificarUsuario;
import com.correo.UI.Pedido.PanelAltaPedido;
import com.correo.UI.Pedido.PanelEliminarPedido;
import com.correo.UI.Pedido.PanelModificarPedido;
import com.correo.UI.Pedido.PanelMostrarTodoPedido;
import com.correo.UI.Usuario.PanelAltaUsuario;
import com.correo.UI.Usuario.PanelEliminarUsuario;
import com.correo.UI.Usuario.PanelModificarUsuario;
import com.correo.UI.Usuario.PanelMostrarTodoUsuario;

public class Handler {
	private UsuarioBO usuarioBO;
	private ClienteBO clienteBO;
	private PedidoBO pedidoBO;
	private FramePrincipal frame;
	private FrameLogin frameLogin;

	public Handler() {
		usuarioBO = new UsuarioBO();
		clienteBO = new ClienteBO();
		pedidoBO = new PedidoBO();
		pedidoBO.setPedidoDao(new PedidoImpDao());
		usuarioBO.setUsuarioDao(new UsuarioImpDao());
		usuarioBO.setPedidoDao(new PedidoImpDao());
		clienteBO.setClienteDao(new ClienteImpDao());
		clienteBO.setPedidoDao(new PedidoImpDao());
	}
	
	// PEDIDOS
	public void abrirPanelAlta() {
		frame.cambiarPanel(new PanelAltaPedido(this));
	}

	public void crearPedido(Pedido pedido) {
		try {
			pedidoBO.crearPedido(pedido);
			alertaInformacion("Creado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirPanelBuscarParaEliminarPedido() {
		frame.cambiarPanel(new PanelParaBuscarParaEliminarPedido(this));
	}
	
	public void abrirPanelEliminarPedido(Pedido pedido) {
		frame.cambiarPanel(new PanelEliminarPedido(this, pedido));
	}
	
	public void eliminarPedido(Pedido pedido) {
		try {
			pedidoBO.eliminarPedido(pedido);
			alertaInformacion("Eliminado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirPanelBuscarParaModificarPedido() {
		frame.cambiarPanel(new PanelParaBuscarParaModificar(this));
	}

	public void abrirPanelModificarPedido(Pedido pedido) {
		frame.cambiarPanel(new PanelModificarPedido(this, pedido));
	}

	public void modificarPedido(Pedido pedido) {
		try {
			pedidoBO.modificarPedido(pedido);
			alertaInformacion("Modificado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}

	public List<Pedido> mostrarTodoPedido() {
		try {
			return pedidoBO.mostrarTodoPedido();
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}

	public List<Pedido> buscar(String texto) {
		try {
			return pedidoBO.buscar(texto);
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}

	public void mostrarTodoPanel() {
		frame.cambiarPanel(new PanelMostrarTodoPedido(this));
	}

	public void cambiarEstado(Pedido pedido) {
		try {
			pedidoBO.modificarPedido(pedido);
			alertaInformacion("Cambiado el estado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}

	public void abrirPanelCalularRecaudacion() {
		frame.cambiarPanel(new PanelCalcularRecaudacion(this));
	}

	public String calcularRecaudacion() {
		try {
			return pedidoBO.calularRecaudacion().toString();
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}
	
	// USUARIO
	public void abrirPanelAltaUsuario() {
		frame.cambiarPanel(new PanelAltaUsuario(this));	
	}
	
	public void crearUsuario(Usuario usuario) {
		try {
			usuarioBO.crearUsuario(usuario);
			alertaInformacion("Creado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirPanelBuscarParaEliminarUsuario() {
		frame.cambiarPanel(new PanelParaBuscarParaEliminarUsuario(this));
	}
	
	public void abrirPanelEliminarUsuario(Usuario usuario) {
		frame.cambiarPanel(new PanelEliminarUsuario(this, usuario));
	}
	
	public void eliminarUsuario(Usuario usuario) {
		try {
			usuarioBO.eliminarUsuario(usuario);
			alertaInformacion("Eliminado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirPanelBuscarParaModificarUsuario() {
		frame.cambiarPanel(new PanelParaBuscarParaModificarUsuario(this));
	}
	
	public void abrirPanelModificarUsuario(Usuario usuario) {
		frame.cambiarPanel(new PanelModificarUsuario(this, usuario));
	}
	
	public void modificarUsuario(Usuario usuario) {
		try {
			usuarioBO.modificarUsuario(usuario);
			alertaInformacion("Modificado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void mostrarTodoPanelUsuario() {
		frame.cambiarPanel(new PanelMostrarTodoUsuario(this));
	}
	
	public List<Usuario> mostrarTodoUsuario() {
		try {
			return usuarioBO.mostrarTodoUsuario();
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}
	
	public List<Usuario> buscarUsuario(String texto) {
		try {
			return usuarioBO.buscarUsuario(texto);
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}

	// CLIENTE
	public void abrirPanelAltaCliente() {
		frame.cambiarPanel(new PanelAltaCliente(this));
	}
	
	public void crearCliente(Cliente cliente) {
		try {
			clienteBO.crearCliente(cliente);
			alertaInformacion("Creado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirPanelBuscarParaEliminarCliente() {
		frame.cambiarPanel(new PanelParaBuscarParaEliminarCliente(this));
	}
	
	public void abrirPanelEliminarCliente(Cliente cliente) {
		frame.cambiarPanel(new PanelEliminarCliente(this, cliente));
	}
	
	public void eliminarCliente(Cliente cliente) {
		try {
			clienteBO.eliminarCliente(cliente);
			alertaInformacion("Eliminado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirPanelBuscarParaModificarCliente() {
		frame.cambiarPanel(new PanelParaBuscarParaModificarCliente(this));
	}
	
	public void abrirPanelModificarCliente(Cliente cliente) {
		frame.cambiarPanel(new PanelModificarCliente(this, cliente));
	}
	
	public void modificarCliente(Cliente cliente) {
		try {
			clienteBO.modificarCliente(cliente);
			alertaInformacion("Modificado con éxito");
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void mostrarTodoPanelCliente() {
		frame.cambiarPanel(new PanelMostrarTodoCliente(this));
	}
	
	public List<Cliente> mostrarTodoCliente() {
		try {
			return clienteBO.mostrarTodoCliente();
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}
	
	public List<Cliente> buscarCliente(String texto) {
		try {
			return clienteBO.buscarCliente(texto);
		} catch (CorreoException e) {
			alertaError(e);
		}
		return null;
	}

	// LOGIN
	public void abrirFrameLogin() {
		frameLogin = new FrameLogin();
		frameLogin.cambiarPanel(new PanelLogin(this));
		frameLogin.setVisible(true);
	}
	
	public void abrirFrameLoginCerrandoSesion() {
		frame.dispose();
		abrirFrameLogin();
	}
	
	public void validarUsuario(String nombreUsuario, String contrasena) {
		try {
			usuarioBO.login(nombreUsuario, contrasena);
			abrirFramePrincipal();
		} catch (CorreoException e) {
			alertaError(e);
		}
	}
	
	public void abrirFramePrincipal() {
		frameLogin.dispose();
		frame = new FramePrincipal(this);
		frame.cambiarPanel(new PanelPrincipal(this));
		frame.setVisible(true);
	}

	// ALERTAS
	public void alertaError(CorreoException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
	
	public void alertaInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertaCampoInvalido() {
		alertaInformacion("Documento invalido. Verificar campos");
	}
}
