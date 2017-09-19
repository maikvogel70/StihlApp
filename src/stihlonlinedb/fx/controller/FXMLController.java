package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.entities.Produkte;

public class FXMLController implements Initializable {
	@FXML
	private HBox productHBox;
	@FXML
	private Label label;
	@FXML
	private FlowPane productPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// addProductPane();
		addProductFlowPaneContent();
		addLabel();
	}

	private void addLabel() {
		label.setText("STIHL Produkte");
		label.getStyleClass().add("labelProductView");
	}

	private void addProductPane() {
		Button btn = new Button("halloBtn");
		productHBox.getChildren().add(btn);
		productHBox.setVisible(true);
	}

	private void addProductFlowPaneContent() {
		productPane.setPadding(new Insets(10, 10, 10, 10));
		productPane.setVgap(4);
		productPane.setHgap(4);
		productPane.setPrefWrapLength(170);

		ListDbObjects dbObjects = new ListDbObjects();
		List<Produkte> allProdukte = dbObjects.getAllProdukte();

		for (Produkte produkte : allProdukte) {
			Image image = new Image(getClass().getResourceAsStream("/pics/" + produkte.getBild().getPfad()), 160, 100,
					true, true);
			ImageView view = new ImageView(image);
			Button btn = new Button(produkte.getName(), view);
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setMaxWidth(160);
			btn.setMinHeight(140);
			btn.setWrapText(true);
			btn.getStyleClass().add("btnProductView");
			productPane.getChildren().add(btn);
		}

	}
}
