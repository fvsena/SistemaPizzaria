package controller;

import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ObservableList<Produto> listaProduto = FXCollections.observableArrayList();
	
	public int adicionarProduto(Produto p) {
		return produtoDAO.adicionarProduto(p);
	}
	
	public int excluirProduto(Produto p) {
		return produtoDAO.excluirProduto(p);
	}
	
	public ObservableList<Produto> obterProdutos(){
		listaProduto.clear();
		listaProduto.addAll(produtoDAO.obterProdutos());
		return listaProduto;
	}
}
