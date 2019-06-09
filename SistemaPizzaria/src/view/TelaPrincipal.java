package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaPrincipal extends Application implements EventHandler<ActionEvent> {

	private Label lblTitulo = new Label("Odin - Sistema gerenciador de pedidos");
	private Button btnProduto = new Button("Cadastro de Produtos");
	private Button btnPedido = new Button("Cadastro de Pedidos");
	private Button btnFechar = new Button("Fechar");

	@Override
	public void handle(ActionEvent event) {
		Stage janela = (Stage)((Node) event.getSource()).getScene().getWindow();
		if (event.getTarget() == btnProduto) {
			abrirProduto(janela);
		} else if (event.getTarget() == btnFechar) {
			sair(janela);
		}

		if (event.getTarget() == btnPedido) {
			abrirPedido(janela);

		}}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 800,150);
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
		lblTitulo.relocate(50, 10);
		btnPedido.relocate(50, 80);
		btnProduto.relocate(200, 80);
		btnFechar.relocate(720, 80);
	}

	private void adicionarComponentes(Pane pane) {
		pane.getChildren().add(btnPedido);
		pane.getChildren().add(btnProduto);
		pane.getChildren().add(btnFechar);
		pane.getChildren().add(lblTitulo);
		lblTitulo.setFont(Font.font("Arial", 32));
	}

	private void adicionarObservadores() {
		btnPedido.addEventFilter(ActionEvent.ACTION, this);
		btnProduto.addEventFilter(ActionEvent.ACTION, this);
		btnFechar.addEventFilter(ActionEvent.ACTION, this);
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

	private void abrirPedido(Stage parent) {
		TelaPedido tP = new TelaPedido();
		try {
			Stage novaTela = new Stage();

			novaTela.initModality(Modality.WINDOW_MODAL);
			novaTela.initOwner(parent);
			tP.start(novaTela);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void sair(Stage s) {
		try {
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
