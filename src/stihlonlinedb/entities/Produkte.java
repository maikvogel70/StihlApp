package stihlonlinedb.entities;

public class Produkte {

	private int id;
	private String name;
	private Bildablage bild;

	public Produkte() {
	}

	public Produkte(int id, String name, Bildablage bild) {
		this.id = id;
		this.name = name;
		this.bild = bild;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bild
	 */
	public Bildablage getBild() {
		return bild;
	}

	/**
	 * @param bild
	 *            the bild to set
	 */
	public void setBild(Bildablage bild) {
		this.bild = bild;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produkte [id=" + id + ", name=" + name + ", bild=" + bild + "]";
	}

}
