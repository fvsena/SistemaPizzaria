package model;

public class Produto {
	public String nome;
	public String ingredientes;
	public double valor;
	
	public Produto(String nome, String ingredientes, double valor) {
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.valor = valor;
	}
	
	public Produto() {
		
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(String.format("Nome: %s \n", this.nome));
		s.append(String.format("Ingredientes: %s \n", this.ingredientes));
		s.append(String.format("Valor: %s \n", ""+this.valor));
		return s.toString();
	}
	
	
}
