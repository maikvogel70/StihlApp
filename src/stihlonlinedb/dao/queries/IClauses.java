package stihlonlinedb.dao.queries;

public interface IClauses {
	public final String FROM_CLAUSE_PRODUKTE = "SELECT * FROM Produkte INNER JOIN bildablage ON bildablage.ID = Produkte.FK_Bild";
	public final String FROM_CLAUSE_BILDER = "SELECT * FROM Bildablage";
	public final String FROM_CLAUSE_EINSATZ = "SELECT * FROM Einsatzzweck INNER JOIN Bildablage ON bildablage.ID = Einsatzzweck.FK_Bild";
	public final String FROM_CLAUSE_KETTEN = "SELECT * FROM Ketten";
	public final String FROM_CLAUSE_FUEHRUNG = "SELECT * FROM Fuehrungsschienen INNER JOIN Bildablage ON bildablage.ID = Fuehrungsschienen.FK_Bild";
	// TODO: ggf ergänzen - je nach zeit
	public final String FROM_CLAUSE_SAEGE = "SELECT s.ID,s.Name,s.Bestellnummer,s.Beschreibung,s.Kettenteilung,s.Besonderheiten,s.KW,s.PS,s.Schienenlaenge, s.Gewicht,s.Hubraum, s.Preis,b.Pfad FROM saege AS s JOIN bildablage AS b ON b.ID = s.FK_Bild ORDER BY s.ID ";
	public final String FROM_CLAUSE_ZUBEHOER = "SELECT * FROM Zubehoer INNER JOIN bildablage ON bildablage.ID = zubehoer.FK_Bild";
	public final String FROM_CLAUSE_KUNDE = "SELECT * FROM Kunde";
}
