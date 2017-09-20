package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.entities.Produkte;

public class ProdukteController implements Initializable {
	@FXML
	private HBox productHBox;
	@FXML
	private Label produkteLabel;
	@FXML
	private FlowPane productPane;
	@FXML
	private AnchorPane centerPane;

	@FXML
	private KategorienController katCon;
	VBox vboxKategorien;
	KategorienController c;
	FXMLLoader fxmlLoader;
	private MainController mainController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addProductFlowPaneContent();
		addLabel();
	}

	private void addLabel() {
		produkteLabel.setText("STIHL Produkte");
		produkteLabel.getStyleClass().add("labelProductView");
	}

	private void addProductFlowPaneContent() {
		productPane.setPadding(new Insets(10, 10, 10, 10));
		productPane.setVgap(4);
		productPane.setHgap(4);
		productPane.setPrefWrapLength(170);

		ListDbObjects dbObjects = new ListDbObjects();
		List<Produkte> allProdukte = dbObjects.getAllProdukte();
		int idCounter = 0;
		for (Produkte produkte : allProdukte) {
			Image image = new Image(getClass().getResourceAsStream("/pics/" + produkte.getBild().getPfad()), 160, 100,
					true, true);
			ImageView view = new ImageView(image);
			Button btn = new Button(produkte.getName(), view);
			btn.setId("productBtn_" + idCounter);
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setMaxWidth(160);
			btn.setMinHeight(140);
			btn.setWrapText(true);
			btn.getStyleClass().add("btnProductView");

			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					KategorienController kategorienPaneController = mainController.getKategorienPaneController();
					if ("productBtn_1".equals(((Button) e.getSource()).getId())) {
						kategorienPaneController.addKategorienToFlowPane(((Button) e.getSource()).getId());
						kategorienPaneController.getAnchorPaneKategorien().setVisible(true);
						kategorienPaneController.setDefaultView(false);
						kategorienPaneController.getKategorienLabel().setText(((Button) e.getSource()).getText());
					} else {
						kategorienPaneController.getKategoriePane().getChildren().clear();
						kategorienPaneController.getKategorienLabel().setText("sorry... nur zu Demozwecken...");
						kategorienPaneController.setDefaultView(true);
					}
				}
			});
			idCounter++;
			productPane.getChildren().add(btn);
		}

	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}
}
