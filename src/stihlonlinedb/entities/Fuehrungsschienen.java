package stihlonlinedb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import stihlonlinedb.hibernateOLD.Bildablage;

@Entity
@Table(name = "FUEHUNGSSCHIENEN")
public class Fuehrungsschienen {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	private int anzahlZaehneUmlenkung, laenge;
	private String name, bestellnummer, beschreibung;
	private double preis;

	@OneToOne
	@JoinColumn(name = "FK_BILD")
	private Bildablage bild;

	public Fuehrungsschienen() {
	}

	public Fuehrungsschienen(int id, int anzahlZaehneUmlenkung, int laenge, String name, String bestellnummer,
			String beschreibung, double preis, Bildablage bildablageFK) {
		super();
		this.id = id;
		this.anzahlZaehneUmlenkung = anzahlZaehneUmlenkung;
		this.laenge = laenge;
		this.name = name;
		this.bestellnummer = bestellnummer;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bild = bildablageFK;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fuehrungsschienen [id=" + id + ", anzahlZaehneUmlenkung=" + anzahlZaehneUmlenkung + ", laenge=" + laenge
				+ ", name=" + name + ", bestellnummer=" + bestellnummer + ", beschreibung=" + beschreibung + ", preis="
				+ preis + ", bild=" + bild.getPfad() + "]";
	}

}
