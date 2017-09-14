package stihlonlinedb.entities;

import java.util.HashSet;
import java.util.Set;

public class Fuehrungsschienen {

	private int id, anzahlZaehneUmlenkung, laenge;
	private String name, bestellnummer, beschreibung;
	private double preis;
	private Set<Bildablage> bildablageFK = new HashSet<Bildablage>(0);

	public Fuehrungsschienen(int id, int anzahlZaehneUmlenkung, int laenge, String name, String bestellnummer,
			String beschreibung, double preis, Set<Bildablage> bildablageFK) {
		super();
		this.id = id;
		this.anzahlZaehneUmlenkung = anzahlZaehneUmlenkung;
		this.laenge = laenge;
		this.name = name;
		this.bestellnummer = bestellnummer;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bildablageFK = bildablageFK;
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
	 * @return the anzahlZaehneUmlenkung
	 */
	public int getAnzahlZaehneUmlenkung() {
		return anzahlZaehneUmlenkung;
	}

	/**
	 * @param anzahlZaehneUmlenkung
	 *            the anzahlZaehneUmlenkung to set
	 */
	public void setAnzahlZaehneUmlenkung(int anzahlZaehneUmlenkung) {
		this.anzahlZaehneUmlenkung = anzahlZaehneUmlenkung;
	}

	/**
	 * @return the laenge
	 */
	public int getLaenge() {
		return laenge;
	}

	/**
	 * @param laenge
	 *            the laenge to set
	 */
	public void setLaenge(int laenge) {
		this.laenge = laenge;
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
	 * @return the bildablageFK
	 */
	public Set<Bildablage> getBildablageFK() {
		return bildablageFK;
	}

	/**
	 * @param bildablageFK
	 *            the bildablageFK to set
	 */
	public void setBildablageFK(Set<Bildablage> bildablageFK) {
		this.bildablageFK = bildablageFK;
	}

}
