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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.fx.ICommonProps;
import stihlonlinedb.view.VergleichContentTable;

/**
 * 
 * Controller für den Dialog, der die zu vergleichenden Sägen anzeigt
 *
 */
public class VergleichDialogController implements Initializable, ICommonProps {

	@FXML
	private Button closeBtn;
	@FXML
	private FlowPane saegenVergleichContent;
	@FXML
	private AnchorPane vergleichPane;

	private Parent loader;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				((Stage) closeBtn.getScene().getWindow()).close();
			}
		});
		closeBtn.getStyleClass().add(SHOW_DETAIL_BTN_STYLE_CLASS);
	}

	/**
	 * Erzeugt die Liste für die Anzeige der Vergleichssägen und startet die Stage
	 * 
	 * @param list
	 */
	public void start(List<Saege> list) {
		VergleichContentTable tableVergleichContent = new VergleichContentTable();
		saegenVergleichContent.getChildren().add(tableVergleichContent.getVergleichTable(list));
		Stage stage = createAndStyleStage();
		stage.show();
	}

	// Erzeuge eine Stage und lade die CSS-Datei in die Stage
	private Stage createAndStyleStage() {
		// TODO: untersuchen, warum in diesem Controller das CSS nicht default geladen
		// wird
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setScene(new Scene(loader));
		stage.getScene().getStylesheets()
				.add(getClass().getResource("/stihlonlinedb/fx/application.css").toExternalForm());
		closeBtn.getStyleClass().add(SEARCH_BTN_STYLE_CLASS);
		saegenVergleichContent.getStyleClass().add("whiteBackground");
		return stage;
	}

	/**
	 * @param loader
	 *            the loader to set
	 */
	public void setLoader(Parent loader) {
		this.loader = loader;
	}

}
