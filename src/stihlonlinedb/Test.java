package stihlonlinedb;

import stihlonlinedb.dao.Queries;
import stihlonlinedb.dao.auflistungen.IClauses;
import stihlonlinedb.dao.auflistungen.ListDbObjects;
import stihlonlinedb.db.DBConnection;
import stihlonlinedb.db.DbCommands;

public class Test implements IClauses {
	private DbCommands command;

	public static void main(String[] args) {
		Test test = new Test();
		try {
			DBConnection.openDbConnection();

			Queries qs = new Queries();
			ListDbObjects listDbObjects = new ListDbObjects();
			// System.out.println(listDbObjects.getAllProdukte());
			// System.out.println(listDbObjects.getAllBilder());
			// System.out.println(listDbObjects.getAllEinsatzzwecke());
			// System.out.println(listDbObjects.getAllZubehoer());
			// System.out.println(listDbObjects.getAllSaegen());
			// System.out.println(listDbObjects.getAllKetten());
			// System.out.println(listDbObjects.getAllFuerungsschienen());
			System.out.println(qs.getZubehoerById(3));
			System.out.println(qs.getSaegeById(6));
			System.out.println(qs.getProdukteById(5));
			System.out.println(qs.getEinsatzzweckById(12));
			System.out.println(qs.getFuehungsschienenById(6));
			System.out.println(qs.getKettenById(15));
			System.out.println(qs.getBildById(15));
			DBConnection.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}

	private void getSaegeById(int i) {
		// List<Saege> saegeById = command.getSaegeById(i);
		// System.out.println(saegeById);
	}

}
