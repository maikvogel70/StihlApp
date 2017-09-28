package stihlonlinedb.fx;

/**
 * Interface f�r die zentrale Bereitstellung der Eigenschaften von Tabellen,
 * Beschriftungen, Bilder usw.
 *
 */
public interface ICommonProps {

	/**
	 * Grunds�tzliche Tabellenkonfiguration Breite
	 */
	static final int MIN_TABLE_WIDTH = 715;
	/**
	 * Grunds�tzliche Tabellenkonfiguration H�he
	 */
	static final int MAX_TABLE_HEIGH = 260;

	/**
	 * Grunds�tzliche Vergleichs Tabellenkonfiguration Breite
	 */
	static final int MIN_TABLE_WIDTH_VERGLEICH = 550;
	/**
	 * Grunds�tzliche Vergleichs Tabellenkonfiguration H�he
	 */
	static final int MAX_TABLE_HEIGHT_VERGLEICH = 196;

	/**
	 * Grunds�tzliche Breite der Bilder der Navigations-Buttons
	 */
	static final int IMAGE_WIDTH_NAV = 160;
	/**
	 * Grunds�tzliche Breite der Bilder der Detail-Buttons
	 */
	static final int IMAGE_WIDTH_DETAILS = 500;
	/**
	 * Grunds�tzliche Breite der Bilder der "Zeigen"-Buttons
	 */
	static final int IMAGE_WIDTH_SHOW_BTN = 60;
	/**
	 * Grunds�tzliche H�he des Startbildes
	 */
	static final int IMAGE_HEIGHT_START_LOGO = 800;
	/**
	 * Grunds�tzliche Breite des Info-Icons im Vergleichsdialog
	 */
	static final int INFO_BTN_WIDTH = 20;

	/**
	 * Beschriftungen
	 */
	static final String COMPARE_SAWS_TITLE = "Vergleiche S�gen";
	/**
	 * Beschriftungen
	 */
	static final String PRODUCT_TITLE = "STIHL Produkte";
	/**
	 * Beschriftungen
	 */
	static final String STIHL_PRODUKTE_LABEL = "STIHL Produkte";
	/**
	 * Beschriftungen
	 */
	static final String TOOLTIP_DETAIL_BTN = "Zeige weitere Details zu dem Artikel an";

	/**
	 * Pfad zu den Bildern
	 */
	static final String MAIN_IMAGE_PATH = "/pics/";

	/**
	 * Style-Klasse
	 */
	static final String STIHL_LABEL_STYLE_CLASS = "labelTitleView";
	/**
	 * Style-Klasse
	 */
	static final String HYPERLINK_STYLE_CLASS = "hyperLink";
	/**
	 * Style-Klasse
	 */
	static final String STIHL_BTN_STYLE_CLASS = "btnStihlStyle";
	/**
	 * Style-Klasse
	 */
	static final String SHOW_DETAIL_BTN_STYLE_CLASS = "showDetailBtn";
	/**
	 * Style-Klasse
	 */
	static final String SEARCH_BTN_STYLE_CLASS = "showDetailBtn";
	/**
	 * Style-Klasse
	 */
	static final String TRANSPARENT_STYLE_CLASS = "transparentBg";
	/**
	 * Ausrichtung des Inhalts innerhalb der Tabelle
	 */
	static final String FX_ALIGNMENT_CENTER = "-fx-alignment: CENTER;";
}
