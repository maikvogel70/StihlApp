package stihlonlinedb.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
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
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.fx.ICommonProps;
import stihlonlinedb.view.KategorieContentTable;
import stihlonlinedb.view.StihlTableView;

/**
 * 
 * Controller für die Kategorien.
 *
 */
public class KategorienController extends Pane implements Initializable, ICommonProps {

	@FXML
	private FlowPane kategoriePane, kategoriePaneContent, kategorieMainPane;
	@FXML
	private Label kategorienLabel;
	@FXML
	private AnchorPane anchorPaneKategorien;
	@FXML
	private ScrollPane kategorieScrollPane;
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
	private ObservableList<StihlTableView> tableData;
	private TableView<StihlTableView> table;
	private int cbxVergleichCounter = 0;
	private List<Saege> selectedSaegen;
	private MainController mainController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addLabel();
		addKategorienFlowPaneContent();
		setDefaultView(true);
		kategorieVbox.setBorder(null);
		kategorieScrollPane.getStyleClass().add(TRANSPARENT_STYLE_CLASS);
		kategoriePaneContent.setPadding(new Insets(10, 0, 0, 10));
		kategoriePaneContent.setVgap(10);
		vergleicheAuswahlLink.setDisable(true);
		vergleicheAuswahlLink.getStyleClass().add(HYPERLINK_STYLE_CLASS);
		vergleicheAuswahlLink.setText("Vergleichen (Min: 2 - Max: 5)");
	}

	private void addLabel() {
		kategorienLabel.getStyleClass().add(STIHL_LABEL_STYLE_CLASS);
	}

	private void addKategorienFlowPaneContent() {
		kategoriePane.setPadding(new Insets(10, 0, 0, 10));
		kategoriePane.setVgap(4);
		kategoriePane.setHgap(4);
	}

	/**
	 * Erstellt die Image-Buttons für die Kategorien anhand der Produkt-ID
	 * 
	 * @param produktId
	 */
	public void addKategorienToFlowPane(String produktId) {
		togglePanes();
		ListDbObjects dbObjects = new ListDbObjects();
		List<Einsatzzweck> allProdukte = dbObjects.getAllEinsatzzwecke();
		for (Einsatzzweck einsatzzweck : allProdukte) {
			ImageView view = new ImageView(
					new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + einsatzzweck.getBild().getPfad()),
							IMAGE_WIDTH_NAV, 0, true, true));
			ToggleButton btn = new ToggleButton(einsatzzweck.getName(), view);
			btn.setId("" + einsatzzweck.getId());
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setMaxWidth(160);
			btn.setMinHeight(140);
			btn.setWrapText(true);
			btn.getStyleClass().add(STIHL_BTN_STYLE_CLASS);

			btn.setOnAction((event) -> {
				if (event.getSource() instanceof ToggleButton) {
					ObservableList<Node> children = kategoriePane.getChildren();
					for (Node tb : children) {
						((ToggleButton) tb).setSelected(false);
					}
				}
				vergleicheAuswahlLink.setVisible(true);
				btn.setSelected(true);
				setVergleicheAuswahlLink(vergleicheAuswahlLink);
				kategoriePaneContent.getChildren().clear();
				kategoriePaneContent.getChildren()
						.addAll(getTable(Integer.parseInt(((ToggleButton) event.getSource()).getId())));
			});

			vergleicheAuswahlLink.setOnAction((event) -> {
				FXMLLoader load = new FXMLLoader(getClass().getResource("../VergleichDialog.fxml"));
				Parent root;
				try {
					root = load.load();
					load.<VergleichDialogController>getController().setLoader(root);
					load.<VergleichDialogController>getController().start(getSelectedSaegen());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			kategoriePane.getChildren().add(btn);
		}
	}

	// Erstellt die Sägentabelle anhand der Einsatzzweck-ID
	private void initSaegenTable(int id) {
		Queries qs = new Queries();
		List<Saege> saegen = qs.getSaegeByEinsatzzweck(id);
		List<StihlTableView> swl = new ArrayList<>();

		Image image = new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + "tableShowDetail.gif"),
				IMAGE_WIDTH_SHOW_BTN, 0, true, true);
		selectedSaegen = new ArrayList<>();
		this.vergleicheAuswahlLink.setDisable(true);

		Button showBtn;
		CheckBox cbxVergleich;

		for (Saege saege : saegen) {
			showBtn = new Button("", new ImageView(image));
			showBtn.setTooltip(new Tooltip(TOOLTIP_DETAIL_BTN));
			showBtn.getStyleClass().add(SHOW_DETAIL_BTN_STYLE_CLASS);

			showBtn.setOnAction((event) -> {
				FXMLLoader load = null;
				// zur kommunikation mit dem dialog
				load = new FXMLLoader(getClass().getResource("../DetailDialog.fxml"));
				try {
					Parent root = load.load();
					load.<DetailDialogController>getController().setLoader(root);
					load.<DetailDialogController>getController().start(saege.getId());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			cbxVergleich = new CheckBox();
			cbxVergleich.setOnAction((event) -> {
				if (event.getSource() instanceof CheckBox) {
					checkCheckBox(((CheckBox) event.getSource()).isSelected(), saege);
					// wenn die Auswahl der Checkboxen min 2 und max 5 ist, dann disable=false
					this.vergleicheAuswahlLink.setDisable(!(cbxVergleichCounter >= 2 && cbxVergleichCounter <= 5));
				}
			});

			swl.add(new StihlTableView(cbxVergleich, new SimpleIntegerProperty(saege.getId()), showBtn,
					new SimpleStringProperty(saege.getName()), new SimpleDoubleProperty(saege.getHubraum()),
					new SimpleDoubleProperty(saege.getPs()), new SimpleDoubleProperty(saege.getGewicht()),
					new SimpleDoubleProperty(saege.getPreis())));
		}
		tableData = FXCollections.observableList(swl);
		KategorieContentTable contentTable = new KategorieContentTable();
		table = contentTable.createTableStructure(tableData);
	}

	// Ermittelt, wieviele Checkboxen aktiviert sind, um den minimalen und maximalen
	// Bereich für die Sichtbarkeit des "Vergleichen-Links" zu steuern.
	protected void checkCheckBox(boolean isSelected, Saege saege) {
		if (isSelected) {
			cbxVergleichCounter++;
			this.selectedSaegen.add(saege);
		} else {
			cbxVergleichCounter--;
			this.selectedSaegen.remove(saege);
		}
	}

	/**
	 * @return the table
	 */
	public TableView<StihlTableView> getTable(int id) {
		initSaegenTable(id);
		return table;
	}

	private void togglePanes() {
		ObservableList<Node> childrenC = mainController.getCenterStackPane().getChildren();
		for (Node node : childrenC) {
			if (node instanceof AnchorPane) {
				AnchorPane ap = (AnchorPane) node;
				if ("anchorPaneKategorien".equals(ap.getId())) {
					ap.setVisible(true);
				} else if ("suchePane".equals(ap.getId())) {
					ap.setVisible(false);
				}
			}
		}
	}

	/**
	 * Zeigt bei einem leeren Hintergrund das Bild an, ansonsten wird es
	 * ausgeblendet.
	 */
	public void setDefaultView(boolean b) {
		if (b) {
			Image image = new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + "startLogo.jpg"), 0,
					IMAGE_HEIGHT_START_LOGO, true, true);
			kategorieMainPane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
			kategorieScrollPane.setVisible(false);
		} else {
			kategorieMainPane.setBackground(null);
			kategorieScrollPane.setVisible(true);
		}
	}

	/**
	 * @param vergleicheAuswahlLink
	 *            the vergleicheAuswahlLink to set
	 */
	public void setVergleicheAuswahlLink(Hyperlink vergleicheAuswahlLink) {
		this.vergleicheAuswahlLink = vergleicheAuswahlLink;
	}

	/**
	 * @return the selectedSaegen
	 */
	public List<Saege> getSelectedSaegen() {
		return selectedSaegen;
	}

	/**
	 * 
	 * @return cbxVergleichCounter
	 */
	public int getCbxVergleichCounter() {
		return cbxVergleichCounter;
	}

	public void setCbxVergleichCounter(int cbxVergleichCounter) {
		this.cbxVergleichCounter = cbxVergleichCounter;
	}

	/**
	 * @return the vboxKategorien
	 */
	public AnchorPane getAnchorPaneKategorien() {
		return anchorPaneKategorien;
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
	 * Verlinkung des MainControllers zur Steuerung
	 * 
	 * @param mainController
	 */
	public void init(MainController mainController) {
		this.mainController = mainController;

	}

}
