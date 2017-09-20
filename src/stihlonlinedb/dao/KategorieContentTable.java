package stihlonlinedb.dao;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.entities.Saege;

public class KategorieContentTable {
	private ObservableList<Saege> tableData; // = FXCollections.observableList(table.getSaegenTable())
	private TableView<Saege> table;

	private void initSaegenTable() {
		ListDbObjects dbObjects = new ListDbObjects();
		List<Saege> allSaegen = dbObjects.getAllSaegen();
		tableData = FXCollections.observableList(allSaegen);
		createTableStructure();
	}

	private void createTableStructure() {
		TableColumn modellnameCol = new TableColumn("Modellname");
		modellnameCol.setMinWidth(100);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<Saege, String>("modellname"));

		TableColumn hubraumCol = new TableColumn("Hubraum cm³");
		hubraumCol.setMinWidth(100);
		hubraumCol.setCellValueFactory(new PropertyValueFactory<Saege, String>("hubraum"));

		TableColumn leistungCol = new TableColumn("Leistung ­kW/PS");
		leistungCol.setMinWidth(100);
		leistungCol.setCellValueFactory(new PropertyValueFactory<Saege, String>("leistung"));

		TableColumn gewichtCol = new TableColumn("Gewicht kg");
		gewichtCol.setMinWidth(100);
		gewichtCol.setCellValueFactory(new PropertyValueFactory<Saege, String>("gewicht"));

		TableColumn preisCol = new TableColumn("Preis");
		preisCol.setMinWidth(100);
		preisCol.setCellValueFactory(new PropertyValueFactory<Saege, String>("preis"));

		table = new TableView<Saege>();
		table.setItems(tableData);
		table.getColumns().addAll(modellnameCol, hubraumCol, leistungCol, gewichtCol, preisCol);
	}

	/**
	 * @return the table
	 */
	public TableView<Saege> getTable() {
		initSaegenTable();
		return table;
	}

}
