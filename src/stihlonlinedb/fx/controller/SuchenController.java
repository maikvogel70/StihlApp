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
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.SearchClass;
import stihlonlinedb.fx.ICommonProps;
import stihlonlinedb.fx.util.FxUtils;
import stihlonlinedb.view.StihlTableView;

/**
 * 
 * Controller für die Suchenfunktion
 *
 */
public class SuchenController implements Initializable, ICommonProps {

	@FXML
	private Label suchelabel;
	@FXML
	private ImageView sucheBild;
	@FXML
	private ComboBox<String> productList;
	@FXML
	private TextField searchFor;
	@FXML
	private Button searchBtn;
	@FXML
	private TableView<StihlTableView> resultTable;
	@FXML
	private FlowPane resultPane;
	@FXML
	private BorderPane sucheBorderPane;

	private String selectedProdukt;
	private MainController mainController;
	ObservableList<StihlTableView> tableData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		suchelabel.getStyleClass().add(STIHL_LABEL_STYLE_CLASS);
		sucheBild
				.setImage(new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + "suche.jpg"), 780, 0, true, true));
		searchBtn.disableProperty().bind(productList.valueProperty().isNull());
		searchBtn.getStyleClass().add(SEARCH_BTN_STYLE_CLASS);
		searchFor.getStyleClass().add(SEARCH_BTN_STYLE_CLASS);
		productList.getStyleClass().add(SEARCH_BTN_STYLE_CLASS);
		fillcombobox();
		searchBtn.setOnAction((event) -> {
			search();
		});
	}

	private void search() {
		Queries qs = new Queries();
		List<StihlTableView> swl = new ArrayList<>();
		List<SearchClass> searchResults = qs.getSearchResults(selectedProdukt, searchFor.getText());

		for (SearchClass searchClass : searchResults) {
			String name = "/pics/" + searchClass.getBildablage().getPfad();
			if (getClass().getResourceAsStream(name) == null) {
				name = "/pics/ms170.jpg";
			}
			Button btn = new Button("", new ImageView(
					new Image(getClass().getResourceAsStream(name), IMAGE_WIDTH_SHOW_BTN, 0, true, true)));
			btn.getStyleClass().add(SEARCH_BTN_STYLE_CLASS);
			btn.setTooltip(new Tooltip(TOOLTIP_DETAIL_BTN));

			btn.setOnAction((event) -> {
				// zur kommunikation mit dem dialog
				FXMLLoader load = new FXMLLoader(getClass().getResource("../DetailDialog.fxml"));
				try {
					Parent root = load.load();
					load.<DetailDialogController>getController().setLoader(root);
					load.<DetailDialogController>getController().startSucheDetail(searchClass);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			swl.add(new StihlTableView(btn, new SimpleIntegerProperty(searchClass.getId()),
					new SimpleStringProperty(searchClass.getName()),
					new SimpleStringProperty(searchClass.getBeschreibung())));
		}

		tableData = FXCollections.observableList(swl);
		createTableStructure();
		resultPane.getChildren().clear();
		resultPane.getChildren().addAll(resultTable);

	}

	@SuppressWarnings("unchecked")
	private void createTableStructure() {
		TableColumn<StihlTableView, String> colDetails = new TableColumn<StihlTableView, String>("Details");
		colDetails.setStyle(FX_ALIGNMENT_CENTER);
		colDetails.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("btn"));

		TableColumn<StihlTableView, String> modellnameCol = new TableColumn<StihlTableView, String>("Name");
		modellnameCol.setMinWidth(240);
		modellnameCol.setCellFactory(FxUtils.WRAPPING_CELL_FACTORY);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("name"));

		TableColumn<StihlTableView, String> beschreibungCol = new TableColumn<StihlTableView, String>("Beschreibung");
		beschreibungCol.setMaxWidth(430);
		beschreibungCol.setCellFactory(FxUtils.WRAPPING_CELL_FACTORY);
		beschreibungCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("beschreibung"));

		resultTable = new TableView<StihlTableView>();
		resultTable.setMaxHeight(310);
		resultTable.setMinWidth(780);
		resultTable.setItems(tableData);
		resultTable.scrollTo(0);
		resultTable.getColumns().addAll(colDetails, modellnameCol, beschreibungCol);
	}

	private void fillcombobox() {
		ListDbObjects dbObjects = new ListDbObjects();
		List<Produkte> allProdukte = dbObjects.getAllProdukte();
		for (Produkte produkte : allProdukte) {
			productList.getItems().add(produkte.getName());
		}
		productList.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(@SuppressWarnings("rawtypes") ObservableValue ov, String oldVal, String newVal) {
				selectedProdukt = newVal;
			}
		});
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
