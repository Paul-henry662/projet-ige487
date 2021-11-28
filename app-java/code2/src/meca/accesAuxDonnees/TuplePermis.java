package meca.accesAuxDonnees;

public class TuplePermis {

	private String permisCode;
	private String effectif;
	private Date valideDebut;
	private Date valideFin;

	public TuplePermis() {
		// TODO - implement TuplePermis.TuplePermis
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 */
	public TuplePermis(String permisCode, String effectif, String valideDebut, String valideFin) {
		// TODO - implement TuplePermis.TuplePermis
		throw new UnsupportedOperationException();
	}

	public String getPermisCode() {
		return this.permisCode;
	}

	/**
	 * 
	 * @param permisCode
	 */
	public void setPermisCode(String permisCode) {
		this.permisCode = permisCode;
	}

	public String getEffectif() {
		return this.effectif;
	}

	/**
	 * 
	 * @param effectif
	 */
	public void setEffectif(String effectif) {
		this.effectif = effectif;
	}

	public Date getValideDebut() {
		return this.valideDebut;
	}

	/**
	 * 
	 * @param valideDebut
	 */
	public void setValideDebut(Date valideDebut) {
		this.valideDebut = valideDebut;
	}

	public Date getValideFin() {
		return this.valideFin;
	}

	/**
	 * 
	 * @param valideFin
	 */
	public void setValideFin(Date valideFin) {
		this.valideFin = valideFin;
	}

}