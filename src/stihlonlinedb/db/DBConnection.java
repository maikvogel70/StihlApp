package stihlonlinedb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBConnection {

	private static Connection dbConn;
	private static String connectionString;

	public static void openDbConnection() {
		String connectionString, classForName;
		String server = "localhost";
		String dataBase = "stihlonlinedb";
		classForName = "org.mariadb.jdbc.Driver";
		connectionString = "jdbc:mariadb://" + server + ":3306/";
		connectionString += dataBase;
		if (DBConnection.connectToDatabase(classForName, connectionString, "root", null)) {
			System.out.println("Datenbank wurde erfolgreich ge�ffnet.");
		} else {
			System.out.println("Datenbank konte nicht ge�ffnet werden.");
		}
	}

	/**
	 * Stellt eine Verbindung zur Datenbank her. Diese Methode registriert den
	 * Treiber beim JDBC-Treibermanager und wird f�r Treiber verwendet, die dies
	 * nicht automatisch tun.
	 * 
	 * @param classForName
	 *            Name des zu registrierenden Treibers.
	 * @param connectionString
	 *            Verbindungszeichenfolge.
	 * @param userID
	 *            Benutzername
	 * @param passWord
	 *            Kennwort
	 * @return
	 */
	private static boolean connectToDatabase(String classForName, String connectionString, String userID,
			String passWord) {
		boolean retValue = false;
		try {
			Class.forName(classForName).newInstance();
			dbConn = DriverManager.getConnection(connectionString, userID, passWord);
			DBConnection.connectionString = connectionString;
			retValue = true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fehler beim Zugriff auf die Datenbank: " + ex.getMessage(), "Fehler",
					JOptionPane.ERROR_MESSAGE);
			dbConn = null;
			DBConnection.connectionString = null;
		}
		return retValue;
	}

	/**
	 * Gibt die aktuelle Datenbankverbindung zur�ck.
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		if (dbConn == null) {
			openDbConnection();
		}
		return dbConn;
	}

	/**
	 * Gibt die aktuelle Verbindungszeichenfolge zur�ck.
	 * 
	 * @return
	 */
	public static String getConnectionString() {
		return connectionString;
	}

	/**
	 * Schlie�t die aktuelle Datenbankverbindung.
	 */
	public static void closeConnection() {
		if (dbConn == null) {
			return;
		}
		try {
			dbConn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		dbConn = null;
		connectionString = null;
	}

	/**
	 * Gibt den Namen der aktuell ge�ffneten Datenbank zur�ck.
	 * 
	 * @return
	 */
	public static String getCurrentDb() {
		String catalog = "";
		if (dbConn == null) {
			return catalog;
		}
		try {
			catalog = dbConn.getCatalog();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return catalog;
	}

	/**
	 * F�hrt alle SQL-Anweisungen aus, die nicht zu Kategorie Data Query Language
	 * geh�ren.
	 * 
	 * @param SQL
	 * @return
	 */
	public static int executeNonQuery(String SQL) {
		int retValue = -1;
		Statement stmt;
		if (dbConn == null) {
			openDbConnection();
		}
		try {
			stmt = dbConn.createStatement();
			retValue = stmt.executeUpdate(SQL);
			stmt.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fehler beim Zugriff auf die Datenbank: " + ex.getMessage(), "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return retValue;
	}

	/**
	 * F�hrt alle SQL-Anweisungen der Data Query Language aus, und liefert den Wert
	 * der ersten Zeile und der ersten Spalte zur�ck.
	 * 
	 * @param SQL
	 * @return
	 */
	public static Object executeForSingleResult(String SQL) {
		Object retValue = null;
		Statement stmt;
		if (dbConn == null) {
			return retValue;
		}
		try {
			stmt = dbConn.createStatement();
			ResultSet rSet = stmt.executeQuery(SQL);

			// Auf die erste Zeile innerhalb des ResultSets positionieren
			rSet.next();

			// Den Inhalt der ersten Spalte in der Zeile dem R�ckgabewert zuweisen
			retValue = rSet.getObject(1);

			// ResultSet und Statement schlie�en
			rSet.close();
			stmt.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fehler beim Zugriff auf die Datenbank: " + ex.getMessage(), "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return retValue;
	}

	/**
	 * F�hrt alle SQL-Anweisungen der Data Query Language aus.
	 * 
	 * @param SQL
	 * @return
	 */
	public static ResultSet executeQuery(String SQL) {
		ResultSet rSet = null;
		Statement stmt;
		if (dbConn == null)
			return rSet;
		try {
			stmt = dbConn.createStatement();
			rSet = stmt.executeQuery(SQL);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fehler beim Zugriff auf die Datenbank: " + ex.getMessage(), "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
		return rSet;
	}

	/**
	 * Die Zeichenkette wird in einfache Anf�hrungszeichen gesetzt, evtl.
	 * vorkommende Anf�hrungszeichen innerhalb der Zeichenkette werden durch
	 * doppelte Anf�hrungszeichen ersetzt.
	 * 
	 * @param value
	 * @return
	 */
	public static String dbString(String value) {
		return "'" + value.replace("'", "''") + "'";
	}

}
