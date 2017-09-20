package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainController implements Initializable {

	@FXML
	private ProdukteController productPaneController;
	@FXML
	private KategorienController kategorienPaneController;

	private BooleanProperty isVisible = new SimpleBooleanProperty(false);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		productPaneController.init(this);
		kategorienPaneController.init(this);
	}

	/**
	 * @return the productPaneController
	 */
	public ProdukteController getProductPaneController() {
		return productPaneController;
	}

	/**
	 * @return the kategorienPaneController
	 */
	public KategorienController getKategorienPaneController() {
		return kategorienPaneController;
	}

	public void setContentVisible(boolean isVisible) {
		kategorienPaneController.getAnchorPaneKategorien().setVisible(isVisible);
	}

	/**
	 * @return the isVisible
	 */
	public BooleanProperty getIsVisible() {
		return isVisible;
	}

}
