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
	

		public int adicionarPedido(Pedido pedido) {
			int linhasAfetadas = 0;
			try {
			String sql = ""
					+ "INSERT INTO Pedido (telefone, nome, endereco, produto, quantidade, taxaEntrega, total) VALUES (?, ?, ?,?, ?, ?,?)";
					Connection conn = ConnectionManager.getInstance().getConnection();
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setInt(1, pedido.telefoneP);
					statement.setString(2, pedido.nomeP);
					statement.setString(3, pedido.enderecoP);
					//statement.setProduto(2, pedido.produtoP);
					statement.setDouble(3, pedido.quantidadeP);
					statement.setDouble(3, pedido.taxaEntregaP);
					statement.setDouble(3, pedido.totalP);
					
					linhasAfetadas = statement.executeUpdate();
					return linhasAfetadas;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

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
					0, rs.getString("nome"),
					null, rs.getInt("endereco"), 0, 0));
					rs.getInt("produto");
					rs.getInt("quantidade");
					rs.getInt("taxaEntrega");
					rs.getInt("total");
		
	} catch (SQLException e) {
		e.printStackTrace();
	
	return listaPedido;}
	
	
	public ObservableList<Produto> tipoProduto = FXCollections.observableArrayLis obterPedido();
	
}
		
