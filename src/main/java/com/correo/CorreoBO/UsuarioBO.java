package com.correo.CorreoBO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.correo.Dao.PedidoDao;
import com.correo.Dao.UsuarioDao;
import com.correo.Exceptions.CorreoException;
import com.correo.Objects.Cliente;
import com.correo.Objects.Usuario;

@Component
public class UsuarioBO {
	private UsuarioDao usuarioDao;
	private PedidoDao pedidoDao;
    
    @Autowired
    public UsuarioBO(UsuarioDao usuarioDao, PedidoDao pedidoDao) {
        this.usuarioDao = usuarioDao;
        this.pedidoDao = pedidoDao;
    }
    
    public UsuarioBO() {}

	public void crearUsuario(Usuario usuario) throws CorreoException {
		validarNombreUsuarioDisponible(usuario);
		usuarioDao.CrearUsuario(usuario);
	}
	
	public void eliminarUsuario(Usuario usuario) throws CorreoException {
		validarUsuarioSinPedidos(usuario);
		usuarioDao.EliminarUsuario(usuario);
	}
	
	public void modificarUsuario(Usuario usuario) throws CorreoException {
		validarNombreUsuarioDisponible(usuario);
		usuarioDao.ModificarUsuario(usuario);	
	}
	
	public List<Usuario> buscarUsuario(String texto) throws CorreoException {
		return usuarioDao.Buscar(texto).stream().filter((a) -> a.getNombreUsuario() != null).collect(Collectors.toList());
		
	}
	
	public List<Usuario> mostrarTodoUsuario() throws CorreoException {
		return usuarioDao.MostrarTodo().stream().filter((a) -> a.getNombreUsuario() != null).collect(Collectors.toList());
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	
	public void login(String nombreUsuario, String contrasena) throws CorreoException {
		if(usuarioDao.getUsuarioByNombreAndPass(nombreUsuario, contrasena) == null) {
			throw new CorreoException("Usuario o contrasena invalidos");
		}
	}
	
	private void validarNombreUsuarioDisponible(Usuario usuario) throws CorreoException {
		if(usuarioDao.getNombreUsuario(usuario) != null) {
			throw new CorreoException("Nombre de usuario en uso");
		}
	}	
	
	private void validarUsuarioSinPedidos(Usuario usuario) throws CorreoException {
		if(!pedidoDao.getPedidosByCliente((Cliente) usuario).isEmpty()) {
			throw new CorreoException("Usuario relacionado con pedido");
		}
	}
}
