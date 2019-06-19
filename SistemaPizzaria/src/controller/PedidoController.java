package controller;



import java.util.List;

import dao.PedidoDao;
import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pedido;
import model.Produto;

public class PedidoController {

	private  PedidoDao pedidoDAO = new  PedidoDao();

	private ObservableList<Pedido> listaPedido = FXCollections.observableArrayList();




	public int adicionarPedido(Pedido p) {

		return pedidoDAO.adicionarPedido(p);
	}

	public ObservableList<Pedido> obterPedido(){

		listaPedido.addAll(pedidoDAO.obterPedido());
		return listaPedido;
	}

	//Retorna todos os produtos cadastrados no banco de dados
		public List<Produto> obterProdutos(){
			return pedidoDAO.obterProdutos();
		}
		
		

}

