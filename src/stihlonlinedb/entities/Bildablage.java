package stihlonlinedb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BILDABLAGE")
public class Bildablage implements Serializable {

	@Id
	@GeneratedValue
	@Column
	private long id;
	@Column
	private String pfad;

	@OneToMany
	private Set<Bildablage> bildablage = new HashSet<>();

	public Bildablage() {
	}

	public Bildablage(long id, String pfad, Set<Bildablage> bildablage) {
		super();
		this.id = id;
		this.pfad = pfad;
		this.bildablage = bildablage;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
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

}
