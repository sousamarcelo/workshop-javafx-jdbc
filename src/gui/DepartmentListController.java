package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepatment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnMane;
	
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewActin(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		createDialogForm("/gui/DepartmentForm.fxml", parentStage);
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNode();		
	}

	private void initializeNode() {
		
		// esse dois abaixo � um padr�o do javaFX para iniciar as colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnMane.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// comando para configurar o tamanho da janale da table Department e deixa do tamanho da tela
		Stage stage = (Stage)Main.getMainScene().getWindow();
		tableViewDepatment.prefHeightProperty().bind(stage.heightProperty());		
	}
	
	public void updateTableView () {
		if (service == null) {
			throw new IllegalStateException("service was null!");
		}
		//carregando a lista da ca classe servicos (findAll) para a tabela department na tela
		List<Department>list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepatment.setItems(obsList);
		
	}
	
	private void createDialogForm(String absoluteName ,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Department data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
