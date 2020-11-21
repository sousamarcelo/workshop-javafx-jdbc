package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	
	@FXML
	private TableView<Department> tableViewDepatment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnMane;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewActin() {
		System.out.println("onBtNewActin");
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNode();		
	}

	private void initializeNode() {
		
		// esse dois abaixo é um padrão do javaFX para iniciar as colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnMane.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// comando para configurar o tamanho da janale da table Department e deixa do tamanho da tela
		Stage stage = (Stage)Main.getMainScene().getWindow();
		tableViewDepatment.prefHeightProperty().bind(stage.heightProperty());
		
	}

}
