package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController extends Pane implements Initializable {

	@FXML
	private ProdukteController productPaneController;
	@FXML
	private KategorienController kategorienPaneController;
	@FXML
	private MenubarController menubarController;
	@FXML
	private SuchenController suchePaneController;
	@FXML
	private BorderPane mainBorderPane;
	@FXML
	private StackPane centerStackPane;
	// @FXML
	// private DetailDialogController detailDialogController;
	// @FXML
	// private AnchorPane mainAnchorPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		productPaneController.init(this);
		kategorienPaneController.init(this);
		menubarController.init(this);
		suchePaneController.init(this);
		// detailDialogController.init(this);
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

	/**
	 * @return the suchePane
	 */
	public MenubarController getMenubarController() {
		return menubarController;
	}

	/**
	 * @return the suchePaneController
	 */
	public SuchenController getSuchePaneController() {
		return suchePaneController;
	}

	/**
	 * @return the mainBorderPane
	 */
	public BorderPane getMainBorderPane() {
		return mainBorderPane;
	}

	/**
	 * @return the centerStackPane
	 */
	public StackPane getCenterStackPane() {
		return centerStackPane;
	}

	// /**
	// * @return the detailDialogController
	// */
	// public DetailDialogController getDetailDialogController() {
	// return detailDialogController;
	// }
	//
	// /**
	// * @return the mainAnchorPane
	// */
	// public AnchorPane getMainAnchorPane() {
	// return mainAnchorPane;
	// }

}
