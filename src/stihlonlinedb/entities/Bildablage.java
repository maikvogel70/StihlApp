package stihlonlinedb.entities;

public class Bildablage {
	private int id;
	private String pfad;

	public Bildablage(int id, String pfad) {
		super();
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

}
