package stihlonlinedb.entities;

import java.util.Set;

public class Zubehoer {
	private int id;
	private String bestellnummer, name, beschreibung;
	private double preis;
	private Set<Integer> bild;

	public Zubehoer() {
	}

	public Zubehoer(int id, String bestellnummer, String name, String beschreibung, double preis, Set<Integer> bild) {
		super();
		this.id = id;
		this.bestellnummer = bestellnummer;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
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

	/**
	 * @return the bestellnummer
	 */
	public String getBestellnummer() {
		return bestellnummer;
	}

	/**
	 * @param bestellnummer
	 *            the bestellnummer to set
	 */
	public void setBestellnummer(String bestellnummer) {
		this.bestellnummer = bestellnummer;
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
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * @param beschreibung
	 *            the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * @return the preis
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * @param preis
	 *            the preis to set
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * @return the bild
	 */
	public Set<Integer> getBild() {
		return bild;
	}

	/**
	 * @param bild
	 *            the bild to set
	 */
	public void setBild(Set<Integer> bild) {
		this.bild = bild;
	}

}
