package view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
		Scene scn = new Scene(painel, 800, 500);
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
			painel.getChildren().add(txtProduto);
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
		nome.relocate(50,150);
		endereco.relocate(50,200);
	produto.relocate(50,250);
		quantidade.relocate(50,300);
		taxaEntrega.relocate(50,350);
		total.relocate(50,400);
		btnGravar.relocate(50,450);
		btnSair.relocate(50,500);
		
		txtTelefone.relocate(200,100);
		txtNome.relocate(200,150);
		txtEndereco.relocate(200,200);
	txtProduto.relocate(200,250);
		txtQuantidade.relocate(200,300);
		txtTaxaEntrega.relocate(200,350);
	txtTotal.relocate(200,400);
		btnGravar.relocate(400,450);
		btnSair.relocate(700,475);
	}
	
}
