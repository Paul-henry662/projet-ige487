package meca.accesAuxDonnees;

public class TupleSorg {

	private String uniteCode;
	private String uniteNom;
	private String superUniteCode;
	private String superUniteNom;
	
	public TupleSorg(String uniteCode, String uniteNom, String superUniteCode, String superUniteNom) {
		this.uniteCode = uniteCode;
		this.uniteNom = uniteNom;
		this.superUniteCode = superUniteCode;
		this.superUniteNom = superUniteNom;
	}

	public TupleSorg() {
	}

	public String getUniteCode() {
		return uniteCode;
	}

	public void setUniteCode(String uniteCode) {
		this.uniteCode = uniteCode;
	}

	public String getUniteNom() {
		return uniteNom;
	}

	public void setUniteNom(String uniteNom) {
		this.uniteNom = uniteNom;
	}

	public String getSuperUniteCode() {
		return superUniteCode;
	}

	public void setSuperUniteCode(String superUniteCode) {
		this.superUniteCode = superUniteCode;
	}

	public String getSuperUniteNom() {
		return superUniteNom;
	}

	public void setSuperUniteNom(String superUniteNom) {
		this.superUniteNom = superUniteNom;
	}


}