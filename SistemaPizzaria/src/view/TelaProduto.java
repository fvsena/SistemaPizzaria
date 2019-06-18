package view;

import javax.swing.JOptionPane;

import controller.ProdutoController;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Produto;

public class TelaProduto extends Application implements EventHandler<ActionEvent> {
	//Cria uma instância do controller da tela
	private ProdutoController controller = new ProdutoController();
	
	//Cria os componentes da tela
	private Label lblNome = new Label("Nome: ");
	private Label lblIngredientes = new Label("Ingredientes: ");
	private Label lblValor = new Label("Valor: ");
	private TextField txtNome = new TextField();
	private TextField txtIngredientes = new TextField();
	private TextField txtValor = new TextField();
	private Button btnGravar = new Button("Gravar");
	private Button btnSair = new Button("Sair");
	private Button btnExcluir = new Button("Excluir");
	
	private TableView<Produto> tbProduto = new TableView<Produto>();
	
	//Método chamado quando houver uma interação na tela
	@Override
	public void handle(ActionEvent event) {
		Stage janela = (Stage)((Node) event.getSource()).getScene().getWindow();
		if (event.getTarget() == btnSair) {
			  
			sair(janela);
		}
		else if (event.getTarget() == btnGravar) {
			adicionarProduto();
		}
		else if (event.getTarget() == btnExcluir) {
			excluirProduto();
		}
		
	}

	//Método que é executado quando a tela carregar
	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 700,500);
		posicionarComponentes();
		adicionarComponentes(pane);
		popularTabelaPizza();
		adicionarObservadores();
		tbProduto.prefWidthProperty().bind(stage.widthProperty());
		stage.setScene(scene);
		//stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Cadastro de produtos");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	//Posiciona os componentes na tela
	private void posicionarComponentes() {
		lblNome.relocate(50, 50);
		lblIngredientes.relocate(50,80);
		lblValor.relocate(50,110);
		txtNome.relocate(150, 50);
		txtIngredientes.relocate(150,80);
		txtValor.relocate(150, 110);
		btnGravar.relocate(220, 150);
		btnExcluir.relocate(105, 150);
		btnSair.relocate(50, 150);
		tbProduto.relocate(0, 180);
	}
	
	//Adiciona os componentes na tela
	private void adicionarComponentes(Pane pane) {
		pane.getChildren().add(lblNome);
		pane.getChildren().add(lblIngredientes);
		pane.getChildren().add(lblValor);
		pane.getChildren().add(txtNome);
		pane.getChildren().add(txtIngredientes);
		pane.getChildren().add(txtValor);
		pane.getChildren().add(btnGravar);
		pane.getChildren().add(btnExcluir);
		pane.getChildren().add(btnSair);
		pane.getChildren().add(tbProduto);
	}
	
	//Determina quais componentes da tela terão comportamento quando o usuário interagir
	private void adicionarObservadores() {
		btnGravar.addEventFilter(ActionEvent.ACTION, this);
		btnSair.addEventFilter(ActionEvent.ACTION, this);
		btnExcluir.addEventFilter(ActionEvent.ACTION, this);
	}
	
	//Fecha a janela
	private void sair(Stage s) {
		try {
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Adiciona um produto
	private void adicionarProduto() {
		//Substitui a vírgula por ponto no campo de valor
		txtValor.setText(formataValor(txtValor.getText()));
		
		//Se houver algum campo em branco ou se o campo de valor não for um número, exibe mensagem de erro
		if(!validarCampos()) {
			JOptionPane.showMessageDialog(null, "Dados inválidos!");
			return;
		}
		
		//Cria uma instância de produto com os dados digitados na tela
		Produto p = new Produto();
		p.nome = txtNome.getText();
		p.ingredientes = txtIngredientes.getText();
		p.valor = Double.parseDouble(txtValor.getText());
		
		//Executa o método de inserir o produto no banco de dados
		//Se o retorno deste método for maior do que zero, então o Insert foi bem sucedido. Caso contrário, algum erro ocorreu
		if (controller.adicionarProduto(p) > 0) {
			JOptionPane.showMessageDialog(null, String.format("Produto adicionado com suceso! \n %s",p.toString()));
		} else {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o produto!");
		}
		
		//Limpa o conteúdo digitado nos textboxs
		limpaCampos();
		
		//Atualiza a lista de produtos da tabela
		tbProduto.setItems(controller.obterProdutos());
	}
	
	//Exclui um produto
	private void excluirProduto() {
		//Se houver algum campo em branco ou se o campo de valor não for um número, exibe mensagem de erro
		if(!validarCampos()) {
			JOptionPane.showMessageDialog(null, "Dados inválidos!");
			return;
		}
		
		//Cria uma instância de produto com os dados digitados na tela
		Produto p = new Produto();
		p.nome = txtNome.getText();
		p.ingredientes = txtIngredientes.getText();
		p.valor = Double.parseDouble(txtValor.getText());

		//Executa o método de excluir o produto no banco de dados
		//Se o retorno deste método for maior do que zero, então o Delete foi bem sucedido. Caso contrário, algum erro ocorreu
		if (controller.excluirProduto(p) > 0) {
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o produto!");
		}
		
		//Limpa o conteúdo digitado nos textboxs
		limpaCampos();
		
		//Atualiza a lista de produtos da tabela
		tbProduto.setItems(controller.obterProdutos());
	}

	//Limpa o conteudo dos textboxs
	private void limpaCampos() {
		txtNome.clear();
		txtIngredientes.clear();
		txtValor.clear();
	}
	
	//Verifica se os valores digitados são válidos
	private boolean validarCampos() {
		boolean valido = true;
		
		//Se o conteudo de algum dos texboxs nao foi preenchido, então os dados estão inválidos
		if (
				txtNome.getText().equals("") ||
				txtIngredientes.getText().equals("") ||
				txtValor.getText().equals("")){
			valido = false;
		} else {
			//Se a conversão para um valor numérico do valor digitado no txtValor der erro, então o valor não é valido
			try {
				Double.parseDouble(txtValor.getText());
			} catch (Exception e) {
				valido = false;
			}
		}

		return valido;
	}
	
	//Substitui a vírgula por ponto nos campos de valor
	private String formataValor(String valor) {
		valor = valor.replace(",", ".");
		return valor;
	}
	
	//Preenche os textboxs com dados do produto selecionado da tabela
	private void popularProduto(Produto p) {
		txtNome.setText(p.nome);
		txtIngredientes.setText(p.ingredientes);
		txtValor.setText(""+p.valor);
	}
	
	//Configura a estrutura e comportamento da tabela
	private void popularTabelaPizza() {
		//Define o conteudo da tabela como o resultado da consulta do banco de dados
		tbProduto.setItems(controller.obterProdutos());
		
		//Quando um valor da tabela for selecionado, o método popularProduto é acionado e atualiza o conteudo dos textboxs
		tbProduto.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Produto>() {
					public void changed(ObservableValue<? extends Produto> p, Produto p1, Produto p2) {
						popularProduto(p2);
					}
				});
		
		//Cria as colunas que serão inseridas na tabela
		TableColumn<Produto, String> colunaNome = new TableColumn<>();
		colunaNome.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().nome));
		
		TableColumn<Produto, String> colunaIngredientes = new TableColumn<>();
		colunaIngredientes.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().ingredientes));
		
		TableColumn<Produto, String> colunaValor = new TableColumn<>();
		colunaValor.setCellValueFactory(item -> new ReadOnlyStringWrapper(""+item.getValue().valor));
		
		//Atribui o nome das colunas
		colunaNome.setText("SABOR");
		colunaIngredientes.setText("INGREDIENTES");
		colunaValor.setText("VALOR");
		
		//Adiciona as colunas na tabela
		tbProduto.getColumns().addAll(colunaNome, colunaIngredientes, colunaValor);
	}
}
