package stihlonlinedb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EINSATZZWECK")
public class Einsatzzweck {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	private String name;

	@OneToOne
	@JoinColumn(name = "FK_BILD")
	private Bildablage bild;

	public Einsatzzweck() {
	}

	public Einsatzzweck(int id, String name, Bildablage bild) {
		super();
		this.id = id;
		this.name = name;
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
		return "Einsatzzweck [id=" + id + ", name=" + name + ", bild=" + bild.getPfad() + "]";
	}

}
