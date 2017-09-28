package stihlonlinedb.fx.util;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import stihlonlinedb.view.StihlTableView;

/**
 * 
 * FX-Uitility-Klasse f�r diverse Static-Methoden
 *
 */
public class FxUtils {

	/**
	 * Der Zeilenumbruch innerhalb eine Tabellenzelle wird �ber diese Methode
	 * gesteuert. Siehe Ordner "doku" im Projekt f�r den Fall, dass der Link
	 * ung�ltig geworden ist.
	 * 
	 * {@link http://www.jluger.de/blog/20160731_javafx_text_rendering_in_tableview.html}
	 * 
	 */
	public static final Callback<TableColumn<StihlTableView, String>, TableCell<StihlTableView, String>> WRAPPING_CELL_FACTORY = new Callback<TableColumn<StihlTableView, String>, TableCell<StihlTableView, String>>() {

		@Override
		public TableCell<StihlTableView, String> call(TableColumn<StihlTableView, String> param) {
			TableCell<StihlTableView, String> tableCell = new TableCell<StihlTableView, String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					if (item == getItem())
						return;

					super.updateItem(item, empty);

					if (item == null) {
						super.setText(null);
						super.setGraphic(null);
					} else {
						super.setText(item);
						super.setGraphic(null);
					}
				}
			};
			tableCell.setWrapText(true);
			return tableCell;
		}
	};
}
