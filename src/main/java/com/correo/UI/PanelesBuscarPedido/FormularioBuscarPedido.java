package com.correo.UI.PanelesBuscarPedido;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTextField;

import com.correo.Handler.Handler;
import com.correo.Objects.Pedido;
import com.correo.Table.PedidosTableModel;
import com.correo.Table.TablaPedidoFormulario;
import com.correo.UI.FormularioBuscar;

public class FormularioBuscarPedido extends FormularioBuscar {

	protected TablaPedidoFormulario tablaPedidoFormulario;
	protected List<Pedido> pedidos;

	public FormularioBuscarPedido(Handler handler) {
		super(handler);
	}
	
	public Pedido getIdRegistroSeleccionado(Integer fila) {
		return ((PedidosTableModel) tablaPedidoFormulario.getTabla().getModel()).getElement(tablaPedidoFormulario.getTabla().getSelectedRow());
	}
	
	public int getFilaTabla() {
		return tablaPedidoFormulario.getTabla().getSelectedRow();
	}
	
	public void getAccionBotonBuscar(Handler handler, JTextField campoTextoHaBuscar) {
		pedidos = handler.buscar(campoTextoHaBuscar.getText());
		tablaPedidoFormulario.setPedidosTableModel(new PedidosTableModel(pedidos));
		tablaPedidoFormulario.getTabla().setModel(tablaPedidoFormulario.getPedidosTableModel());
		tablaPedidoFormulario.rePaintScroll();
	}
	
	public void getAccionBotonMostrarTodo(Handler handler) {
		pedidos = handler.mostrarTodoPedido();
		tablaPedidoFormulario.setPedidosTableModel(new PedidosTableModel(pedidos));
		tablaPedidoFormulario.getTabla().setModel(tablaPedidoFormulario.getPedidosTableModel());
		tablaPedidoFormulario.rePaintScroll();
	}
	
	public void getTable(Handler handler) {
		tablaPedidoFormulario = new TablaPedidoFormulario(handler.mostrarTodoPedido());
		add(tablaPedidoFormulario.getScroll(), BorderLayout.CENTER);
	}
}
