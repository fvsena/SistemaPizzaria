package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Produto;

public class TelaPedido extends Application implements EventHandler<ActionEvent> {

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


	public void handle(ActionEvent event) {
		Stage janela = (Stage)((Node) event.getSource()).getScene().getWindow();
		TelaPrincipal p = new TelaPrincipal();
		if (event.getTarget() == btnSair) {
			p.sair(janela);
		}}

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

		stage.setTitle("PEDIDOS");
		stage.show();	
	}

	private void adicionarObservadores() {
		btnSair.addEventFilter(ActionEvent.ACTION, this);
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
}
