package stihlonlinedb.fx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
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
	@FXML
	private VBox kategorieVbox;

	private KategorieContentTable tableContent;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addLabel();
		addKategorienFlowPaneContent();
		setDefaultView(true);
		kategorieVbox.setBorder(null);
		kategorieScrollPane.setStyle("-fx-background-color:transparent;");
		kategoriePaneContent.setMinWidth(795);
		kategoriePaneContent.setPadding(new Insets(10, 0, 0, 10));
	}

	private void addLabel() {
		kategorienLabel.getStyleClass().add("labelTitleView");
	}

	private void addKategorienFlowPaneContent() {
		kategoriePane.setPadding(new Insets(10, 0, 0, 10));
		kategoriePane.setVgap(4);
		kategoriePane.setHgap(4);
	}

	public void addKategorienToFlowPane(String produktId) {

		ListDbObjects dbObjects = new ListDbObjects();
		List<Einsatzzweck> allProdukte = dbObjects.getAllEinsatzzwecke();
		for (Einsatzzweck einsatzzweck : allProdukte) {
			Image image = new Image(getClass().getResourceAsStream("/pics/" + einsatzzweck.getBild().getPfad()), 160,
					100, true, true);
			ImageView view = new ImageView(image);
			ToggleButton btn = new ToggleButton(einsatzzweck.getName(), view);
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
					if (e.getSource() instanceof ToggleButton) {
						ObservableList<Node> children = kategoriePane.getChildren();
						for (Node tb : children) {
							((ToggleButton) tb).setSelected(false);
						}
					}
					btn.setSelected(true);
					tableContent = new KategorieContentTable();
					kategoriePaneContent.getChildren().clear();
					kategoriePaneContent.getChildren()
							.addAll(tableContent.getTable(Integer.parseInt(((ToggleButton) e.getSource()).getId())));
				}
			});
			kategoriePane.getChildren().add(btn);
		}
	}

	public void setDefaultView(boolean b) {
		if (b) {
			Image image = new Image(getClass().getResourceAsStream("/pics/startLogo.jpg"), 0, 800, true, true);
			kategorieMainPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
			kategorieScrollPane.setVisible(false);
		} else {
			kategorieMainPane.setBackground(null);
			kategorieScrollPane.setVisible(true);
		}
	}

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

}
