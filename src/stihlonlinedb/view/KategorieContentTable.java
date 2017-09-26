package stihlonlinedb.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.fx.controller.DetailDialogController;

public class KategorieContentTable {
	private static final int MIN_TABLE_WIDTH = 715;
	private static final int MAX_TABLE_HEIGH = 260;
	private static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
	private static final String TOOLTIP_DETAIL_BTN = "Zeige weitere Details zu dem Gerät an";
	private static final String SHOW_DETAIL_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";
	private ObservableList<StihlTableView> tableData;
	private TableView<StihlTableView> table;
	private int cbxVergleichCounter = 0;
	private Hyperlink vergleicheAuswahlLink;
	private List<Saege> selectedSaegen;

	private void initSaegenTable(int id) {
		Queries qs = new Queries();
		List<Saege> saegen = qs.getSaegeByEinsatzzweck(id);
		List<StihlTableView> swl = new ArrayList<>();
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
				try {
					// zur kommunikation mit dem dialog
					load = new FXMLLoader(getClass().getResource("../fx/DetailDialog.fxml"));
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
		TableColumn<StihlTableView, String> colVergleich = new TableColumn<StihlTableView, String>("Vergleich");
		colVergleich.setMinWidth(40);
		colVergleich.setStyle(FX_ALIGNMENT_CENTER);
		colVergleich.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("cbxVergleich"));

		TableColumn<StihlTableView, String> showCol = new TableColumn<StihlTableView, String>("Details");
		showCol.setMinWidth(40);
		showCol.setStyle(FX_ALIGNMENT_CENTER);
		showCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("btn"));

		TableColumn<StihlTableView, String> modellnameCol = new TableColumn<StihlTableView, String>("Modellname");
		modellnameCol.setMinWidth(155);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("name"));

		TableColumn<StihlTableView, Double> hubraumCol = new TableColumn<StihlTableView, Double>("Hubraum cm³");
		hubraumCol.setMinWidth(100);
		hubraumCol.setStyle(FX_ALIGNMENT_CENTER);
		hubraumCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("hubraum"));

		TableColumn<StihlTableView, Double> leistungCol = new TableColumn<StihlTableView, Double>("Leistung PS");
		leistungCol.setMinWidth(100);
		leistungCol.setStyle(FX_ALIGNMENT_CENTER);
		leistungCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("ps"));

		TableColumn<StihlTableView, Double> gewichtCol = new TableColumn<StihlTableView, Double>("Gewicht kg");
		gewichtCol.setMinWidth(80);
		gewichtCol.setStyle(FX_ALIGNMENT_CENTER);
		gewichtCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("gewicht"));

		TableColumn<StihlTableView, Double> preisCol = new TableColumn<StihlTableView, Double>("Preis €");
		preisCol.setMinWidth(80);
		preisCol.setStyle(FX_ALIGNMENT_CENTER);
		preisCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("preis"));

		table = new TableView<StihlTableView>();
		table.setMaxHeight(MAX_TABLE_HEIGH);
		table.setMinWidth(MIN_TABLE_WIDTH);
		table.setItems(tableData);
		table.scrollTo(0);
		table.getColumns().addAll(colVergleich, showCol, modellnameCol, hubraumCol, leistungCol, gewichtCol, preisCol);
	}

	/**
	 * @return the table
	 */
	public TableView<StihlTableView> getTable(int id) {
		initSaegenTable(id);
		return table;
	}

	/**
	 * @return the selectedSaegen
	 */
	public List<Saege> getSelectedSaegen() {
		return selectedSaegen;
	}

	/**
	 * @param vergleicheAuswahlLink
	 *            the vergleicheAuswahlLink to set
	 */
	public void setVergleicheAuswahlLink(Hyperlink vergleicheAuswahlLink) {
		this.vergleicheAuswahlLink = vergleicheAuswahlLink;
	}

	public int getCbxVergleichCounter() {
		return cbxVergleichCounter;
	}

	public void setCbxVergleichCounter(int cbxVergleichCounter) {
		this.cbxVergleichCounter = cbxVergleichCounter;
	}

}
