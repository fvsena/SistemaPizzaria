package dao;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public void adicionarProduto(Produto p) {
		this.listaProdutos.add(p);
	}
	
	public List<Produto> obterProdutos(){
		return this.listaProdutos;
	}
}
