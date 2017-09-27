package stihlonlinedb.view;

import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.PopOver;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.util.Duration;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.fx.ICommonProps;

public class VergleichContentTable implements ICommonProps {

	private ObservableList<StihlTableView> tableDataVergleich;
	private TableView<StihlTableView> tableVergleich;

	private void initSaegenVergleichTable(List<Saege> selectedSaegenList) {
		Queries qs = new Queries();
		List<StihlTableView> swl = new ArrayList<>();
		Saege saege = null;
		for (Saege selectedSaege : selectedSaegenList) {
			saege = qs.getSaegeById(selectedSaege.getId());
			ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(MAIN_IMAGE_PATH + "info.gif"),
					INFO_BTN_WIDTH, 0, true, true));
			Button info = new Button("", imageView);
			info.getStyleClass().add(TRANSPARENT_STYLE_CLASS);
			info.setUserData(saege.getBeschreibung());

			info.setOnAction((event -> {
				getPopover(info).show(info);
			}));

			swl.add(new StihlTableView(info, new SimpleIntegerProperty(saege.getId()),
					new SimpleStringProperty(saege.getName()), new SimpleDoubleProperty(saege.getHubraum()),
					new SimpleDoubleProperty(saege.getPs()), new SimpleDoubleProperty(saege.getGewicht()),
					new SimpleDoubleProperty(saege.getKw()), new SimpleStringProperty(saege.getKettenteilung()),
					new SimpleIntegerProperty(saege.getSchienenlaenge()), new SimpleDoubleProperty(saege.getPreis())));
		}

		tableDataVergleich = FXCollections.observableList(swl);
		tableVergleich = new TableView<StihlTableView>();
		createTableStructure();
		tableVergleich.setMaxHeight(MAX_TABLE_HEIGHT_VERGLEICH);
		tableVergleich.setMinWidth(MIN_TABLE_WIDTH_VERGLEICH);
		tableVergleich.setItems(tableDataVergleich);
		tableVergleich.scrollTo(0);
	}

	private PopOver getPopover(Button info) {
		PopOver popOver = new PopOver();
		popOver.setAutoHide(true);
		popOver.setHeaderAlwaysVisible(true);
		popOver.setTitle("Beschreibung");

		Label msgLabel = new Label();
		msgLabel.setFont(Font.font(12));
		msgLabel.setMaxWidth(300);
		msgLabel.setMinHeight(300);
		msgLabel.setWrapText(true);
		msgLabel.setAlignment(Pos.TOP_LEFT);
		msgLabel.setPadding(new Insets(10));
		msgLabel.setText(info.getUserData().toString());

		popOver.setContentNode(msgLabel);
		popOver.setFadeInDuration(Duration.millis(200));
		popOver.setFadeOutDuration(Duration.millis(200));
		return popOver;
	}

	@SuppressWarnings("unchecked")
	private void createTableStructure() {

		TableColumn<StihlTableView, String> colInfo = new TableColumn<StihlTableView, String>("Details");
		colInfo.setMinWidth(40);
		colInfo.setStyle(FX_ALIGNMENT_CENTER);
		colInfo.setCellValueFactory(new PropertyValueFactory<StihlTableView, String>("btn"));

		TableColumn<StihlTableView, String> modellnameCol = new TableColumn<StihlTableView, String>("Modellname");
		modellnameCol.setMinWidth(190);
		modellnameCol.setStyle(FX_ALIGNMENT_CENTER);
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
