package stihlonlinedb.entities;

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
