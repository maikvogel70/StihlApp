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
import stihlonlinedb.fx.ICommonProps;

public class DetailDialogController implements Initializable, ICommonProps {

	@FXML
	private DialogPane detailDialog;
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
		Stage stage = createAndStyleStage();

		Queries qs = new Queries();
		Saege saege = qs.getSaegeById(id);
		if (saege == null) {
			return;
		}
		Image image = new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + saege.getBildablage().getPfad()),
				IMAGE_WIDTH_DETAILS, 0, true, true);
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

		stage.setTitle(saege.getName());
		stage.show();
	}

	public void startSucheDetail(SearchClass searchClass) {
		Stage stage = createAndStyleStage();
		Image image = new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + searchClass.getBildablage().getPfad()),
				IMAGE_WIDTH_DETAILS, 0, true, true);
		saegenImage.setImage(image);
		saegenTitleLabel.setText(searchClass.getName());
		saegenTitleLabel.setWrapText(true);
		saegenDetailsLabel.setText(searchClass.getBeschreibung());
		saegenDetailsLabel.setWrapText(true);

		stage.setTitle(searchClass.getName());
		stage.show();
	}

	private Stage createAndStyleStage() {
		// TODO: untersuchen, warum in diesem Controller das CSS nicht default geladen
		// wird
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setScene(new Scene(loader));
		stage.getScene().getStylesheets()
				.add(getClass().getResource("/stihlonlinedb/fx/application.css").toExternalForm());
		closeBtn.getStyleClass().add("showDetailBtn");
		detailDialog.getStyleClass().add("whiteBackground");
		saegenDetailsLabel.getStyleClass().add("detailsLabel");
		saegenTitleLabel.getStyleClass().add("labelTitleView");
		return stage;
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
