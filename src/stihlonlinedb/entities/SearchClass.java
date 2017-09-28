package stihlonlinedb.entities;

/**
 * Typisierung der Suchergebnisse nach Sägen und Zubehör (zu Demozwecken nur auf
 * diese beiden begrenzt) <br>
 * {@link Saege}, {@link Zubehoer}
 */
public abstract class SearchClass {

	public abstract void setId(int id);

	public abstract void setName(String name);

	public abstract void setBeschreibung(String beschreibung);

	public abstract void setBildablage(Bildablage bildablage);

	public abstract int getId();

	public abstract String getName();

	public abstract String getBeschreibung();

	public abstract Bildablage getBildablage();

}
