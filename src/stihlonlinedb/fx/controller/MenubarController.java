package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class MenubarController implements Initializable {
	@FXML
	private MenuItem closeItem;
	@FXML
	private MenuItem searchItem;
	@FXML
	private MenuBar menubar;

	private MainController mainController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		closeItem.setOnAction((event) -> {
			Platform.exit();
		});

		searchItem.setOnAction((event -> {
			ObservableList<Node> children = mainController.getCenterStackPane().getChildren();
			for (Node node : children) {
				if (node instanceof AnchorPane) {
					AnchorPane ap = (AnchorPane) node;
					if ("anchorPaneKategorien".equals(ap.getId())) {
						ap.setVisible(false);
					} else if ("suchePane".equals(ap.getId())) {
						ap.setVisible(true);
					}
				}
			}
			ObservableList<Node> childrenP = mainController.getProductPaneController().getProductPane().getChildren();
			for (Node tb : childrenP) {
				((ToggleButton) tb).setSelected(false);
			}
		}));

	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	/**
	 * @return the menubar
	 */
	public MenuBar getMenubar() {
		return menubar;
	}

}
