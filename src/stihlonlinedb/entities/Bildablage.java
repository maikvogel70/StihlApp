package stihlonlinedb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BILDABLAGE")
public class Bildablage {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	private String pfad;

	public Bildablage() {
	}

	public Bildablage(int id, String pfad) {
		this.id = id;
		this.pfad = pfad;
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
		return "Bildablage [id=" + id + ", pfad=" + pfad + "]";
	}

}
