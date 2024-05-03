package com.correo.Table;

import java.util.List;
import com.correo.Objects.Pedido;

import javax.swing.table.AbstractTableModel;

public class PedidosTableModel extends AbstractTableModel {

	private List<Pedido> pedidos;
	private String[] titulos = {"Id", "Tipo", "Tamano", "Estado", "Lugar", "Nombre cliente", "Apellido cliente", "Precio", "Fecha de entregado"};
	private final static int id_col = 0;
	private final static int tipo_col = 1;
	private final static int tamano_col = 2;
	private final static int estado_col = 3;
	private final static int lugar_col = 4;
	private final static int nombre_cliente_col = 5;
	private final static int apellido_cliente_col = 6;
	private final static int precio_col = 7;
	private final static int fecha_entregado_col = 8;
	
	public PedidosTableModel(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public int getRowCount() {
		return pedidos.size();
	}

	public int getColumnCount() {
		return titulos.length;
	}

	public Object getValueAt(int row, int column) {
		Pedido pedido = pedidos.get(row);
		switch(column) {
			case id_col:
				return pedido.getId();
			case tipo_col:
				return pedido.getTipo();
			case tamano_col:
				return pedido.getTamano();
			case estado_col:
				return pedido.getEstado();
			case lugar_col:
				return pedido.getLugar();
			case nombre_cliente_col:
				return pedido.getCliente().getNombre();
			case apellido_cliente_col:
				return pedido.getCliente().getApellido();
			case precio_col:
				return pedido.getPrecio();
			case fecha_entregado_col:
				return pedido.getFechaEntregado();
		}
		return "";
	}
	
	public String getColumnName(int column) {
		return titulos[column];
	}
	
	public Pedido getElement(int index) {
		return pedidos.get(index);
	}
}
