package stihlonlinedb.fx.controller;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.SearchClass;
import stihlonlinedb.view.SaegeView;

public class SuchenController implements Initializable {
	private static final String SEARCH_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";
	private static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
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

	private String selectedProdukt;
	private MainController mainController;
	ObservableList<SaegeView> tableData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		testlabel.getStyleClass().add("labelTitleView");
		sucheBild.setImage(new Image(getClass().getResourceAsStream("/pics/suche.jpg"), 490, 0, true, true));
		searchBtn.setStyle(SEARCH_BTN_STYLE);
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
			Button showBtn = new Button("zeige");
			swl.add(new SaegeView(showBtn, new SimpleIntegerProperty(searchClass.getId()),
					new SimpleStringProperty(searchClass.getName()),
					new SimpleStringProperty(searchClass.getBeschreibung())));
		}

		tableData = FXCollections.observableList(swl);
		createTableStructure();
		resultPane.getChildren().addAll(resultTable);
	}

	private void createTableStructure() {
		TableColumn<SaegeView, String> colVergleich = new TableColumn<SaegeView, String>("Anzeigen");
		colVergleich.setMinWidth(40);
		colVergleich.setStyle(FX_ALIGNMENT_CENTER);
		colVergleich.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("btn"));

		TableColumn<SaegeView, String> modellnameCol = new TableColumn<SaegeView, String>("Name");
		modellnameCol.setMinWidth(155);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("name"));

		TableColumn<SaegeView, String> beschreibungCol = new TableColumn<SaegeView, String>("Beschreibung");
		beschreibungCol.setMinWidth(300);
		beschreibungCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("beschreibung"));

		resultTable = new TableView<SaegeView>();
		resultTable.setMaxHeight(200);
		resultTable.setMinWidth(400);
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

}
