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

public class TelaLogin extends Application implements  EventHandler<ActionEvent>{

	Label usuario = new Label("USUARIO");
	Label senha = new Label("SENHA");
	
	TextField txtUsuario = new TextField("");
	TextField txtSenha= new TextField("");
	
	Button btnLogin = new Button("LOGAR");
	Button btnSair = new Button("SAIR");

	
	public void handle(ActionEvent event) {
		
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane painel = new Pane();
		Scene scn = new Scene(painel, 400, 350);
		stage.setScene(scn);
		painel.getChildren().add(usuario);
		painel.getChildren().add(senha);
		painel.getChildren().add(btnLogin);
		painel.getChildren().add(btnSair);
		painel.getChildren().add(txtUsuario);
		painel.getChildren().add(txtSenha);	
		
		posicionamento();
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("LOGIN");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private void posicionamento() {
		usuario.relocate(50, 30);
		senha.relocate(50, 100);
		txtUsuario.relocate(150, 30);
		txtSenha.relocate(150,100);
		btnLogin.relocate(200, 200);
		btnSair.relocate(50, 200);
	}

}
	

