package stihlonlinedb.view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

/**
 * 
 * Eigenschaftsklasse für die Darstellung einer Tabelle
 *
 */
public class StihlTableView {
	SimpleStringProperty name, kettenteilung, beschreibung;
	SimpleDoubleProperty hubraum, ps, kw, gewicht, preis;
	Button btn;
	SimpleIntegerProperty id, schienenlaenge;
	CheckBox cbxVergleich;

	/**
	 * 
	 * @param btn
	 * @param id
	 * @param name
	 * @param hubraum
	 * @param ps
	 * @param gewicht
	 * @param kw
	 * @param kettenteilung
	 * @param schienenlaenge
	 * @param preis
	 */
	public StihlTableView(Button btn, SimpleIntegerProperty id, SimpleStringProperty name, SimpleDoubleProperty hubraum,
			SimpleDoubleProperty ps, SimpleDoubleProperty gewicht, SimpleDoubleProperty kw,
			SimpleStringProperty kettenteilung, SimpleIntegerProperty schienenlaenge, SimpleDoubleProperty preis) {
		this.btn = btn;
		this.id = id;
		this.name = name;
		this.hubraum = hubraum;
		this.ps = ps;
		this.kw = kw;
		this.kettenteilung = kettenteilung;
		this.schienenlaenge = schienenlaenge;
		this.gewicht = gewicht;
		this.preis = preis;
	}

	/**
	 * 
	 * @param cbxVergleich
	 * @param id
	 * @param btn
	 * @param name
	 * @param hubraum
	 * @param ps
	 * @param gewicht
	 * @param preis
	 */
	public StihlTableView(CheckBox cbxVergleich, SimpleIntegerProperty id, Button btn, SimpleStringProperty name,
			SimpleDoubleProperty hubraum, SimpleDoubleProperty ps, SimpleDoubleProperty gewicht,
			SimpleDoubleProperty preis) {
		this.id = id;
		this.btn = btn;
		this.cbxVergleich = cbxVergleich;
		this.name = name;
		this.hubraum = hubraum;
		this.ps = ps;
		this.gewicht = gewicht;
		this.preis = preis;
	}

	/**
	 * 
	 * @param showBtn
	 * @param id
	 * @param name
	 * @param beschreibung
	 */
	public StihlTableView(Button showBtn, SimpleIntegerProperty id, SimpleStringProperty name,
			SimpleStringProperty beschreibung) {
		this.btn = showBtn;
		this.id = id;
		this.name = name;
		this.beschreibung = beschreibung;
	};

	/**
	 * @return the id
	 */
	public int getId() {
		return id.get();
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id.set(id);
	}

	/**
	 * @return the cbxVergleich
	 */
	public CheckBox getCbxVergleich() {
		return cbxVergleich;
	}

	/**
	 * @param cbxVergleich
	 *            the cbxVergleich to set
	 */
	public void setCbxVergleich(CheckBox cbxVergleich) {
		this.cbxVergleich = cbxVergleich;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name.get();
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name.set(name);
	}

	/**
	 * @return the hubraum
	 */
	public double getHubraum() {
		return hubraum.get();
	}

	/**
	 * @param hubraum
	 *            the hubraum to set
	 */
	public void setHubraum(double hubraum) {
		this.hubraum.set(hubraum);
	}

	/**
	 * @return the ps
	 */
	public double getPs() {
		return ps.get();
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setPs(double ps) {
		this.ps.set(ps);
	}

	/**
	 * @return the gewicht
	 */
	public double getGewicht() {
		return gewicht.get();
	}

	/**
	 * @param gewicht
	 *            the gewicht to set
	 */
	public void setGewicht(double gewicht) {
		this.gewicht.set(gewicht);
	}

	/**
	 * @return the preis
	 */
	public double getPreis() {
		return preis.get();
	}

	/**
	 * @param preis
	 *            the preis to set
	 */
	public void setPreis(double preis) {
		this.preis.set(preis);
	}

	/**
	 * @return the btn
	 */
	public Button getBtn() {
		return btn;
	}

	/**
	 * @param btn
	 *            the btn to set
	 */
	public void setBtn(Button btn) {
		this.btn = btn;
	}

	/**
	 * @return the kettenteilung
	 */
	public String getKettenteilung() {
		return kettenteilung.get();
	}

	/**
	 * @param kettenteilung
	 *            the kettenteilung to set
	 */
	public void setKettenteilung(String kettenteilung) {
		this.kettenteilung.set(kettenteilung);
	}

	/**
	 * @return the kw
	 */
	public Double getKw() {
		return kw.get();
	}

	/**
	 * @param kw
	 *            the kw to set
	 */
	public void setKw(Double kw) {
		this.kw.set(kw);
	}

	/**
	 * @return the schienenlaenge
	 */
	public int getSchienenlaenge() {
		return schienenlaenge.get();
	}

	/**
	 * @param schienenlaenge
	 *            the schienenlaenge to set
	 */
	public void setSchienenlaenge(int schienenlaenge) {
		this.schienenlaenge.set(schienenlaenge);
	}

	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return beschreibung.get();
	}

	/**
	 * @param beschreibung
	 *            the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung.set(beschreibung);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StihlTableView [name=" + name + ", kettenteilung=" + kettenteilung + ", beschreibung=" + beschreibung
				+ ", hubraum=" + hubraum + ", ps=" + ps + ", kw=" + kw + ", gewicht=" + gewicht + ", preis=" + preis
				+ ", btn=" + btn + ", id=" + id + ", schienenlaenge=" + schienenlaenge + ", cbxVergleich="
				+ cbxVergleich + "]";
	}

}
