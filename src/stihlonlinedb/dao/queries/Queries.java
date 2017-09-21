package stihlonlinedb.dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stihlonlinedb.db.DBConnection;
import stihlonlinedb.entities.Bildablage;
import stihlonlinedb.entities.Einsatzzweck;
import stihlonlinedb.entities.Fuehrungsschienen;
import stihlonlinedb.entities.Ketten;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.Zubehoer;

public class Queries {

	public Queries() {
	}

	public List<Saege> getSaegeByEinsatzzweck(int id) {
		String q = "SELECT Saege.id,name,hubraum,ps,gewicht,preis FROM Saege INNER JOIN bildablage ON bildablage.ID = Saege.FK_Bild WHERE Saege.FK_Einsatzzweck ="
				+ id;
		return this.getSaegeByEinsatzzweckId(q);
	}

	public Saege getSaegeById(int id) {
		String q = "SELECT * FROM Saege INNER JOIN bildablage ON bildablage.ID = Saege.FK_Bild WHERE Saege.ID =" + id;
		return this.getSaegeById(q);
	}

	public Zubehoer getZubehoerById(int id) {
		String q = "SELECT * FROM Zubehoer INNER JOIN bildablage ON bildablage.ID = zubehoer.FK_Bild WHERE zubehoer.ID ="
				+ id;
		return this.getZubehoerById(q);
	}

	public Produkte getProdukteById(int id) {
		String q = "SELECT * FROM Produkte INNER JOIN bildablage ON bildablage.ID = produkte.FK_Bild WHERE produkte.ID ="
				+ id;
		return this.getProdukteById(q);
	}

	public Einsatzzweck getEinsatzzweckById(int id) {
		String q = "SELECT * FROM Einsatzzweck INNER JOIN bildablage ON bildablage.ID = einsatzzweck.FK_Bild WHERE einsatzzweck.ID ="
				+ id;
		return this.getEinsatzzweckById(q);
	}

	public Fuehrungsschienen getFuehungsschienenById(int id) {
		String q = "SELECT * FROM Fuehrungsschienen INNER JOIN bildablage ON bildablage.ID = fuehrungsschienen.FK_Bild WHERE fuehrungsschienen.ID ="
				+ id;
		return this.getFuehrungsschienenById(q);
	}

	public Ketten getKettenById(int id) {
		String q = "SELECT * FROM Ketten WHERE ketten.ID =" + id;
		return this.getKettenById(q);
	}

	public Bildablage getBildById(int id) {
		String q = "SELECT * FROM Bildablage WHERE bildablage.ID =" + id;
		return this.getBildById(q);
	}

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

	private Ketten getKettenById(String q) {
		ResultSet rs = DBConnection.executeQuery(q);
		Ketten k = null;
		try {
			if (rs.next()) {
				k = new Ketten(rs.getInt(1), rs.getInt(6), rs.getInt(9), rs.getString(3), rs.getString(2),
						rs.getString(4), rs.getString(5), rs.getDouble(8), rs.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}

	private Fuehrungsschienen getFuehrungsschienenById(String q) {
		ResultSet rs = DBConnection.executeQuery(q);
		Fuehrungsschienen f = null;
		try {
			if (rs.next()) {
				f = new Fuehrungsschienen(rs.getInt(1), rs.getInt(5), rs.getInt(6), rs.getString(3), rs.getString(2),
						rs.getString(4), rs.getDouble(7),
						new stihlonlinedb.hibernateOLD.Bildablage(0, rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

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

	private List<Saege> getSaegeByEinsatzzweckId(String query) {
		System.out.println(query);
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

				//
				// s.setBeschreibung(rs.getString(4));
				// s.setBesonderheiten(rs.getString(6));
				// s.setBestellnummer(rs.getString(3));
				// s.setBestellung(null);
				// s.setBildablage(new Bildablage(0, rs.getString(17)));
				// s.setEinsatzzweck(null);
				// s.setId(rs.getInt(1));
				// s.setKettenteilung(rs.getString(5));
				// s.setKw(rs.getDouble(7));
				// s.setSchienenlaenge(rs.getInt(9));
				l.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	private Saege getSaegeById(String query) {
		System.out.println(query);
		ResultSet rs = DBConnection.executeQuery(query);
		Saege s = null;
		try {
			if (rs.next()) {
				s = new Saege();
				// 1ID 2Bestellnummer 3Kettenteilung 4Name 6Besonderheiten 7KW 8PS
				// 9Schienenlaenge
				// 10Gewicht 11Hubraum 12Preis 13FK_Bild 14FK_Einsatzzweck FK_Bestellung ID
				// 17Pfad
				s.setBeschreibung(rs.getString(5));
				s.setBesonderheiten(rs.getString(6));
				s.setBestellnummer(rs.getString(2));
				s.setBestellung(null);
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
