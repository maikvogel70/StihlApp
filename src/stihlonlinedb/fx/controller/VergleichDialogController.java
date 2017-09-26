package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.view.VergleichContentTable;

public class VergleichDialogController implements Initializable {

	private static final String SHOW_DETAIL_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";

	@FXML
	private DialogPane vergleichDetailDialog;
	@FXML
	private Button closeBtn;
	@FXML
	private FlowPane saegenVergleichContent;

	private Parent loader;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				((Stage) closeBtn.getScene().getWindow()).close();
			}
		});
		closeBtn.setStyle(closeBtn.getStyle() + SHOW_DETAIL_BTN_STYLE);
	}

	public void start(List<Saege> list) {
		VergleichContentTable tableVergleichContent = new VergleichContentTable();
		saegenVergleichContent.getChildren().add(tableVergleichContent.getVergleichTable(list));
		Stage stage = new Stage();
		stage.setTitle("Vergleiche Sägen");
		stage.setResizable(false);
		Scene scene = new Scene(loader);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param loader
	 *            the loader to set
	 */
	public void setLoader(Parent loader) {
		this.loader = loader;
	}

}
