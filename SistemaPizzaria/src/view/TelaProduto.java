package view;

import javax.swing.JOptionPane;

import controller.ProdutoController;
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
		Stage janela = (Stage)((Node) event.getSource()).getScene().getWindow();
		if (event.getTarget() == btnSair) {
			  
			sair(janela);
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
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Cadastro de produtos");
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
	
	private void sair(Stage s) {
		try {
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void adicionarProduto() {
		txtValor.setText(formataValor(txtValor.getText()));
		if(!validarCampos()) {
			JOptionPane.showMessageDialog(null, "Dados inválidos!");
			return;
		}
		Produto p = new Produto();
		p.nome = txtNome.getText();
		p.ingredientes = txtIngredientes.getText();
		p.valor = Double.parseDouble(txtValor.getText());
		
		if (controller.adicionarProduto(p) > 0) {
			JOptionPane.showMessageDialog(null, String.format("Produto adicionado com suceso! \n %s",p.toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o produto!");
		}
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
	
	private String formataValor(String valor) {
		valor = valor.replace(",", ".");
		return valor;
	}
}
