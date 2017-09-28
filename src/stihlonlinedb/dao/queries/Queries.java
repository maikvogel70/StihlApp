package stihlonlinedb.dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stihlonlinedb.db.DBConnection;
import stihlonlinedb.entities.Bildablage;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.SearchClass;
import stihlonlinedb.entities.Zubehoer;

/**
 * Erstellt die Queries für die DB-Abfragen
 *
 */
public class Queries {

	/**
	 * Liefert das Suchergebnis
	 * 
	 * @return List
	 * @param
	 */
	public List<SearchClass> getSearchResults(String kategorie, String searchFor) {
		String q = "";
		switch (kategorie) {
		case "Motorsägen und Kettensägen":
			q = "SELECT saege.id,name,beschreibung,bildablage.pfad FROM `saege` INNER JOIN bildablage ON bildablage.ID = Saege.FK_Bild WHERE `Name` LIKE '%"
					+ searchFor + "%' ORDER BY saege.ID";
			return this.getSearchByKatSearch(q, new Saege());
		case "Zubehör und Betriebsstoffe":
			q = "SELECT zubehoer.id,name,beschreibung,bildablage.pfad FROM `zubehoer` INNER JOIN bildablage ON bildablage.ID = zubehoer.FK_Bild WHERE `Name` LIKE '%"
					+ searchFor + "%' ORDER BY zubehoer.ID";
			return this.getSearchByKatSearch(q, new Zubehoer());
		}
		return null;
	}

	/**
	 * Liefert die Säge anhand der ID des Einsatzzweckes
	 * 
	 * @return List
	 * @param
	 */
	public List<Saege> getSaegeByEinsatzzweck(int id) {
		String q = "SELECT Saege.id,name,hubraum,ps,gewicht,preis FROM Saege INNER JOIN bildablage ON bildablage.ID = Saege.FK_Bild WHERE Saege.FK_Einsatzzweck ="
				+ id;
		return this.getSaegeByEinsatzzweckId(q);
	}

	/**
	 * Liefert die Säge anhand ihrer ID
	 * 
	 * @return List
	 * @param
	 */
	public Saege getSaegeById(int id) {
		String q = "SELECT * FROM Saege INNER JOIN bildablage ON bildablage.ID = Saege.FK_Bild WHERE Saege.ID =" + id;
		return this.getSaegeById(q);
	}

	/**
	 * Liefert ein Zubehör anhand seiner ID
	 * 
	 * @return List
	 * @param
	 */
	public Zubehoer getZubehoerById(int id) {
		String q = "SELECT * FROM Zubehoer INNER JOIN bildablage ON bildablage.ID = zubehoer.FK_Bild WHERE zubehoer.ID ="
				+ id;
		return this.getZubehoerById(q);
	}

	/**
	 * Liefert ein Produkt anhand seiner ID
	 * 
	 * @return List
	 * @param
	 */
	public Produkte getProdukteById(int id) {
		String q = "SELECT * FROM Produkte INNER JOIN bildablage ON bildablage.ID = produkte.FK_Bild WHERE produkte.ID ="
				+ id;
		return this.getProdukteById(q);
	}

	/**
	 * Liefert den Einsatzzweck anhand seiner ID
	 * 
	 * @return List
	 * @param
	 */
	public Einsatzzweck getEinsatzzweckById(int id) {
		String q = "SELECT * FROM Einsatzzweck INNER JOIN bildablage ON bildablage.ID = einsatzzweck.FK_Bild WHERE einsatzzweck.ID ="
				+ id;
		return this.getEinsatzzweckById(q);
	}

	/**
	 * Liefert ein Bild-Objekt anhand seiner ID
	 * 
	 * @return List
	 * @param
	 */
	public Bildablage getBildById(int id) {
		String q = "SELECT * FROM Bildablage WHERE bildablage.ID =" + id;
		return this.getBildById(q);
	}

	/**
	 * Liefert Objekte anhand eines SQL Queries und den Eltern-Typ des gesuchten
	 * Objektes
	 * 
	 * @return List
	 * @param
	 */
	private List<SearchClass> getSearchByKatSearch(String q, SearchClass clazz) {
		ResultSet rs = DBConnection.executeQuery(q);
		List<SearchClass> scL = new ArrayList<>();
		SearchClass sc = null;
		try {
			while (rs.next()) {
				if (clazz instanceof Saege) {
					sc = new Saege();
				} else if (clazz instanceof Zubehoer) {
					sc = new Zubehoer();
				}
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				sc.setBeschreibung(rs.getString(3));
				sc.setBildablage(new Bildablage(0, rs.getString(4)));
				scL.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scL;
	}

	/**
	 * Liefert ein Bild-Objekt anhand seines SQL-Queries
	 * 
	 * @return List
	 * @param
	 */
	private Bildablage getBildById(String q) {
		ResultSet rs = DBConnection.executeQuery(q);
		Bildablage b = null;
		try {
			if (rs.next()) {
				b = new Bildablage(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Liefert ein Einsatzzweck-Objekt anhand seines SQL-Queries
	 * 
	 * @return List
	 * @param
	 */
	private Einsatzzweck getEinsatzzweckById(String q) {
		ResultSet rs = DBConnection.executeQuery(q);
		Einsatzzweck e = null;
		try {
			if (rs.next()) {
				e = new Einsatzzweck(rs.getInt(1), rs.getString(2), new Bildablage(rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	/**
	 * Liefert ein Produkt-Objekt anhand seines SQL-Queries
	 * 
	 * @return List
	 * @param
	 */
	private Produkte getProdukteById(String q) {
		ResultSet rs = DBConnection.executeQuery(q);
		Produkte p = null;
		try {
			if (rs.next()) {
				p = new Produkte(rs.getInt(1), rs.getString(2), new Bildablage(0, rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Liefert ein Zubehör-Objekt anhand seines SQL-Queries
	 * 
	 * @return List
	 * @param
	 */
	private Zubehoer getZubehoerById(String query) {
		ResultSet rs = DBConnection.executeQuery(query);
		Zubehoer z = null;
		try {
			if (rs.next()) {
				z = new Zubehoer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						new Bildablage(0, rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return z;
	}

	/**
	 * Liefert ein Sägen anhand seines SQL-Queries für Einsazzwecke auf
	 * 
	 * @return List
	 * @param
	 */
	private List<Saege> getSaegeByEinsatzzweckId(String query) {
		ResultSet rs = DBConnection.executeQuery(query);
		List<Saege> l = new ArrayList<>();
		Saege s;
		try {
			while (rs.next()) {
				s = new Saege();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setHubraum(rs.getDouble(3));
				s.setPs(rs.getDouble(4));
				s.setGewicht(rs.getDouble(5));
				s.setPreis(rs.getDouble(6));
				l.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	/**
	 * Liefert ein Sägen-Objekt anhand seines SQL-Queries
	 * 
	 * @return List
	 * @param
	 */
	private Saege getSaegeById(String query) {
		ResultSet rs = DBConnection.executeQuery(query);
		Saege s = null;
		try {
			if (rs.next()) {
				s = new Saege();
				s.setBeschreibung(rs.getString(5));
				s.setBesonderheiten(rs.getString(6));
				s.setBestellnummer(rs.getString(2));
				s.setBildablage(new Bildablage(0, rs.getString(17)));
				s.setEinsatzzweck(null);
				s.setGewicht(rs.getDouble(10));
				s.setHubraum(rs.getDouble(11));
				s.setId(rs.getInt(1));
				s.setKettenteilung(rs.getString(3));
				s.setKw(rs.getDouble(7));
				s.setName(rs.getString(4));
				s.setPreis(rs.getDouble(12));
				s.setPs(rs.getDouble(8));
				s.setSchienenlaenge(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

}
