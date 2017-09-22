package stihlonlinedb.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.fx.controller.DetailDialogController;

public class KategorieContentTable {
	private static final String SHOW_DETAIL_BTN_STYLE = " -fx-background-color: transparent;  -fx-border-width: 1; -fx-border-color: transparent, #f37a1f;  -fx-border-radius:3";
	private ObservableList<SaegeView> tableData;
	private TableView<SaegeView> table;

	private void initSaegenTable(int id) {
		Queries qs = new Queries();
		List<Saege> saegen = qs.getSaegeByEinsatzzweck(id);
		List<SaegeView> swl = new ArrayList<>();
		Image image = new Image(getClass().getResourceAsStream("/pics/tableShowDetail.gif"), 100, 20, true, true);
		Button showBtn;

		for (Saege saege : saegen) {
			showBtn = new Button("", new ImageView(image));
			showBtn.setStyle(showBtn.getStyle() + SHOW_DETAIL_BTN_STYLE);
			showBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
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
				}
			});

			swl.add(new SaegeView(new SimpleIntegerProperty(saege.getId()), showBtn,
					new SimpleStringProperty(saege.getName()), new SimpleDoubleProperty(saege.getHubraum()),
					new SimpleDoubleProperty(saege.getPs()), new SimpleDoubleProperty(saege.getGewicht()),
					new SimpleDoubleProperty(saege.getPreis())));
		}
		System.out.println(swl);
		tableData = FXCollections.observableList(swl);
		createTableStructure();
	}

	private void createTableStructure() {
		TableColumn<SaegeView, String> showCol = new TableColumn<SaegeView, String>("Details");
		showCol.setMinWidth(40);
		showCol.setStyle("-fx-alignment: CENTER;");
		showCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("btn"));

		TableColumn<SaegeView, String> modellnameCol = new TableColumn<SaegeView, String>("Modellname");
		modellnameCol.setMinWidth(230);
		modellnameCol.setCellValueFactory(new PropertyValueFactory<SaegeView, String>("name"));

		TableColumn<SaegeView, Double> hubraumCol = new TableColumn<SaegeView, Double>("Hubraum cm³");
		hubraumCol.setMinWidth(100);
		hubraumCol.setStyle("-fx-alignment: CENTER;");
		hubraumCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("hubraum"));

		TableColumn<SaegeView, Double> leistungCol = new TableColumn<SaegeView, Double>("Leistung PS");
		leistungCol.setMinWidth(100);
		leistungCol.setStyle("-fx-alignment: CENTER;");
		leistungCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("ps"));

		TableColumn<SaegeView, Double> gewichtCol = new TableColumn<SaegeView, Double>("Gewicht kg");
		gewichtCol.setMinWidth(100);
		gewichtCol.setStyle("-fx-alignment: CENTER;");
		gewichtCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("gewicht"));

		TableColumn<SaegeView, Double> preisCol = new TableColumn<SaegeView, Double>("Preis €");
		preisCol.setMinWidth(100);
		preisCol.setStyle("-fx-alignment: CENTER;");
		preisCol.setCellValueFactory(new PropertyValueFactory<SaegeView, Double>("preis"));

		table = new TableView<SaegeView>();
		table.setMaxHeight(280);
		table.setMinWidth(600);
		table.setItems(tableData);
		table.scrollTo(0);
		table.getColumns().addAll(showCol, modellnameCol, hubraumCol, leistungCol, gewichtCol, preisCol);
	}

	/**
	 * @return the table
	 */
	public TableView<SaegeView> getTable(int id) {
		initSaegenTable(id);
		return table;
	}

	public class SaegeView {
		SimpleStringProperty name;
		SimpleDoubleProperty hubraum, ps, gewicht, preis;
		Button btn;
		SimpleIntegerProperty id;

		public SaegeView(SimpleIntegerProperty id, Button btn, SimpleStringProperty name, SimpleDoubleProperty hubraum,
				SimpleDoubleProperty ps, SimpleDoubleProperty gewicht, SimpleDoubleProperty preis) {
			this.id = id;
			this.btn = btn;
			this.name = name;
			this.hubraum = hubraum;
			this.ps = ps;
			this.gewicht = gewicht;
			this.preis = preis;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id.get();
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(int id) {
			this.id.set(id);
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name.get();
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name.set(name);
		}

		/**
		 * @return the hubraum
		 */
		public double getHubraum() {
			return hubraum.get();
		}

		/**
		 * @param hubraum
		 *            the hubraum to set
		 */
		public void setHubraum(double hubraum) {
			this.hubraum.set(hubraum);
		}

		/**
		 * @return the ps
		 */
		public double getPs() {
			return ps.get();
		}

		/**
		 * @param ps
		 *            the ps to set
		 */
		public void setPs(double ps) {
			this.ps.set(ps);
		}

		/**
		 * @return the gewicht
		 */
		public double getGewicht() {
			return gewicht.get();
		}

		/**
		 * @param gewicht
		 *            the gewicht to set
		 */
		public void setGewicht(double gewicht) {
			this.gewicht.set(gewicht);
		}

		/**
		 * @return the preis
		 */
		public double getPreis() {
			return preis.get();
		}

		/**
		 * @param preis
		 *            the preis to set
		 */
		public void setPreis(double preis) {
			this.preis.set(preis);
		}

		/**
		 * @return the btn
		 */
		public Button getBtn() {
			return btn;
		}

		/**
		 * @param btn
		 *            the btn to set
		 */
		public void setBtn(Button btn) {
			this.btn = btn;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "SaegeView [name=" + name + ", hubraum=" + hubraum + ", ps=" + ps + ", gewicht=" + gewicht
					+ ", preis=" + preis + ", btn=" + btn + ", id=" + id + "]";
		}

	}
}
