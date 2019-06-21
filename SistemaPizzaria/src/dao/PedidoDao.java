package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pedido;
import model.Produto;

public class PedidoDao {

	private static List<Pedido> listaPedidos = new ArrayList<Pedido>();
	public ObservableList<Produto> tipoProduto = FXCollections.observableArrayList();

	public int adicionarPedido(Pedido pedido) {
		int linhasAfetadas = 0;
		try {
			String sql = ""
					+ "INSERT INTO Pedido (telefone, nome, endereco, produto, quantidade, taxaEntrega, total) VALUES (?, ?, ?,?, ?, ?,?)";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, pedido.telefoneP);
			statement.setString(2, pedido.nomeP);
			statement.setString(3, pedido.enderecoP);
			statement.setString(4, pedido.produtoP);
			statement.setDouble(5, pedido.quantidadeP);
			statement.setDouble(6, pedido.taxaEntregaP);
			statement.setDouble(7, pedido.totalP);

			linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}


	public List<Pedido> obterPedido(){
		listaPedidos.clear();
		try {
			String sql = ""
					+ "SELECT telefone, nome, endereco, produto, quantidade, taxaEntrega, total "
					+ "FROM Pedido";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				listaPedidos.add( new Pedido(
						rs.getString("nome"),
						rs.getString("telefone"),
						rs.getString("endereco"),
						rs.getString("produto"),
						rs.getInt("quantidade"),
						rs.getDouble("taxaEntrega"),
						rs.getDouble("total")));
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPedidos;
	}

	//Retorna todos os produtos cadastrados no banco de dados
	public List<Produto> obterProdutos(){
		tipoProduto.clear();
		try {
			String sql = ""
					+ "SELECT Nome, Ingredientes, Valor "
					+ "FROM Produto";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				tipoProduto.add(new Produto(
						rs.getString("Nome"),
						rs.getString("Ingredientes"),
						rs.getDouble("Valor")));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipoProduto;
	}


}
