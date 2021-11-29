package meca.accesAuxDonnees;

public class TupleSorg {

	private String unite;
	private String superUnite;

	public TupleSorg() {
	}


	public TupleSorg(String unite, String superUnite) {
		this.unite = unite;
		this.superUnite = superUnite;
	}


	public String getUnite() {
		return this.unite;
	}

	/**
	 * 
	 * @param unite
	 */
	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getSuperUnite() {
		return this.superUnite;
	}

	/**
	 * 
	 * @param superUnite
	 */
	public void setSuperUnite(String superUnite) {
		this.superUnite = superUnite;
	}

}