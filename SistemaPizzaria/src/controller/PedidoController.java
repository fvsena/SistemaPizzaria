package controller;



import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Produto;

public class PedidoController {

	private  PedidoDao pedidoDAO = new  PedidoDao();

	private ObservableList<Pedido> listaPedido = FXCollections.observableArrayList();
	

	

	public int adicionarPedido(Pedido p) {
		
		return pedidoDAO.adicionarPedido(p);
	}
	
	public ObservableList<Pedido> obterPedido(){
		
		listaPedido.addAll(pedidoDAO.obterProdutos());
		return listaPedido;
	}
	
	
	
}
}

