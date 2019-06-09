package view;

import javax.swing.JOptionPane;

import controller.LoginController;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaLogin extends Application implements  EventHandler<ActionEvent>{

	LoginController controller = new LoginController();
	Label titulo = new Label("Odin - Sistema de Pizzaria");
	Label usuario = new Label("USUARIO");
	Label senha = new Label("SENHA");

	TextField txtUsuario = new TextField("");
	TextField txtSenha= new TextField("");

	Button btnLogin = new Button("LOGAR");
	Button btnSair = new Button("SAIR");


	public void handle(ActionEvent event) {
		Stage janelaLogin = (Stage)((Node) event.getSource()).getScene().getWindow();
		if (event.getTarget() == btnSair) {
			sair(janelaLogin);
			
		}
		else if(event.getTarget() == btnLogin){
			
			 verificarLogin(janelaLogin);
			 
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
		btnLogin.addEventFilter(ActionEvent.ACTION, this);
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
	
	private void verificarLogin(Stage janelaLogin) {
		String usuario = txtUsuario.getText();
		String senha = txtSenha.getText();
		
		if (controller.validarLogin(usuario, senha)) {
			//Direciona pro menu
			abrirMenuPrincipal();
			sair(janelaLogin);
		} else {
			//Mensagem de usuário ou senha inválido
		JOptionPane.showMessageDialog(null, "Login Invalido");
		}
	}
	
	private void abrirMenuPrincipal() {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		try {
			Stage entrarMenu = new Stage();
			entrarMenu.initModality(Modality.NONE);
			
			telaPrincipal.start(entrarMenu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sair(Stage janelaLogin) {
		try {
			janelaLogin.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}


