package view;

import javax.swing.JOptionPane;

import controller.ProdutoController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Produto;

public class TelaProduto extends Application implements EventHandler<ActionEvent> {
	private ProdutoController controller = new ProdutoController();
	private Label lblNome = new Label("Nome: ");
	private Label lblIngredientes = new Label("Ingredientes: ");
	private Label lblValor = new Label("Valor: ");
	private TextField txtNome = new TextField();
	private TextField txtIngredientes = new TextField();
	private TextField txtValor = new TextField();
	private Button btnGravar = new Button("Gravar");
	private Button btnSair = new Button("Sair");
	private Button btnExibirProdutos = new Button("Exibir Produtos");
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnSair) {
			sair();
		}
		else if (event.getTarget() == btnGravar) {
			adicionarProduto();
		}
		else if (event.getTarget() == btnExibirProdutos) {
			exibirProdutos();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400,200);
		posicionarComponentes();
		adicionarComponentes(pane);
		adicionarObservadores();
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private void posicionarComponentes() {
		lblNome.relocate(50, 50);
		lblIngredientes.relocate(50,80);
		lblValor.relocate(50,110);
		txtNome.relocate(150, 50);
		txtIngredientes.relocate(150,80);
		txtValor.relocate(150, 110);
		btnGravar.relocate(220, 150);
		btnExibirProdutos.relocate(105, 150);
		btnSair.relocate(50, 150);
	}
	
	private void adicionarComponentes(Pane pane) {
		pane.getChildren().add(lblNome);
		pane.getChildren().add(lblIngredientes);
		pane.getChildren().add(lblValor);
		pane.getChildren().add(txtNome);
		pane.getChildren().add(txtIngredientes);
		pane.getChildren().add(txtValor);
		pane.getChildren().add(btnGravar);
		pane.getChildren().add(btnExibirProdutos);
		pane.getChildren().add(btnSair);
	}
	
	private void adicionarObservadores() {
		btnGravar.addEventFilter(ActionEvent.ACTION, this);
		btnSair.addEventFilter(ActionEvent.ACTION, this);
		btnExibirProdutos.addEventFilter(ActionEvent.ACTION, this);
	}
	
	private void sair() {
		try {
			Platform.exit();
			System.exit(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void adicionarProduto() {
		if(!validarCampos()) {
			JOptionPane.showMessageDialog(null, "Dados inválidos!");
			return;
		}
		Produto p = new Produto();
		p.nome = txtNome.getText();
		p.ingredientes = txtIngredientes.getText();
		p.valor = Double.parseDouble(txtValor.getText());
		controller.adicionarProduto(p);
		JOptionPane.showMessageDialog(null, String.format("Produto adicionado com suceso! \n %s",p.toString()));
		limpaCampos();
	}
	
	private void exibirProdutos() {
		controller.mostrarProdutos();
	}

	private void limpaCampos() {
		txtNome.clear();
		txtIngredientes.clear();
		txtValor.clear();
	}
	
	private boolean validarCampos() {
		boolean valido = true;
		if (
				txtNome.getText().equals("") ||
				txtIngredientes.getText().equals("") ||
				txtValor.getText().equals("")){
			valido = false;
		} else {
			try {
				Double.parseDouble(txtValor.getText());
			} catch (Exception e) {
				valido = false;
			}
		}
		return valido;
	}
}
