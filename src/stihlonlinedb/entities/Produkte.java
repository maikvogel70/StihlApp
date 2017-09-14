package stihlonlinedb.entities;

import java.util.List;

public class Produkte {

	private String name, bild;

	public Produkte(List<Produkte> produkteList, String name, String bild) {
		super();
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
	public String getBild() {
		return bild;
	}

	/**
	 * @param bild
	 *            the bild to set
	 */
	public void setBild(String bild) {
		this.bild = bild;
	}

}
