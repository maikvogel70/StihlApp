package stihlonlinedb.hibernateOLD;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ZUBEHOER")
public class Zubehoer implements Serializable {

	private static final long serialVersionUID = -5587393447258724609L;
	private int id;
	private String bestellnummer;
	@Column
	private String name;
	@Column
	private String beschreibung;
	@Column
	private double preis;
	@JoinColumn(name = "FK_Bild", foreignKey = @ForeignKey(name = "FK_Bild"))
	private int fk_Bild;

	// @JoinColumn(name = "bild_ID", foreignKey = @ForeignKey(name = "FK_Bild"))
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Bildablage.class)
	// @JoinColumn(foreignKey = @ForeignKey(name = "FK_Bild"))
	private Set<Bildablage> bildablage = new HashSet<>();

	public Zubehoer() {
	}

	public Zubehoer(int id, String bestellnummer, String name, String beschreibung, double preis,
			Set<Bildablage> bildablage) {
		super();
		this.id = id;
		this.bestellnummer = bestellnummer;
		this.name = name;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.bildablage = bildablage;
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
	 * @return the bildablage
	 */
	public Set<Bildablage> getBildablage() {
		return bildablage;
	}

	/**
	 * @param bildablage
	 *            the bildablage to set
	 */
	public void setBildablage(Set<Bildablage> bildablage) {
		this.bildablage = bildablage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zubehoer [id=" + id + ", bestellnummer=" + bestellnummer + ", name=" + name + ", beschreibung="
				+ beschreibung + ", preis=" + preis + ", bild=" + bildablage + "]";
	}

}
