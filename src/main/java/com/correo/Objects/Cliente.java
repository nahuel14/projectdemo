package com.correo.Objects;

public class Cliente {
	private Integer idCliente;
	private String nombre;
	private String apellido;
	private Integer documento;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, Integer documento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}

	public Cliente(Integer idCliente, String nombre, String apellido, Integer documento) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDocumento() {
		return documento;
	}
	
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String toString() {
		return nombre + ", " + apellido + ", " + documento;
	} 
}
