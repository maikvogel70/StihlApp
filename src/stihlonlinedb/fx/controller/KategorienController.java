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

	private MainController mainController;
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
		int idCounter = 0;

		for (Einsatzzweck einsatzzweck : allProdukte) {
			Image image = new Image(getClass().getResourceAsStream("/pics/" + einsatzzweck.getBild().getPfad()), 160,
					100, true, true);
			ImageView view = new ImageView(image);
			Button btn = new Button(einsatzzweck.getName(), view);
			btn.setId("kategorieBtn_" + idCounter);
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setMaxWidth(160);
			btn.setMinHeight(140);
			btn.setWrapText(true);
			btn.getStyleClass().add("btnProductView");

			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					System.out.println(((Button) e.getSource()).getId());
					collapsiblePane.setExpanded(false);
					collapsiblePaneContent.setExpanded(true);
					tableContent = new KategorieContentTable();
					kategoriePaneContent.getChildren().addAll(tableContent.getTable());
				}
			});
			idCounter++;
			kategoriePane.getChildren().add(btn);
		}
	}

	/**
	 * @return the vboxKategorien
	 */
	public AnchorPane getAnchorPaneKategorien() {
		return anchorPaneKategorien;
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
		setDefaultView(true);
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
