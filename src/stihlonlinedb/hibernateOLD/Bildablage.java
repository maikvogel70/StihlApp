package stihlonlinedb.hibernateOLD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BILDABLAGE")
public class Bildablage implements Serializable {

	private static final long serialVersionUID = 8004534648974848525L;
	private int bild_ID;
	@Column
	private String pfad;

	public Bildablage() {
	}

	public Bildablage(int id, String pfad) {
		super();
		this.bild_ID = id;
		this.pfad = pfad;
	}

	/**
	 * @return the id
	 */
	public int getBild_ID() {
		return bild_ID;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setBild_ID(int id) {
		this.bild_ID = id;
	}

	/**
	 * @return the pfad
	 */
	public String getPfad() {
		return pfad;
	}

	/**
	 * @param pfad
	 *            the pfad to set
	 */
	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bildablage [id=" + bild_ID + ", pfad=" + pfad + "]";
	}

}
