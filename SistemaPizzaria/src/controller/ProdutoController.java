package controller;

import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Produto;

public class ProdutoController {
	//Instância da classe que manipula o banco de dados
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	//Lista de produtos que retorna do banco de dados
	private ObservableList<Produto> listaProduto = FXCollections.observableArrayList();
	
	//Insere um produto no banco de dados
	public int adicionarProduto(Produto p) {
		return produtoDAO.adicionarProduto(p);
	}
	
	//Exclui um produto no banco de dados
	public int excluirProduto(Produto p) {
		return produtoDAO.excluirProduto(p);
	}
	
	//Retorna todos os produtos cadastrados no banco de dados
	public ObservableList<Produto> obterProdutos(){
		listaProduto.clear();
		listaProduto.addAll(produtoDAO.obterProdutos());
		return listaProduto;
	}
}
