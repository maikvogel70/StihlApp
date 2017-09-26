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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
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
import stihlonlinedb.view.SaegeView;

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
	private static final int MIN_TABLE_WIDTH = 715;
	private static final int MAX_TABLE_HEIGH = 260;
	private static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
	private static final String TOOLTIP_DETAIL_BTN = "Zeige weitere Details zu dem Gerät an";
	private static final String SHOW_DETAIL_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";
	private ObservableList<SaegeView> tableData;
	private TableView<SaegeView> table;
	private int cbxVergleichCounter = 0;
	private List<Saege> selectedSaegen;
	private MainController mainController;

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
		togglePanes();
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

	private void initSaegenTable(int id) {
		Queries qs = new Queries();
		List<Saege> saegen = qs.getSaegeByEinsatzzweck(id);
		List<SaegeView> swl = new ArrayList<>();
		Image image = new Image(getClass().getResourceAsStream("/pics/tableShowDetail.gif"), 100, 20, true, true);
		selectedSaegen = new ArrayList<>();
		this.vergleicheAuswahlLink.setDisable(true);
		Button showBtn;
		CheckBox cbxVergleich;

		for (Saege saege : saegen) {
			showBtn = new Button("", new ImageView(image));
			showBtn.setTooltip(new Tooltip(TOOLTIP_DETAIL_BTN));
			showBtn.setStyle(showBtn.getStyle() + SHOW_DETAIL_BTN_STYLE);

			showBtn.setOnAction((event) -> {
				FXMLLoader load = null;
				// zur kommunikation mit dem dialog
				load = new FXMLLoader(getClass().getResource("../DetailDialog.fxml"));
				Parent root;
				try {
					root = load.load();
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

			swl.add(new SaegeView(cbxVergleich, new SimpleIntegerProperty(saege.getId()), showBtn,
					new SimpleStringProperty(saege.getName()), new SimpleDoubleProperty(saege.getHubraum()),
					new SimpleDoubleProperty(saege.getPs()), new SimpleDoubleProperty(saege.getGewicht()),
					new SimpleDoubleProperty(saege.getPreis())));
		}
		tableData = FXCollections.observableList(swl);
		createTableStructure();
	}

	protected void checkCheckBox(boolean isSelected, Saege saege) {
		if (isSelected) {
			cbxVergleichCounter++;
			this.selectedSaegen.add(saege);
		} else {
			cbxVergleichCounter--;
			this.selectedSaegen.remove(saege);
		}
	}

	private void createTableStructure() {
		TableColumn<SaegeView, String> colVergleich = new TableColumn<SaegeView, String>("Vergleich");
		colVergleich.setMinWidth(40);
		colVergleich.setStyle(FX_ALIGNMENT_CENTER);
		colVergleich.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("cbxVergleich"));

		TableColumn<SaegeView, String> showCol = new TableColumn<SaegeView, String>("Details");
		showCol.setMinWidth(40);
		showCol.setStyle(FX_ALIGNMENT_CENTER);
		showCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("btn"));

		TableColumn<SaegeView, String> modellnameCol = new TableColumn<SaegeView, String>("Modellname");
		modellnameCol.setMinWidth(155);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("name"));

		TableColumn<SaegeView, Double> hubraumCol = new TableColumn<SaegeView, Double>("Hubraum cm³");
		hubraumCol.setMinWidth(100);
		hubraumCol.setStyle(FX_ALIGNMENT_CENTER);
		hubraumCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("hubraum"));

		TableColumn<SaegeView, Double> leistungCol = new TableColumn<SaegeView, Double>("Leistung PS");
		leistungCol.setMinWidth(100);
		leistungCol.setStyle(FX_ALIGNMENT_CENTER);
		leistungCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("ps"));

		TableColumn<SaegeView, Double> gewichtCol = new TableColumn<SaegeView, Double>("Gewicht kg");
		gewichtCol.setMinWidth(80);
		gewichtCol.setStyle(FX_ALIGNMENT_CENTER);
		gewichtCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("gewicht"));

		TableColumn<SaegeView, Double> preisCol = new TableColumn<SaegeView, Double>("Preis €");
		preisCol.setMinWidth(80);
		preisCol.setStyle(FX_ALIGNMENT_CENTER);
		preisCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("preis"));

		table = new TableView<SaegeView>();
		table.setMaxHeight(MAX_TABLE_HEIGH);
		table.setMinWidth(MIN_TABLE_WIDTH);
		table.setItems(tableData);
		table.scrollTo(0);
		table.getColumns().addAll(colVergleich, showCol, modellnameCol, hubraumCol, leistungCol, gewichtCol, preisCol);
	}

	/**
	 * @return the table
	 */
	public TableView<SaegeView> getTable(int id) {
		initSaegenTable(id);
		return table;
	}

	/**
	 * @return the selectedSaegen
	 */
	public List<Saege> getSelectedSaegen() {
		return selectedSaegen;
	}

	public int getCbxVergleichCounter() {
		return cbxVergleichCounter;
	}

	public void setCbxVergleichCounter(int cbxVergleichCounter) {
		this.cbxVergleichCounter = cbxVergleichCounter;
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

	public void init(MainController mainController) {
		this.mainController = mainController;

	}

}
