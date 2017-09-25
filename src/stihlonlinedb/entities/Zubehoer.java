package stihlonlinedb.entities;

public class Zubehoer extends SearchClass {

	private int id;
	private String bestellnummer;
	private String name;
	private String beschreibung;
	private double preis;
	private Bildablage bildablage;

	public Zubehoer() {
	}

	public Zubehoer(int id, String bestellnummer, String name, String beschreibung, double preis,
			Bildablage bildablage) {
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
	@Override
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
	@Override
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
	@Override
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
	public Bildablage getBildablage() {
		return bildablage;
	}

	/**
	 * @param bildablage
	 *            the bildablage to set
	 */
	public void setBildablage(Bildablage bildablage) {
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
