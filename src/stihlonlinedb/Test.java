package stihlonlinedb;

import stihlonlinedb.dao.queries.IClauses;
import stihlonlinedb.dao.queries.ListDbObjects;
import stihlonlinedb.dao.queries.Queries;
import stihlonlinedb.db.DBConnection;

/**
 * Test1-Klasse, um die Grundfunktionalitäten der DB zu testen.
 *
 */
public class Test implements IClauses {

	public static void main(String[] args) {
		try {
			DBConnection.openDbConnection();

			Queries qs = new Queries();
			ListDbObjects listDbObjects = new ListDbObjects();
			System.out.println(listDbObjects.getAllProdukte());
			System.out.println(listDbObjects.getAllBilder());
			System.out.println(listDbObjects.getAllEinsatzzwecke());
			System.out.println(listDbObjects.getAllZubehoer());
			System.out.println(listDbObjects.getAllSaegen());

			System.out.println(qs.getZubehoerById(3));
			System.out.println(qs.getSaegeById(6));
			System.out.println(qs.getProdukteById(2));
			System.out.println(qs.getEinsatzzweckById(3));
			System.out.println(qs.getBildById(15));
			DBConnection.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}

}
