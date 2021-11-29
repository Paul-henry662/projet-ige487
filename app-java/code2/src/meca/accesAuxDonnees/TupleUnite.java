package meca.accesAuxDonnees;

public class TupleUnite {

	private String uniteCode;
	private String uniteNom;

	public TupleUnite() {
	}

	public TupleUnite(String uniteCode, String uniteNom) {
		this.uniteCode = uniteCode;
		this.uniteNom = uniteNom;
	}

	
	public String getUniteCode() {
		return this.uniteCode;
	}

	/**
	 * 
	 * @param uniteCode
	 */
	public void setUniteCode(String uniteCode) {
		this.uniteCode = uniteCode;
	}

	public String getUniteNom() {
		return this.uniteNom;
	}

	/**
	 * 
	 * @param uniteNom
	 */
	public void setUniteNom(String uniteNom) {
		this.uniteNom = uniteNom;
	}

}