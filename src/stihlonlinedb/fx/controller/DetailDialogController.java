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
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;

public class DetailDialogController implements Initializable {

	@FXML
	private Dialog<Saege> detailDialog;
	@FXML
	private Label saegenDetailsLabel, saegenTitleLabel;
	@FXML
	private ImageView saegenImage;
	@FXML
	private Button closeBtn;

	private Parent loader;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				((Stage) closeBtn.getScene().getWindow()).close();
			}
		});
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
		sb.append("Beschreibung: ");
		sb.append(saege.getBeschreibung() + "\n");
		sb.append("Bestellnummer: ");
		sb.append(saege.getBestellnummer() + "\n");
		sb.append("Schienenlänge: ");
		sb.append(saege.getSchienenlaenge() + "\n");
		sb.append("Kettenteilung");
		sb.append(saege.getKettenteilung() + "\n");
		sb.append("Gewicht: ");
		sb.append(saege.getGewicht() + "\n");
		sb.append("Hubraum");
		sb.append(saege.getHubraum() + "cm³\n");
		sb.append("Leistung: ");
		sb.append(saege.getKw() + "kW/");
		sb.append(saege.getPs() + "PS\n");
		sb.append("Einsatzzweck: ");
		// sb.append(saege.getEinsatzzweck().getName() + "\n");
		sb.append("Preis");
		sb.append("€ " + saege.getPreis());
		saegenDetailsLabel.setText(sb.toString());

		Stage stage = new Stage();
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

}
