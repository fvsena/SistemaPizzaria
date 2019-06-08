package model;

public class Produto {
	public String nome;
	public String ingredientes;
	public double valor;
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(String.format("Nome: %s \n", this.nome));
		s.append(String.format("Ingredientes: %s \n", this.ingredientes));
		s.append(String.format("Valor: %s \n", ""+this.valor));
		return s.toString();
	}
	
	
}
