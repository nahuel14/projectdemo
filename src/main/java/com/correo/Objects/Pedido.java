package com.correo.Objects;

import com.correo.Enum.Estado;
import com.correo.Enum.Lugar;
import com.correo.Enum.Tamano;
import com.correo.Enum.Tipo;

public class Pedido {
	private Integer id;
	private Tipo tipo;
	private Tamano tamano;
	private Estado estado;
	private Lugar lugar;
	private Cliente cliente;
	private Integer precio;
	private String fechaEntregado;
	
	public Pedido(){}

	public Pedido(Tipo tipo, Tamano tamano, Estado estado, Lugar lugar, Cliente cliente, Integer precio, String fechaEntregado) {
		this.tipo = tipo;
		this.tamano = tamano;
		this.estado = estado;
		this.lugar = lugar;
		this.cliente = cliente;
		this.precio = precio;
		this.fechaEntregado = fechaEntregado;
	}

	public Pedido(Integer id, Tipo tipo, Tamano tamano, Estado estado, Lugar lugar, Cliente cliente, Integer precio, String fechaEntregado) {
		this.id = id;
		this.tipo = tipo;
		this.tamano = tamano;
		this.estado = estado;
		this.lugar = lugar;
		this.cliente = cliente;
		this.precio = precio;
		this.fechaEntregado = fechaEntregado;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Tamano getTamano() {
		return tamano;
	}
	
	public void setTamano(Tamano tamano) {
		this.tamano = tamano;
	}
	
	public Lugar getLugar() {
		return lugar;
	}
	
	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getFechaEntregado() {
		return fechaEntregado;
	}

	public void setFechaEntregado(String fechaEntregado) {
		this.fechaEntregado = fechaEntregado;
	}

	public String toString() {
		return "Pedido [id=" + id + ", tipo=" + tipo + ", tamano=" + tamano + ", estado=" + estado + ", lugar=" + lugar
				+ ", cliente=" + cliente + ", precio=" + precio + ", fechaEntregado=" + fechaEntregado + "]";
	}
	
}
