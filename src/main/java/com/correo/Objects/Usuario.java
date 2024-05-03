package com.correo.Objects;

public class Usuario extends Cliente {

	private String nombreUsuario;
	private String contrasena;
	
	public Usuario(){}
	
	public Usuario(String nombre, String apellido, Integer documento, String nombreUsuario, String contrasena) {
		super(nombre, apellido, documento);
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public Usuario(Integer idCiente, String nombre, String apellido, Integer documento, String nombreUsuario, String contrasena) {
		super(idCiente, nombre, apellido, documento);
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}
	
	public Usuario(Integer idCiente, String nombre, String apellido, Integer documento, String nombreUsuario) {
		super(idCiente, nombre, apellido, documento);
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String toString() {
		return "Usuario [usuario=" + nombreUsuario + ", constrasena=" + contrasena + "]";
	}
}
