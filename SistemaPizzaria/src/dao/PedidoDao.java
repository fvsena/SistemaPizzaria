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
			statement.setString(4, pedido.produtoP.nome);
			statement.setDouble(5, pedido.quantidadeP);
			statement.setDouble(6, pedido.taxaEntregaP);
			statement.setDouble(7, pedido.totalP);

			linhasAfetadas = statement.executeUpdate();
			return linhasAfetadas;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

<<<<<<< HEAD
	public List<Pedido> obterPedido(){

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
						null,
						rs.getInt("quantidade"),
						rs.getInt("taxa"),
						rs.getInt("total")));
				rs.getInt("produto");
				rs.getInt("quantidade");
				rs.getInt("taxaEntrega");
				rs.getInt("total");

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

=======
public List<Pedido> obterPedido(){
	
	try {
		String sql = ""
				+ "SELECT telefone, nome, endereco, produto, quantidade, taxaEntrega, total "
				+ "FROM Pedido";
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			listaPedidos.add( new Pedido(
					rs.getString("telefone"),
					 rs.getString("nome"),
					 rs.getString("endereco")
					rs.getString("produto");
					rs.getInt("quantidade");
					rs.getInt("taxaEntrega");
					rs.getInt("total")));
		
	} catch (SQLException e) {
		e.printStackTrace();
	
	return listaPedido;}
	
	
	public ObservableList<Produto> tipoProduto = FXCollections.observableArrayLis obterPedido();
	
>>>>>>> 170293a9d1f4b16279f063a4dae726f01d1a56d9
}

