package controller;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	public int adicionarProduto(Produto p) {
		return produtoDAO.adicionarProduto(p);
	}
	
	public void mostrarProdutos() {
		for (Produto p : produtoDAO.obterProdutos()) {
			System.out.println(p.toString());
		}
	}
}
