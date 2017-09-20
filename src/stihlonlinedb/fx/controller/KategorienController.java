package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class KategorienController implements Initializable {

	@FXML
	private FlowPane kategoriePane;
	@FXML
	private Label kategorienLabel;
	@FXML
	private AnchorPane anchorPaneKategorien;

	private MainController mainController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addLabel();
		addKategorienFlowPaneContent();
	}

	private void addLabel() {
		kategorienLabel.setText("Produktkategorien");
		kategorienLabel.getStyleClass().add("labelProductView");
		kategorienLabel.setPadding(new Insets(10, 10, 10, 10));
	}

	private void addKategorienFlowPaneContent() {
		kategoriePane.setPadding(new Insets(15));
		kategoriePane.setVgap(4);
		kategoriePane.setHgap(4);
		kategoriePane.setPrefWrapLength(170);
	}

	/**
	 * @return the vboxKategorien
	 */
	public AnchorPane getAnchorPaneKategorien() {
		return anchorPaneKategorien;
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	/**
	 * @return the kategorienLabel
	 */
	public Label getKategorienLabel() {
		return kategorienLabel;
	}

}
