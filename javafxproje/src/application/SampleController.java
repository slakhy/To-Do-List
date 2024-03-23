package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.model;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import taskSerializer.TaskSerializer;

public class SampleController implements Initializable{
	@FXML
	private Button addTaskButton;
	@FXML
	private TextField taskdescription;
	@FXML 
	DatePicker chooseDatePicker;
	@FXML
	private Button buttonDelete;
	@FXML
	private ListView<model> taskListView;
	ObservableList<model> dataModels=FXCollections.observableArrayList();
	
	@FXML
	private void buttonCode() {
		
		var newTask= new model(chooseDatePicker.getValue(),taskdescription.getText());
		
		dataModels.add(newTask);
		taskListView.setItems(dataModels);
	}
      @FXML
      private void deletebutton(ActionEvent e) {
    	  dataModels.remove(taskListView.getSelectionModel().getSelectedIndex());
      }
      @FXML
      private void textFieldEnter(KeyEvent event) {
    	  if(event.getCode()==KeyCode.ENTER) {
    		  buttonCode();
    	  }
      }
	public Object[] takeTasks() {
		return taskListView.getItems().toArray();
	}
      @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chooseDatePicker.setValue(LocalDate.now());
	try {
		var task=TaskSerializer.deserialize();
		taskListView.getItems().addAll(task);
	} catch (Exception e) {
         Alert alert=new Alert(AlertType.ERROR);
         alert.setTitle("ToDoApp Excwption");
         alert.setHeaderText("Tasks can not be loaded.Please check your file system.");
}
      }
	
}

