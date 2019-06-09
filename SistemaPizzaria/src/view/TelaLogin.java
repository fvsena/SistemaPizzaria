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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaLogin extends Application implements  EventHandler<ActionEvent>{

	Label titulo = new Label("Odin - Sistema de Pizzaria");
	Label usuario = new Label("USUARIO");
	Label senha = new Label("SENHA");

	TextField txtUsuario = new TextField("");
	TextField txtSenha= new TextField("");

	Button btnLogin = new Button("LOGAR");
	Button btnSair = new Button("SAIR");


	public void handle(ActionEvent event) {
		Stage janela = (Stage)((Node) event.getSource()).getScene().getWindow();

		TelaPrincipal p = new TelaPrincipal();
		if (event.getTarget() == btnSair) {
			p.sair(janela);
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 400, 250);
		stage.setScene(scn);
		painel.getChildren().add(titulo);
		painel.getChildren().add(usuario);
		painel.getChildren().add(senha);
		painel.getChildren().add(btnLogin);
		painel.getChildren().add(btnSair);
		painel.getChildren().add(txtUsuario);
		painel.getChildren().add(txtSenha);	
		observadores();
		posicionamento();
		titulo.setFont(Font.font("Arial", 32));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("LOGIN");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private void observadores() {
		btnSair.addEventFilter(ActionEvent.ACTION, this);
	}

	private void posicionamento() {
		titulo.relocate(10, 10);
		usuario.relocate(120, 130);
		senha.relocate(120, 160);
		txtUsuario.relocate(190, 130);
		txtSenha.relocate(190,160);
		btnLogin.relocate(285, 200);
		btnSair.relocate(190, 200);
	}

}


