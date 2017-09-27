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
import stihlonlinedb.entities.Kunde;
import stihlonlinedb.entities.Produkte;
import stihlonlinedb.entities.Saege;
import stihlonlinedb.entities.Zubehoer;

public class ListDbObjects implements IClauses {

	public ListDbObjects() {
	}

	public List<Produkte> getAllProdukte() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_PRODUKTE);
		List<Produkte> pList = new ArrayList<>();
		try {
			while (rs.next()) {
				pList.add(new Produkte(rs.getInt(1), rs.getString(2), new Bildablage(0, rs.getString(5))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	public List<Bildablage> getAllBilder() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_BILDER);
		List<Bildablage> bList = new ArrayList<>();
		try {
			while (rs.next()) {
				bList.add(new Bildablage(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	public List<Einsatzzweck> getAllEinsatzzwecke() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_EINSATZ);
		List<Einsatzzweck> eList = new ArrayList<>();
		try {
			while (rs.next()) {
				eList.add(
						new Einsatzzweck(rs.getInt(1), rs.getString(2), new Bildablage(rs.getInt(4), rs.getString(5))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eList;
	}

	public List<Zubehoer> getAllZubehoer() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_ZUBEHOER);
		List<Zubehoer> zList = new ArrayList<>();
		try {
			while (rs.next()) {
				zList.add(new Zubehoer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
						new Bildablage(0, rs.getString(8))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zList;
	}

	public List<Saege> getAllSaegen() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_SAEGE);
		List<Saege> sList = new ArrayList<>();
		try {
			while (rs.next()) {
				Saege s = new Saege();
				s.setBeschreibung(rs.getString(4));
				s.setBesonderheiten(rs.getString(6));
				s.setBestellnummer(rs.getString(3));
				s.setBestellung(null);
				s.setBildablage(new Bildablage(0, rs.getString(16)));
				Bildablage b = new Bildablage(0, rs.getString(18));
				Einsatzzweck e = new Einsatzzweck(0, rs.getString(17), b);
				s.setEinsatzzweck(e);
				s.setGewicht(rs.getDouble(10));
				s.setHubraum(rs.getDouble(11));
				s.setId(rs.getInt(1));
				s.setKettenteilung(rs.getString(5));
				s.setKw(rs.getDouble(7));
				s.setName(rs.getString(2));
				s.setPreis(rs.getDouble(12));
				s.setPs(rs.getDouble(8));
				s.setSchienenlaenge(rs.getInt(9));
				sList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}

	public List<Ketten> getAllKetten() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_KETTEN);
		List<Ketten> kList = new ArrayList<>();
		try {
			while (rs.next()) {
				kList.add(new Ketten(rs.getInt(1), rs.getInt(6), rs.getInt(9), rs.getString(3), rs.getString(2),
						rs.getString(4), rs.getString(5), rs.getDouble(8), rs.getDouble(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kList;
	}

	public List<Fuehrungsschienen> getAllFuerungsschienen() {
		ResultSet rs = DBConnection.executeQuery(FROM_CLAUSE_FUEHRUNG);
		List<Fuehrungsschienen> fList = new ArrayList<>();
		try {
			while (rs.next()) {
				fList.add(new Fuehrungsschienen(rs.getInt(1), rs.getInt(5), rs.getInt(6), rs.getString(3),
						rs.getString(2), rs.getString(4), rs.getDouble(7), new Bildablage(0, rs.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}

	public List<Kunde> getAllKunden() {
		return null;
		// return (List<Kunde>) getObjects(sessionFactory.openSession(),
		// FROM_CLAUSE_KUNDE);
	}

}
