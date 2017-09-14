package stihlonlinedb.entities;

import java.util.Set;

public class Bestellung {
	private int id, menge;
	private String bestellnummer, kettenBestNr;
	private double rabatt, preis;
	private Set<Fuehrungsschienen> fuehrungsschienen;
	private Set<Kunde> kunde;
	private Set<Rechnung> rechnungsnummer;
	private Set<Saege> saege;
	private Set<Ketten> ketten;
	private Set<Zubehoer> zubehoer;

	public Bestellung() {
	}

	public Bestellung(int id, int menge, String bestellnummer, String kettenBestNr, double rabatt, double preis,
			Set<Fuehrungsschienen> fuehrungsschienen, Set<Kunde> kunde, Set<Rechnung> rechnungsnummer, Set<Saege> saege,
			Set<Ketten> ketten, Set<Zubehoer> zubehoer) {
		super();
		this.id = id;
		this.menge = menge;
		this.bestellnummer = bestellnummer;
		this.kettenBestNr = kettenBestNr;
		this.rabatt = rabatt;
		this.preis = preis;
		this.fuehrungsschienen = fuehrungsschienen;
		this.kunde = kunde;
		this.rechnungsnummer = rechnungsnummer;
		this.saege = saege;
		this.ketten = ketten;
		this.zubehoer = zubehoer;
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
	 * @return the menge
	 */
	public int getMenge() {
		return menge;
	}

	/**
	 * @param menge
	 *            the menge to set
	 */
	public void setMenge(int menge) {
		this.menge = menge;
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
	 * @return the kettenBestNr
	 */
	public String getKettenBestNr() {
		return kettenBestNr;
	}

	/**
	 * @param kettenBestNr
	 *            the kettenBestNr to set
	 */
	public void setKettenBestNr(String kettenBestNr) {
		this.kettenBestNr = kettenBestNr;
	}

	/**
	 * @return the rabatt
	 */
	public double getRabatt() {
		return rabatt;
	}

	/**
	 * @param rabatt
	 *            the rabatt to set
	 */
	public void setRabatt(double rabatt) {
		this.rabatt = rabatt;
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
	 * @return the fuehrungsschienen
	 */
	public Set<Fuehrungsschienen> getFuehrungsschienen() {
		return fuehrungsschienen;
	}

	/**
	 * @param fuehrungsschienen
	 *            the fuehrungsschienen to set
	 */
	public void setFuehrungsschienen(Set<Fuehrungsschienen> fuehrungsschienen) {
		this.fuehrungsschienen = fuehrungsschienen;
	}

	/**
	 * @return the kunde
	 */
	public Set<Kunde> getKunde() {
		return kunde;
	}

	/**
	 * @param kunde
	 *            the kunde to set
	 */
	public void setKunde(Set<Kunde> kunde) {
		this.kunde = kunde;
	}

	/**
	 * @return the rechnungsnummer
	 */
	public Set<Rechnung> getRechnungsnummer() {
		return rechnungsnummer;
	}

	/**
	 * @param rechnungsnummer
	 *            the rechnungsnummer to set
	 */
	public void setRechnungsnummer(Set<Rechnung> rechnungsnummer) {
		this.rechnungsnummer = rechnungsnummer;
	}

	/**
	 * @return the saege
	 */
	public Set<Saege> getSaege() {
		return saege;
	}

	/**
	 * @param saege
	 *            the saege to set
	 */
	public void setSaege(Set<Saege> saege) {
		this.saege = saege;
	}

	/**
	 * @return the ketten
	 */
	public Set<Ketten> getKetten() {
		return ketten;
	}

	/**
	 * @param ketten
	 *            the ketten to set
	 */
	public void setKetten(Set<Ketten> ketten) {
		this.ketten = ketten;
	}

	/**
	 * @return the zubehoer
	 */
	public Set<Zubehoer> getZubehoer() {
		return zubehoer;
	}

	/**
	 * @param zubehoer
	 *            the zubehoer to set
	 */
	public void setZubehoer(Set<Zubehoer> zubehoer) {
		this.zubehoer = zubehoer;
	}

}
