package model;

public class Pedido {



	public String nomeP;
	public int telefoneP;
	public String enderecoP;
	public  Produto produtoP;
	public int quantidadeP;
	public int taxaEntregaP;
	public int totalP;
	
	public Pedido(String nomeP, int telefoneP, String enderecoP, Produto produto, int quantidadeP, int taxaEntregaP, int totalP) {
		this.nomeP = nomeP;
		this.telefoneP = telefoneP;
		this.enderecoP = enderecoP;
		this.produtoP = produtoP;
		this.quantidadeP = quantidadeP;
		this.taxaEntregaP = taxaEntregaP;
		this.totalP = totalP;
	}
	
	
}