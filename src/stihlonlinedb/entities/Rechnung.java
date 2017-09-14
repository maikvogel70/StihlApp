package stihlonlinedb.entities;

import java.util.Date;

public class Rechnung {
	private int id;
	private Date datum;

	public Rechnung(int id, Date datum) {
		super();
		this.id = id;
		this.datum = datum;
	}

	/**
	 * @return the datum
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * @param datum
	 *            the datum to set
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
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

}
