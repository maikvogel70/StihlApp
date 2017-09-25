package stihlonlinedb.entities;

public class Saege extends SearchClass {
	private int id;
	private int schienenlaenge;
	private String bestellnummer, kettenteilung, name, beschreibung, besonderheiten;
	private double kw, ps, gewicht, hubraum, preis;
	private Bildablage bildablage;
	private Einsatzzweck einsatzzweck;
	private Bestellung bestellung;

	public Saege() {
	}

	public Saege(int id, int schienenlaenge, String bestellnummer, String kettenteilung, String name,
			String beschreibung, String besonderheiten, double kw, double ps, double gewicht, double hubraum,
			double preis, Bildablage bild, Einsatzzweck einsatzzweck, Bestellung bestellung) {
		super();
		this.id = id;
		this.schienenlaenge = schienenlaenge;
		this.bestellnummer = bestellnummer;
		this.kettenteilung = kettenteilung;
		this.name = name;
		this.beschreibung = beschreibung;
		this.besonderheiten = besonderheiten;
		this.kw = kw;
		this.ps = ps;
		this.gewicht = gewicht;
		this.hubraum = hubraum;
		this.preis = preis;
		this.bildablage = bild;
		this.einsatzzweck = einsatzzweck;
		this.bestellung = bestellung;
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
	 * @return the schienenlaenge
	 */
	public int getSchienenlaenge() {
		return schienenlaenge;
	}

	/**
	 * @param schienenlaenge
	 *            the schienenlaenge to set
	 */
	public void setSchienenlaenge(int schienenlaenge) {
		this.schienenlaenge = schienenlaenge;
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
	 * @return the kettenteilung
	 */
	public String getKettenteilung() {
		return kettenteilung;
	}

	/**
	 * @param kettenteilung
	 *            the kettenteilung to set
	 */
	public void setKettenteilung(String kettenteilung) {
		this.kettenteilung = kettenteilung;
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
	 * @return the besonderheiten
	 */
	public String getBesonderheiten() {
		return besonderheiten;
	}

	/**
	 * @param besonderheiten
	 *            the besonderheiten to set
	 */
	public void setBesonderheiten(String besonderheiten) {
		this.besonderheiten = besonderheiten;
	}

	/**
	 * @return the kw
	 */
	public double getKw() {
		return kw;
	}

	/**
	 * @param kw
	 *            the kw to set
	 */
	public void setKw(double kw) {
		this.kw = kw;
	}

	/**
	 * @return the ps
	 */
	public double getPs() {
		return ps;
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setPs(double ps) {
		this.ps = ps;
	}

	/**
	 * @return the gewicht
	 */
	public double getGewicht() {
		return gewicht;
	}

	/**
	 * @param gewicht
	 *            the gewicht to set
	 */
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	/**
	 * @return the hubraum
	 */
	public double getHubraum() {
		return hubraum;
	}

	/**
	 * @param hubraum
	 *            the hubraum to set
	 */
	public void setHubraum(double hubraum) {
		this.hubraum = hubraum;
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
	 * @return the einsatzzweck
	 */
	public Einsatzzweck getEinsatzzweck() {
		return einsatzzweck;
	}

	/**
	 * @param einsatzzweck
	 *            the einsatzzweck to set
	 */
	public void setEinsatzzweck(Einsatzzweck einsatzzweck) {
		this.einsatzzweck = einsatzzweck;
	}

	/**
	 * @return the bestellung
	 */
	public Bestellung getBestellung() {
		return bestellung;
	}

	/**
	 * @param bestellung
	 *            the bestellung to set
	 */
	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
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
		return "Saege [id=" + id + ", schienenlaenge=" + schienenlaenge + ", bestellnummer=" + bestellnummer
				+ ", kettenteilung=" + kettenteilung + ", name=" + name + ", beschreibung=" + beschreibung
				+ ", besonderheiten=" + besonderheiten + ", kw=" + kw + ", ps=" + ps + ", gewicht=" + gewicht
				+ ", hubraum=" + hubraum + ", preis=" + preis + ", bildablage=" + bildablage + ", einsatzzweck="
				+ einsatzzweck + ", bestellung=" + bestellung + "]";
	}

}
