package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FXMLController implements Initializable {
	@FXML
	private HBox productHBox;
	@FXML
	private Label label;

	public FXMLController() {
	}

	private void addLabel() {
		label.setText("hallo");
	}

	private void addProductPane() {
		Button btn = new Button("halloBtn");
		productHBox.getChildren().add(btn);
		productHBox.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addProductPane();
		addLabel();
	}
}
