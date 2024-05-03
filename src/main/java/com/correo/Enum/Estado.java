package com.correo.Enum;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public enum Estado {
	creado(new HashSet<Lugar>(Arrays.asList(Lugar.sucursal))),
	enviando_central(new HashSet<Lugar>(Arrays.asList(Lugar.distribucion))),
	central(new HashSet<Lugar>(Arrays.asList(Lugar.central))), 
	enviando_cliente(new HashSet<Lugar>(Arrays.asList(Lugar.distribucion))), 
	entregado(new HashSet<Lugar>(Arrays.asList(Lugar.cliente)));

	private Set<Lugar> lugares;

	Estado(Set<Lugar> lugares) {
		this.lugares = lugares;
	}
	
	public boolean validateLugar(Lugar lugar) {
		return lugares.stream().anyMatch(x -> x.equals(lugar));
	}
}
