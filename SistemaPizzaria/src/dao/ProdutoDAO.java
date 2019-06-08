package dao;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public void adicionarProduto(Produto p) {
		listaProdutos.add(p);
	}
	
	public List<Produto> obterProdutos(){
		return listaProdutos;
	}
}