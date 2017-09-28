package stihlonlinedb.entities;

/**
 * Liefert das Bildobjekt mit ID und Pfad
 *
 */
public class Bildablage {

	private int bild_ID;
	private String pfad;

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
		return "Bildablage [bild_ID=" + bild_ID + ", pfad=" + pfad + "]";
	}

}
