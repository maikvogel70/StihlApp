package stihlonlinedb.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.SearchClass;
import stihlonlinedb.view.SaegeView;

public class SuchenController implements Initializable {
	private static final String SEARCH_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";
	private static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
	private static final String TOOLTIP_DETAIL_BTN = "Zeige weitere Details zu dem Artikel an";
	@FXML
	private Label testlabel;
	@FXML
	private ImageView sucheBild;
	@FXML
	private ComboBox<String> productList;
	@FXML
	private TextField searchFor;
	@FXML
	private Button searchBtn;
	@FXML
	private TableView<SaegeView> resultTable;
	@FXML
	private FlowPane resultPane;
	@FXML
	private BorderPane sucheBorderPane;

	private String selectedProdukt;
	private MainController mainController;
	ObservableList<SaegeView> tableData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		testlabel.getStyleClass().add("labelTitleView");
		sucheBild.setImage(new Image(getClass().getResourceAsStream("/pics/suche.jpg"), 490, 0, true, true));
		searchBtn.setStyle(SEARCH_BTN_STYLE);
		searchBtn.disableProperty().bind(productList.valueProperty().isNull());

		searchFor.setStyle(SEARCH_BTN_STYLE);
		productList.setStyle(SEARCH_BTN_STYLE);
		fillcombobox();
		searchBtn.setOnAction((event) -> {
			search();
		});
	}

	private void search() {
		Queries qs = new Queries();
		List<SaegeView> swl = new ArrayList<>();
		List<SearchClass> searchResults = qs.getSearchResults(selectedProdukt, searchFor.getText());

		for (SearchClass searchClass : searchResults) {
			String name = "/pics/" + searchClass.getBildablage().getPfad();
			if (getClass().getResourceAsStream(name) == null) {
				name = "/pics/ms170.jpg";
			}
			Button btn = new Button("",
					new ImageView(new Image(getClass().getResourceAsStream(name), 160, 100, true, true)));
			btn.setContentDisplay(ContentDisplay.TOP);
			btn.setTextAlignment(TextAlignment.CENTER);
			btn.setStyle(SEARCH_BTN_STYLE);
			btn.setTooltip(new Tooltip(TOOLTIP_DETAIL_BTN));

			btn.setOnAction((event) -> {
				FXMLLoader load = null;
				// zur kommunikation mit dem dialog
				load = new FXMLLoader(getClass().getResource("../DetailDialog.fxml"));
				try {
					Parent root = load.load();
					load.<DetailDialogController>getController().setLoader(root);
					load.<DetailDialogController>getController().startSucheDetail(searchClass);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			swl.add(new SaegeView(btn, new SimpleIntegerProperty(searchClass.getId()),
					new SimpleStringProperty(searchClass.getName()),
					new SimpleStringProperty(searchClass.getBeschreibung())));
		}

		tableData = FXCollections.observableList(swl);
		createTableStructure();
		resultPane.getChildren().clear();
		resultPane.getChildren().addAll(resultTable);

	}

	private void createTableStructure() {
		TableColumn<SaegeView, String> colVergleich = new TableColumn<SaegeView, String>("Details");
		colVergleich.setMinWidth(40);
		colVergleich.setStyle(FX_ALIGNMENT_CENTER);
		colVergleich.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("btn"));

		TableColumn<SaegeView, String> modellnameCol = new TableColumn<SaegeView, String>("Name");
		modellnameCol.setMinWidth(240);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("name"));

		TableColumn<SaegeView, String> beschreibungCol = new TableColumn<SaegeView, String>("Beschreibung");
		beschreibungCol.setMaxWidth(290);
		beschreibungCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("beschreibung"));

		resultTable = new TableView<SaegeView>();
		resultTable.setMaxHeight(310);
		resultTable.setMinWidth(780);
		resultTable.setItems(tableData);
		resultTable.scrollTo(0);
		resultTable.getColumns().addAll(colVergleich, modellnameCol, beschreibungCol);
	}

	private void fillcombobox() {
		ListDbObjects dbObjects = new ListDbObjects();
		List<Produkte> allProdukte = dbObjects.getAllProdukte();
		for (Produkte produkte : allProdukte) {
			productList.getItems().add(produkte.getName());
		}
		productList.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String oldVal, String newVal) {
				selectedProdukt = newVal;
			}
		});
	}

	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	/**
	 * @return the testlabel
	 */
	public Label getTestlabel() {
		return testlabel;
	}

	/**
	 * @return the mainController
	 */
	public MainController getMainController() {
		return mainController;
	}

	/**
	 * @return the sucheBorderPane
	 */
	public BorderPane getSucheBorderPane() {
		return sucheBorderPane;
	}

}
