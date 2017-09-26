package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.SearchClass;

public class DetailDialogController implements Initializable {

	private static final String SHOW_DETAIL_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";

	@FXML
	private DialogPane detailDialog;
	@FXML
	private Label saegenDetailsLabel, saegenTitleLabel;
	@FXML
	private ImageView saegenImage;
	@FXML
	private Button closeBtn;
	private MainController mainController;
	private Parent loader;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				((Stage) closeBtn.getScene().getWindow()).close();
			}
		});
		closeBtn.setStyle(closeBtn.getStyle() + SHOW_DETAIL_BTN_STYLE);

		// musste hier gesetzt werden. in der fxml zogen die änderungen nicht
		detailDialog.setStyle("-fx-background-color: white;");
		saegenDetailsLabel.setStyle(detailDialog.getStyle() + "-fx-font-size: 14.0; -fx-text-fill: #444;");
		saegenTitleLabel.setStyle("-fx-font-size: 20.0; -fx-text-fill: #f37a1f; -fx-font-weight: bold;");
	}

	public void start(int id) {
		Queries qs = new Queries();
		Saege saege = qs.getSaegeById(id);
		if (saege == null) {
			return;
		}
		Image image = new Image(getClass().getResourceAsStream("/pics/" + saege.getBildablage().getPfad()), 500, 400,
				true, true);
		saegenImage.setImage(image);
		saegenTitleLabel.setText(saege.getName());
		StringBuffer sb = new StringBuffer();
		sb.append("Beschreibung: \t");
		sb.append(saege.getBeschreibung() + "\n");
		sb.append("Bestellnummer: \t");
		sb.append(saege.getBestellnummer() + "\n");
		sb.append("Schienenlänge: \t");
		sb.append(saege.getSchienenlaenge() + " cm\n");
		sb.append("Kettenteilung: \t\t");
		sb.append(saege.getKettenteilung() + "\"\n");
		sb.append("Gewicht: \t\t\t");
		sb.append(saege.getGewicht() + " kg\n");
		sb.append("Hubraum: \t\t");
		sb.append(saege.getHubraum() + " cm³\n");
		sb.append("Leistung: \t\t\t");
		sb.append(saege.getKw() + " kW / ");
		sb.append(saege.getPs() + " PS\n");
		sb.append("Einsatzzweck: \n");
		// TODO: ggf. noch einbauen, falls Zeit übrig
		// sb.append(saege.getEinsatzzweck().getName() + "\n");
		sb.append("Preis: \t\t\t");
		sb.append("€ " + saege.getPreis());
		saegenDetailsLabel.setText(sb.toString());

		Stage stage = new Stage();
		stage.setTitle(saege.getName());
		stage.setResizable(false);
		stage.setScene(new Scene(loader));
		stage.show();
	}

	public void startSucheDetail(SearchClass searchClass) {
		Image image = new Image(getClass().getResourceAsStream("/pics/" + searchClass.getBildablage().getPfad()), 300,
				0, true, true);
		saegenImage.setImage(image);
		saegenTitleLabel.setText(searchClass.getName());
		saegenTitleLabel.setWrapText(true);
		saegenDetailsLabel.setText(searchClass.getBeschreibung());
		saegenDetailsLabel.setWrapText(true);

		Stage stage = new Stage();
		stage.setTitle(searchClass.getName());
		stage.setResizable(false);
		stage.setScene(new Scene(loader));
		stage.show();
	}

	/**
	 * @return the loader
	 */
	public Parent getLoader() {
		return loader;
	}

	/**
	 * @param loader
	 *            the loader to set
	 */
	public void setLoader(Parent loader) {
		this.loader = loader;
	}

	public void init(MainController mainController) {
		this.mainController = mainController;

	}

}
