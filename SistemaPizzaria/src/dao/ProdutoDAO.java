package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Produto;

public class ProdutoDAO {
	//Lista de Produtos
	private static List<Produto> listaProdutos = new ArrayList<Produto>();
	
	//Insere um produto no banco de dados
	public int adicionarProduto(Produto p) {
		int linhasAfetadas = 0;
		try {
			String sql = ""
					+ "INSERT INTO Produto (Nome, Ingredientes, Valor) "
					+ "VALUES (?, ?, ?)";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, p.nome);
			statement.setString(2, p.ingredientes);
			statement.setDouble(3, p.valor);
			linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhasAfetadas;
	}
	
	//Exclui um produto no banco de dados
	public int excluirProduto(Produto p) {
		int linhasAfetadas = 0;
		try {
			String sql = ""
					+ "DELETE FROM Produto WHERE "
					+ "Nome = ?";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, p.nome);
			linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhasAfetadas;
	}
	
	//Retorna todos os produtos cadastrados no banco de dados
	public List<Produto> obterProdutos(){
		listaProdutos.clear();
		try {
			String sql = ""
					+ "SELECT Nome, Ingredientes, Valor "
					+ "FROM Produto";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				listaProdutos.add(new Produto(
						rs.getString("Nome"),
						rs.getString("Ingredientes"),
						rs.getDouble("Valor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}
	
	public ObservableList<Produto> tipoProduto = FXCollections.observableArrayList(
			obterProdutos()
		);
}
