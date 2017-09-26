package stihlonlinedb.view;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;

public class VergleichContentTable {
	private static final int MIN_TABLE_WIDTH = 600;
	private static final int MAX_TABLE_HEIGHT = 220;
	private static final String SHOW_DETAIL_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-color: transparent;";
	private static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
	private ObservableList<StihlTableView> tableDataVergleich;
	private TableView<StihlTableView> tableVergleich;

	private void initSaegenVergleichTable(List<Saege> selectedSaegenList) {
		Queries qs = new Queries();
		List<StihlTableView> swl = new ArrayList<>();
		Saege saege;
		for (Saege selectedSaege : selectedSaegenList) {
			saege = qs.getSaegeById(selectedSaege.getId());
			ImageView imageView = new ImageView(
					new Image(getClass().getResourceAsStream("/pics/info.gif"), 20, 0, true, true));
			Button info = new Button("", imageView);
			info.setStyle(SHOW_DETAIL_BTN_STYLE);

			Tooltip tooltip = new Tooltip(saege.getBeschreibung());
			tooltip.setPrefWidth(300);
			tooltip.setPrefHeight(200);
			tooltip.setWrapText(true);
			tooltip.setFont(new Font(12));
			info.setTooltip(tooltip);

			swl.add(new StihlTableView(info, new SimpleIntegerProperty(saege.getId()),
					new SimpleStringProperty(saege.getName()), new SimpleDoubleProperty(saege.getHubraum()),
					new SimpleDoubleProperty(saege.getPs()), new SimpleDoubleProperty(saege.getGewicht()),
					new SimpleDoubleProperty(saege.getKw()), new SimpleStringProperty(saege.getKettenteilung()),
					new SimpleIntegerProperty(saege.getSchienenlaenge()), new SimpleDoubleProperty(saege.getPreis())));
		}

		tableDataVergleich = FXCollections.observableList(swl);
		tableVergleich = new TableView<StihlTableView>();
		createTableStructure();
		tableVergleich.setMaxHeight(MAX_TABLE_HEIGHT);
		tableVergleich.setMinWidth(MIN_TABLE_WIDTH);
		tableVergleich.setItems(tableDataVergleich);
		tableVergleich.scrollTo(0);
	}

	private void createTableStructure() {

		TableColumn<StihlTableView, String> colInfo = new TableColumn<StihlTableView, String>("Details");
		colInfo.setMinWidth(40);
		colInfo.setStyle(FX_ALIGNMENT_CENTER);
		colInfo.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("btn"));

		TableColumn<StihlTableView, String> modellnameCol = new TableColumn<StihlTableView, String>("Modellname");
		modellnameCol.setMinWidth(170);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("name"));

		TableColumn<StihlTableView, Double> hubraumCol = new TableColumn<StihlTableView, Double>("Hubraum cm³");
		hubraumCol.setMinWidth(100);
		hubraumCol.setStyle(FX_ALIGNMENT_CENTER);
		hubraumCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("hubraum"));

		TableColumn<StihlTableView, Double> leistungCol = new TableColumn<StihlTableView, Double>("Leistung PS");
		leistungCol.setMinWidth(100);
		leistungCol.setStyle(FX_ALIGNMENT_CENTER);
		leistungCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("ps"));

		TableColumn<StihlTableView, Double> kwCol = new TableColumn<StihlTableView, Double>("kW");
		kwCol.setMinWidth(100);
		kwCol.setStyle(FX_ALIGNMENT_CENTER);
		kwCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("kw"));

		TableColumn<StihlTableView, String> kettenteilungCol = new TableColumn<StihlTableView, String>("Kettenteilung");
		kettenteilungCol.setMinWidth(100);
		kettenteilungCol.setStyle(FX_ALIGNMENT_CENTER);
		kettenteilungCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("kettenteilung"));

		TableColumn<StihlTableView, Integer> schienenlaengeCol = new TableColumn<StihlTableView, Integer>(
				"Schienenlaenge");
		schienenlaengeCol.setMinWidth(100);
		schienenlaengeCol.setStyle(FX_ALIGNMENT_CENTER);
		schienenlaengeCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Integer>("schienenlaenge"));

		TableColumn<StihlTableView, Double> gewichtCol = new TableColumn<StihlTableView, Double>("Gewicht kg");
		gewichtCol.setMinWidth(100);
		gewichtCol.setStyle(FX_ALIGNMENT_CENTER);
		gewichtCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("gewicht"));

		TableColumn<StihlTableView, Double> preisCol = new TableColumn<StihlTableView, Double>("Preis €");
		preisCol.setMinWidth(100);
		preisCol.setStyle(FX_ALIGNMENT_CENTER);
		preisCol.setCellValueFactory(new PropertyValueFactory<StihlTableView, Double>("preis"));

		tableVergleich.getColumns().addAll(colInfo, modellnameCol, hubraumCol, leistungCol, kwCol, kettenteilungCol,
				schienenlaengeCol, gewichtCol, preisCol);
	}

	/**
	 * @return the table
	 */
	public TableView<StihlTableView> getVergleichTable(List<Saege> selectedSaegenList) {
		initSaegenVergleichTable(selectedSaegenList);
		return tableVergleich;
	}
}
