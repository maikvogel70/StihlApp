package stihlonlinedb.fx.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import stihlonlinedb.dao.SaegeView;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;

public class VergleichContentTable {
	private static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
	private ObservableList<SaegeView> tableDataVergleich;
	private TableView<SaegeView> tableVergleich;

	private void initSaegenVergleichTable(List<Saege> selectedSaegenList) {
		Queries qs = new Queries();
		List<SaegeView> swl = new ArrayList<>();
		Saege saege;
		for (Saege selectedSaege : selectedSaegenList) {
			saege = qs.getSaegeById(selectedSaege.getId());
			swl.add(new SaegeView(new SimpleIntegerProperty(saege.getId()), new SimpleStringProperty(saege.getName()),
					new SimpleDoubleProperty(saege.getHubraum()), new SimpleDoubleProperty(saege.getPs()),
					new SimpleDoubleProperty(saege.getGewicht()), new SimpleDoubleProperty(saege.getKw()),
					new SimpleStringProperty(saege.getKettenteilung()),
					new SimpleIntegerProperty(saege.getSchienenlaenge()), new SimpleDoubleProperty(saege.getPreis())));
		}

		tableDataVergleich = FXCollections.observableList(swl);
		tableVergleich = new TableView<SaegeView>();
		createTableStructure();
		tableVergleich.setMaxHeight(220);
		tableVergleich.setMinWidth(600);
		tableVergleich.setItems(tableDataVergleich);
		tableVergleich.scrollTo(0);
	}

	private void createTableStructure() {

		TableColumn<SaegeView, String> modellnameCol = new TableColumn<SaegeView, String>("Modellname");
		modellnameCol.setMinWidth(200);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("name"));

		TableColumn<SaegeView, Double> hubraumCol = new TableColumn<SaegeView, Double>("Hubraum cm³");
		hubraumCol.setMinWidth(100);
		hubraumCol.setStyle(FX_ALIGNMENT_CENTER);
		hubraumCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("hubraum"));

		TableColumn<SaegeView, Double> leistungCol = new TableColumn<SaegeView, Double>("Leistung PS");
		leistungCol.setMinWidth(100);
		leistungCol.setStyle(FX_ALIGNMENT_CENTER);
		leistungCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("ps"));

		TableColumn<SaegeView, Double> kwCol = new TableColumn<SaegeView, Double>("kW");
		kwCol.setMinWidth(100);
		kwCol.setStyle(FX_ALIGNMENT_CENTER);
		kwCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("kw"));

		TableColumn<SaegeView, String> kettenteilungCol = new TableColumn<SaegeView, String>("Kettenteilung");
		kettenteilungCol.setMinWidth(100);
		kettenteilungCol.setStyle(FX_ALIGNMENT_CENTER);
		kettenteilungCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("kettenteilung"));

		TableColumn<SaegeView, Integer> schienenlaengeCol = new TableColumn<SaegeView, Integer>("Schienenlaenge");
		schienenlaengeCol.setMinWidth(100);
		schienenlaengeCol.setStyle(FX_ALIGNMENT_CENTER);
		schienenlaengeCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Integer>("schienenlaenge"));

		TableColumn<SaegeView, Double> gewichtCol = new TableColumn<SaegeView, Double>("Gewicht kg");
		gewichtCol.setMinWidth(100);
		gewichtCol.setStyle(FX_ALIGNMENT_CENTER);
		gewichtCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("gewicht"));

		TableColumn<SaegeView, Double> preisCol = new TableColumn<SaegeView, Double>("Preis €");
		preisCol.setMinWidth(100);
		preisCol.setStyle(FX_ALIGNMENT_CENTER);
		preisCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("preis"));

		tableVergleich.getColumns().addAll(modellnameCol, hubraumCol, leistungCol, kwCol, kettenteilungCol,
				schienenlaengeCol, gewichtCol, preisCol);
	}

	/**
	 * @return the table
	 */
	public TableView<SaegeView> getVergleichTable(List<Saege> selectedSaegenList) {
		initSaegenVergleichTable(selectedSaegenList);
		return tableVergleich;
	}
}
