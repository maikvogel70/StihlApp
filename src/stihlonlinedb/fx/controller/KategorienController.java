package stihlonlinedb.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.view.KategorieContentTable;

public class KategorienController extends Pane implements Initializable {

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
	private DialogPane vergleichDetailDialog;
	@FXML
	private Label saegenDetailsLabel, saegenTitleLabel;
	@FXML
	private ImageView saegenImage;
	@FXML
	private Button closeBtn;
	@FXML
	private VBox kategorieVbox;
	@FXML
	private Hyperlink vergleicheAuswahlLink;

	private KategorieContentTable tableContent;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addLabel();
		addKategorienFlowPaneContent();
		setDefaultView(true);
		kategorieVbox.setBorder(null);
		kategorieScrollPane.setStyle("-fx-background-color:transparent;");
		kategoriePaneContent.setPadding(new Insets(10, 0, 0, 10));
		kategoriePaneContent.setVgap(10);
		vergleicheAuswahlLink.setDisable(true);
		vergleicheAuswahlLink.setStyle("-fx-text-fill: #f37a1f; -fx-font-weight: bold;");
		vergleicheAuswahlLink.setText("Vergleichen (Min: 2 - Max: 5)");
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

			btn.setOnAction((event) -> {
				if (event.getSource() instanceof ToggleButton) {
					ObservableList<Node> children = kategoriePane.getChildren();
					for (Node tb : children) {
						((ToggleButton) tb).setSelected(false);
					}
				}
				vergleicheAuswahlLink.setVisible(true);
				btn.setSelected(true);
				tableContent = new KategorieContentTable();
				tableContent.setVergleicheAuswahlLink(vergleicheAuswahlLink);
				kategoriePaneContent.getChildren().clear();
				kategoriePaneContent.getChildren()
						.addAll(tableContent.getTable(Integer.parseInt(((ToggleButton) event.getSource()).getId())));
			});

			vergleicheAuswahlLink.setOnAction((event) -> {
				FXMLLoader load = new FXMLLoader(getClass().getResource("../VergleichDialog.fxml"));
				Parent root;
				try {
					root = load.load();
					load.<VergleichDialogController>getController().setLoader(root);
					load.<VergleichDialogController>getController().start(tableContent.getSelectedSaegen());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			kategoriePane.getChildren().add(btn);
		}
	}

	/**
	 * Zeigt bei einem leeren Hintergrund das Bild an, ansonsten wird es
	 * ausgeblendet.
	 */
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
	 * @return the vergleicheAuswahlLink
	 */
	public Hyperlink getVergleicheAuswahlLink() {
		return vergleicheAuswahlLink;
	}

	/**
	 * @param vergleicheAuswahlLink
	 *            the vergleicheAuswahlLink to set
	 */
	public void setVergleicheAuswahlLink(Hyperlink vergleicheAuswahlLink) {
		this.vergleicheAuswahlLink = vergleicheAuswahlLink;
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

	/**
	 * @return the kategorieScrollPane
	 */
	public ScrollPane getKategorieScrollPane() {
		return kategorieScrollPane;
	}

}
