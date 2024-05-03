package com.correo.Enum;

public enum Lugar {
	sucursal, distribucion, central, cliente;
}

//public enum Lugar {
//	sucursal("Sucursal"),
//	distribucion("En distribución"),
//	central("Central"),
//	cliente("Cliente");
//	
//	private String lugar;
//	
//	Lugar(String lugar) { this.lugar = lugar; }
//	
//	public String getLugar() { return lugar; }
//}
//	public Lugar valueOf(String lugar) {
//		Lugar[] lugares = Lugar.values();
//		for(int i=0; i<lugares.length; i++) {
//			if (lugares[i].name().equals(lugar)) {
//				return lugares[i];
//			}
//		}
//		throw new CorreoException("Lugar invalido");
//	}
