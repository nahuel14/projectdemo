package com.correo.Table;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.correo.Objects.Pedido;

public class TablaPedidoFormulario {

	private List<Pedido> pedidos;
	private PedidosTableModel pedidosTableModel;
	private JTable tabla;
	private JScrollPane scroll;
	
	public TablaPedidoFormulario(List<Pedido> listPedidos) {
		pedidos = listPedidos;
		pedidosTableModel = new PedidosTableModel(pedidos);
		tabla = new JTable(pedidosTableModel);
		scroll = new JScrollPane(tabla);
	}
	
	public void rePaintScroll() {
		this.getScroll().repaint();
	}
	
	public Integer getIdRegistroSeleccionado(Integer fila) {
		Pedido pedido = ((PedidosTableModel) tabla.getModel()).getElement(tabla.getSelectedRow());
		return pedido.getId();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public PedidosTableModel getPedidosTableModel() {
		return pedidosTableModel;
	}

	public void setPedidosTableModel(PedidosTableModel pedidosTableModel) {
		this.pedidosTableModel = pedidosTableModel;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
}
