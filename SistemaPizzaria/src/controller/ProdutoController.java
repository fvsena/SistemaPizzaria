package controller;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	public void adicionarProduto(Produto p) {
		produtoDAO.adicionarProduto(p);
	}
	
	public void mostrarProdutos() {
		for (Produto p : produtoDAO.obterProdutos()) {
			System.out.println(p.toString());
		}
	}
}
