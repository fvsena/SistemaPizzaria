package view;

import javax.swing.JOptionPane;

import controller.PedidoController;
import controller.ProdutoController;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Pedido;
import model.Produto;

public class TelaPedido extends Application implements EventHandler<ActionEvent> {

	private PedidoController controller = new PedidoController();

	Label telefone = new  Label("TELEFONE");
	Label nome = new  Label( "NOME");
	Label endereco =  new  Label("ENDERECO");
	Label produto =  new  Label("PRODUTO");
	Label quantidade =  new  Label("QUANTIDADE");
	Label taxaEntrega = new  Label("TAXA DE ENTREGA");
	Label total =  new  Label("TOTAL");

	TextField txtTelefone = new  TextField();
	TextField txtNome = new  TextField ( );
	TextField txtEndereco =  new TextField();
	TextField txtProduto =  new  TextField();
	ComboBox<Produto> cmbProduto = new ComboBox<Produto>();
	TextField txtQuantidade =  new  TextField();
	TextField txtTaxaEntrega = new  TextField();
	TextField txtTotal =  new TextField( );

	Button btnGravar = new  Button("GRAVAR");
	Button btnSair = new  Button("SAIR");

	private TableView<Pedido> tbPedido = new TableView<Pedido>();
	TelaPrincipal p = new TelaPrincipal();


	public void handle(ActionEvent event) {
		Stage janela = (Stage)((Node) event.getSource()).getScene().getWindow();
		if (event.getTarget() == btnSair) {
			p.sair(janela);
		}
		if (event.getTarget() == btnGravar){
			adicionarPedido();

		}}

	private void adicionarPedido() {

		if (validarCampos() == false ) {
			JOptionPane.showMessageDialog(null, "Dados inválidos!");
			return;
		}
		
		Pedido pedido = new Pedido(null, null, null, null, 0, 0, 0);

		pedido.nomeP = txtNome.getText();
		pedido.telefoneP = txtTelefone.getText();
		pedido.enderecoP = txtEndereco.getText();
		pedido.produtoP = cmbProduto.getValue().toString();
		pedido.quantidadeP = Integer.parseInt(txtQuantidade.getText());
		pedido.taxaEntregaP = Integer.parseInt(txtTaxaEntrega.getText());
		pedido.totalP = Integer.parseInt(txtTotal.getText());

		

		if (controller.adicionarPedido(pedido) > 0) {
			JOptionPane.showMessageDialog(null, String.format("Pedido adicionado com suceso! \n %s",p.toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o pedido!");
		}
		tbPedido.setItems(controller.obterPedido());
	}

	private boolean validarCampos() {
		boolean valido = true;
		if (
				txtNome.getText().equals("") || 
				txtTelefone.getText().equals("") || 
				cmbProduto.getValue().toString().equals("") || 
				txtQuantidade.getText().equals("") || 
				txtTaxaEntrega.getText().equals("")  ||
				txtTelefone.getText().equals("")
				){
			valido = false;
		}else {
			try {
				Integer.parseInt(txtQuantidade.getText());
				Integer.parseInt(txtTaxaEntrega.getText());

			} catch (Exception e) {
				valido = false;
			}
		}
		return valido;
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 400, 380);
		stage.setScene(scn);
		posicao();
		adicionarObservadores();

		painel.getChildren().add(telefone);
		painel.getChildren().add(nome);
		painel.getChildren().add(endereco);
		painel.getChildren().add(produto);
		painel.getChildren().add(quantidade);
		painel.getChildren().add(taxaEntrega);
		painel.getChildren().add(total);

		painel.getChildren().add(btnGravar);
		painel.getChildren().add(btnSair);

		painel.getChildren().add(txtTelefone);
		painel.getChildren().add(txtNome);
		painel.getChildren().add(txtEndereco);
		//painel.getChildren().add(txtProduto);
		painel.getChildren().add(cmbProduto);
		painel.getChildren().add(txtQuantidade);
		painel.getChildren().add(txtTaxaEntrega);
		painel.getChildren().add(txtTotal);
		carregaProduto();
		stage.setTitle("PEDIDOS");
		stage.show();	
	}

	private void adicionarObservadores() {
		btnSair.addEventFilter(ActionEvent.ACTION, this);
		btnGravar.addEventFilter(ActionEvent.ACTION,this);

	}

	public static void main(String[] args) {
		Application.launch();
	}

	private void posicao() {
		telefone.relocate(50,100);
		nome.relocate(50,130);
		endereco.relocate(50,160);
		produto.relocate(50,190);
		quantidade.relocate(50,220);
		taxaEntrega.relocate(50,250);
		total.relocate(50,280);

		btnGravar.relocate(50,320);
		btnSair.relocate(200,320);

		txtTelefone.relocate(200,100);
		txtNome.relocate(200,130);
		txtEndereco.relocate(200,160);
		//txtProduto.relocate(200,190);
		cmbProduto.relocate(200,190);
		txtQuantidade.relocate(200,220);
		txtTaxaEntrega.relocate(200,250);
		txtTotal.relocate(200,280);
	}

	private void carregaProduto() {
		cmbProduto.getItems().addAll(controller.obterProdutos());
	}
	
	private void popularPedido(Pedido p) {
		txtNome.setText(p.nomeP);
		txtTelefone.setText(p.telefoneP);
		txtQuantidade.setText(""+p.quantidadeP);
	}
	
	private void popularTabelaPizza() {
		//Define o conteudo da tabela como o resultado da consulta do banco de dados
		tbPedido.setItems(controller.obterPedido());
		
		//Quando um valor da tabela for selecionado, o método popularProduto é acionado e atualiza o conteudo dos textboxs
		tbPedido.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Pedido>() {
					public void changed(ObservableValue<? extends Pedido> p, Pedido p1, Pedido p2) {
						popularPedido(p2);
					}
				});
	TableColumn<Pedido, String> colunaNome = new TableColumn<>();
	colunaNome.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().nomeP));
	

	TableColumn<Pedido, String> colunaTelefone = new TableColumn<>();
	colunaTelefone.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().telefoneP));
	
	TableColumn<Pedido, String> colunaQuantidade = new TableColumn<>();
	colunaQuantidade.setCellValueFactory(item -> new ReadOnlyStringWrapper(""+item.getValue().quantidadeP));
	
	colunaNome.setText("Nome");
	colunaTelefone.setText("Telefone");
	colunaQuantidade.setText("Quantidade");
	
	tbPedido.getColumns().addAll(colunaNome, colunaTelefone, colunaQuantidade);

}}
