package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
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
	private static final String STIHL_PRODUKTE_LABEL = "STIHL Produkte";
	private static final int IMAGE_WIDTH = 160;
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
		produkteLabel.setText(STIHL_PRODUKTE_LABEL);
		produkteLabel.getStyleClass().add("labelTitleView");
	}

	private void addProductFlowPaneContent() {
		productPane.setPadding(new Insets(10));
		productPane.setVgap(4);
		productPane.setHgap(4);

		ListDbObjects dbObjects = new ListDbObjects();
		List<Produkte> allProdukte = dbObjects.getAllProdukte();
		int idCounter = 0;
		for (Produkte produkte : allProdukte) {
			Image image = new Image(getClass().getResourceAsStream("/pics/" + produkte.getBild().getPfad()),
					IMAGE_WIDTH, 0, true, true);
			ImageView view = new ImageView(image);
			ToggleButton btn = new ToggleButton(produkte.getName(), view);
			btn.setId("productBtn_" + idCounter);
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setMaxWidth(160);
			btn.setMinHeight(140);
			btn.setWrapText(true);
			btn.getStyleClass().add("btnProductView");

			btn.setOnAction((event) -> {
				final ToggleButton toggleBtn;
				KategorienController kategorienPaneController = mainController.getKategorienPaneController();
				toggleBtn = (ToggleButton) event.getSource();

				// zur stetigen anzeige der selektierten buttons
				ObservableList<Node> children = productPane.getChildren();
				for (Node tb : children) {
					((ToggleButton) tb).setSelected(false);
				}
				toggleBtn.setSelected(true);

				if ("productBtn_1".equals(toggleBtn.getId())) {
					kategorienPaneController.addKategorienToFlowPane(toggleBtn.getId());
					kategorienPaneController.getAnchorPaneKategorien().setVisible(true);
					kategorienPaneController.setDefaultView(false);
					kategorienPaneController.getKategorienLabel().setText(toggleBtn.getText());
				} else {
					kategorienPaneController.getKategoriePane().getChildren().clear();
					kategorienPaneController.getKategorienLabel().setText("sorry... nur zu Demozwecken...");
					kategorienPaneController.setDefaultView(true);
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
