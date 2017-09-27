package stihlonlinedb.view;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import stihlonlinedb.fx.ICommonProps;

public class KategorieContentTable implements ICommonProps {

	@SuppressWarnings("unchecked")
	public TableView<StihlTableView> createTableStructure(ObservableList<StihlTableView> tableData) {
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

		TableView<StihlTableView> table = new TableView<StihlTableView>();
		table.setMaxHeight(MAX_TABLE_HEIGH);
		table.setMinWidth(MIN_TABLE_WIDTH);
		table.setItems(tableData);
		table.scrollTo(0);
		table.getColumns().addAll(colVergleich, showCol, modellnameCol, hubraumCol, leistungCol, gewichtCol, preisCol);
		return table;
	}

}
