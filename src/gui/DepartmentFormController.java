package gui;

import java.net.URL;
import java.nio.channels.IllegalSelectorException;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {
	
	private Department entity;
	
	@FXML
	private TextField txId;
	
	@FXML
	private TextField txName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNode();		
	}
	
	private void initializeNode() {
		Constraints.setTextFieldInteger(txId);
		Constraints.setTextFieldMaxLength(txName, 30);
	}
	
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null!");
		}
		txId.setText(String.valueOf(entity.getId()));
		txName.setText(entity.getName());
		
	}

}
