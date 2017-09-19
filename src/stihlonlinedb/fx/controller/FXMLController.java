package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class FXMLController implements Initializable{
	@FXML
	private HBox productHBox;
	@FXML
	private Label label;

	public FXMLController() {
	}
	
	
	private void addLabel() {
		label = new Label("hallo");
		productHBox.getChildren().add(label);
	}


	private void addProductPane() {
		productHBox = new HBox();
		productHBox.setPadding(new Insets(5, 0, 5, 0));
		productHBox.setStyle("-fx-background-color: DAE6F3;");

	    Button btn = new Button("hallo");
	    productHBox.getChildren().add(btn);
	    productHBox.setVisible(true);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addProductPane();
		addLabel();		
	}
}
