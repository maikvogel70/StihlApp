package stihlonlinedb.dao.queries;

/**
 * Interface, welches die vorgefertigten SQL-Queries bereitstellt
 *
 */
public interface IClauses {
	public final String FROM_CLAUSE_PRODUKTE = "SELECT * FROM Produkte INNER JOIN bildablage ON bildablage.ID = Produkte.FK_Bild";
	public final String FROM_CLAUSE_BILDER = "SELECT * FROM Bildablage";
	public final String FROM_CLAUSE_EINSATZ = "SELECT * FROM Einsatzzweck INNER JOIN Bildablage ON bildablage.ID = Einsatzzweck.FK_Bild";
	public final String FROM_CLAUSE_KETTEN = "SELECT * FROM Ketten";
	public final String FROM_CLAUSE_FUEHRUNG = "SELECT * FROM Fuehrungsschienen INNER JOIN Bildablage ON bildablage.ID = Fuehrungsschienen.FK_Bild";
	public final String FROM_CLAUSE_SAEGE = "SELECT Saege.*,EZ.Pfad,Einsatzzweck.Name,BA.Pfad FROM Saege LEFT JOIN Einsatzzweck ON Einsatzzweck.ID = Saege.FK_Einsatzzweck LEFT JOIN Bildablage SA ON SA.ID = Saege.FK_Bild INNER JOIN Bildablage EZ ON EZ.ID = Saege.FK_Einsatzzweck JOIN Bildablage BA ON BA.ID = Einsatzzweck.FK_Bild";
	public final String FROM_CLAUSE_ZUBEHOER = "SELECT * FROM Zubehoer INNER JOIN bildablage ON bildablage.ID = zubehoer.FK_Bild";
	public final String FROM_CLAUSE_KUNDE = "SELECT * FROM Kunde";
}
