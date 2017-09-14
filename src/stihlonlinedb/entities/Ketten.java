package stihlonlinedb.entities;

public class Ketten {

	private int id, treibgliedanzahl, laenge;
	private String name, teileBestellnummer, beschreibung, teilung;
	private double preis, treibglieddicke;

	public Ketten(int id, int treibgliedanzahl, int laenge, String name, String teileBestellnummer, String beschreibung,
			String teilung, double preis, double treibglieddicke) {
		super();
		this.id = id;
		this.treibgliedanzahl = treibgliedanzahl;
		this.laenge = laenge;
		this.name = name;
		this.teileBestellnummer = teileBestellnummer;
		this.beschreibung = beschreibung;
		this.teilung = teilung;
		this.preis = preis;
		this.treibglieddicke = treibglieddicke;
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
	 * @return the treibgliedanzahl
	 */
	public int getTreibgliedanzahl() {
		return treibgliedanzahl;
	}

	/**
	 * @param treibgliedanzahl
	 *            the treibgliedanzahl to set
	 */
	public void setTreibgliedanzahl(int treibgliedanzahl) {
		this.treibgliedanzahl = treibgliedanzahl;
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
	 * @return the teileBestellnummer
	 */
	public String getTeileBestellnummer() {
		return teileBestellnummer;
	}

	/**
	 * @param teileBestellnummer
	 *            the teileBestellnummer to set
	 */
	public void setTeileBestellnummer(String teileBestellnummer) {
		this.teileBestellnummer = teileBestellnummer;
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
	 * @return the teilung
	 */
	public String getTeilung() {
		return teilung;
	}

	/**
	 * @param teilung
	 *            the teilung to set
	 */
	public void setTeilung(String teilung) {
		this.teilung = teilung;
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
	 * @return the treibglieddicke
	 */
	public double getTreibglieddicke() {
		return treibglieddicke;
	}

	/**
	 * @param treibglieddicke
	 *            the treibglieddicke to set
	 */
	public void setTreibglieddicke(double treibglieddicke) {
		this.treibglieddicke = treibglieddicke;
	}

}
