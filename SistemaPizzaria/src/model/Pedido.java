package model;

public class Pedido {



	public String nomeP;
	public String telefoneP;
	public String enderecoP;
	public String produtoP;
	public int quantidadeP;
	public double taxaEntregaP;
	public double totalP;
	
	public Pedido(String nomeP, String telefoneP, String enderecoP, String produtoP, int quantidadeP, double taxaEntregaP, double totalP) {
		this.nomeP = nomeP;
		this.telefoneP = telefoneP;
		this.enderecoP = enderecoP;
		this.produtoP = produtoP;
		this.quantidadeP = quantidadeP;
		this.taxaEntregaP = taxaEntregaP;
		this.totalP = totalP;
	}
	
	public Pedido() {
		
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s Total: %s", this.nomeP, ""+this.totalP);
	};
	
}
