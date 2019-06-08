package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaPrincipal extends Application implements EventHandler<ActionEvent> {
	
	private Button btnProduto = new Button("Cadastro de Produtos");
	private Button btnPedido = new Button("Cadastro de Pedidos");
		
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnProduto) {
			Stage principal = (Stage)((Node) event.getSource()).getScene().getWindow();
			abrirProduto(principal);
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 800,600);
		posicionarComponentes();
		adicionarComponentes(pane);
		adicionarObservadores();
		stage.setTitle("Odin - Sistema Gerenciador de Pedidos de Pizzaria");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private void posicionarComponentes() {
		btnPedido.relocate(50, 50);
		btnProduto.relocate(200, 50);
	}
	
	private void adicionarComponentes(Pane pane) {
		pane.getChildren().add(btnPedido);
		pane.getChildren().add(btnProduto);
	}
	
	private void adicionarObservadores() {
		btnPedido.addEventFilter(ActionEvent.ACTION, this);
		btnProduto.addEventFilter(ActionEvent.ACTION, this);
	}
	
	private void abrirProduto(Stage parent) {
		TelaProduto telaProduto = new TelaProduto();
		try {
			Stage novaTela = new Stage();
			novaTela.initModality(Modality.WINDOW_MODAL);
			novaTela.initOwner(parent);
			telaProduto.start(novaTela);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
