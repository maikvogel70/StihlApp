package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;
import stihlonlinedb.dao.KategorieContentTable;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Saege;

public class KategorienController implements Initializable {

	@FXML
	private FlowPane kategoriePane, kategoriePaneContent, kategorieMainPane;
	@FXML
	private Label kategorienLabel;
	@FXML
	private AnchorPane anchorPaneKategorien;
	@FXML
	private TitledPane collapsiblePane, collapsiblePaneContent;
	@FXML
	private ScrollPane kategorieScrollPane;
	@FXML
	private TableView<Saege> kategorieContent;
	@FXML
	private Dialog<Saege> detailDialog;
	@FXML
	private Label saegenDetailsLabel, saegenTitleLabel;
	@FXML
	private ImageView saegenImage;
	@FXML
	private Button closeBtn;
	private KategorieContentTable tableContent;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addLabel();
		addKategorienFlowPaneContent();
	}

	private void addLabel() {
		kategorienLabel.getStyleClass().add("labelProductView");
		kategorienLabel.setPadding(new Insets(10, 0, 0, 10));
	}

	private void addKategorienFlowPaneContent() {
		kategoriePane.setPadding(new Insets(5, 0, 0, 10));
		kategoriePane.setVgap(4);
		kategoriePane.setHgap(4);
	}

	public void addKategorienToFlowPane(String produktId) {

		ListDbObjects dbObjects = new ListDbObjects();
		List<Einsatzzweck> allProdukte = dbObjects.getAllEinsatzzwecke();
		KategorienController kc = this;
		for (Einsatzzweck einsatzzweck : allProdukte) {
			Image image = new Image(getClass().getResourceAsStream("/pics/" + einsatzzweck.getBild().getPfad()), 160,
					100, true, true);
			ImageView view = new ImageView(image);
			Button btn = new Button(einsatzzweck.getName(), view);
			btn.setId("" + einsatzzweck.getId());
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setMaxWidth(160);
			btn.setMinHeight(140);
			btn.setWrapText(true);
			btn.getStyleClass().add("btnProductView");

			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					collapsiblePaneContent.setExpanded(true);
					tableContent = new KategorieContentTable();
					kategoriePaneContent.getChildren().clear();
					kategoriePaneContent.getChildren()
							.addAll(tableContent.getTable(Integer.parseInt(((Button) e.getSource()).getId())));
				}
			});
			kategoriePane.getChildren().add(btn);
		}
	}

	// public void start(int id) {
	// try {
	// loader = FXMLLoader.load(getClass().getResource("../DetailDialog.fxml"));
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// Queries qs = new Queries();
	// Saege saege = qs.getSaegeById(id);
	// if (saege == null) {
	// return;
	// }
	// Image image = new Image(getClass().getResourceAsStream("/pics/" +
	// saege.getBildablage().getPfad()), 300, 200,
	// true, true);
	// saegenImage = new ImageView(image);
	// saegenTitleLabel.setText(saege.getName());
	// StringBuffer sb = new StringBuffer();
	// sb.append("Beschreibung: ");
	// sb.append(saege.getBeschreibung() + "\n");
	// sb.append("Bestellnummer: ");
	// sb.append(saege.getBestellnummer() + "\n");
	// sb.append("Schienenlänge: ");
	// sb.append(saege.getSchienenlaenge() + "\n");
	// sb.append("Kettenteilung");
	// sb.append(saege.getKettenteilung() + "\n");
	// sb.append("Gewicht: ");
	// sb.append(saege.getGewicht() + "\n");
	// sb.append("Hubraum");
	// sb.append(saege.getHubraum() + "cm³\n");
	// sb.append("Leistung: ");
	// sb.append(saege.getKw() + "kW/");
	// sb.append(saege.getPs() + "PS\n");
	// sb.append("Einsatzzweck: ");
	// sb.append(saege.getEinsatzzweck().getName() + "\n");
	// sb.append("Preis");
	// sb.append("€ " + saege.getPreis());
	// saegenDetailsLabel.setText(sb.toString());
	//
	// Stage stage = new Stage();
	// stage.setScene(new Scene(loader));
	// stage.show();
	//
	// }

	/**
	 * @return the vboxKategorien
	 */
	public AnchorPane getAnchorPaneKategorien() {
		return anchorPaneKategorien;
	}

	/**
	 * @return the tableContent
	 */
	public KategorieContentTable getTableContent() {
		return tableContent;
	}

	/**
	 * @return the kategorienLabel
	 */
	public Label getKategorienLabel() {
		return kategorienLabel;
	}

	/**
	 * @return the kategoriePane
	 */
	public FlowPane getKategoriePane() {
		return kategoriePane;
	}

	public void setDefaultView(boolean b) {
		if (b) {
			Image image = new Image(getClass().getResourceAsStream("/pics/startLogo.jpg"), 600, 600, true, true);
			kategorieMainPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
			kategorieScrollPane.setVisible(false);
		} else {
			kategorieMainPane.setBackground(null);
			kategorieScrollPane.setVisible(true);
		}
	}
}
