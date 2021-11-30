package meca.accesAuxDonnees;

import java.sql.Date;

public class TuplePermis {

	private String permisCode;
	private String effectif;
	private Date valideDebut;
	private Date valideFin;

	public TuplePermis() {

	}


	public TuplePermis(String permisCode, String effectif, Date valideDebut, Date valideFin) {
		this.permisCode = permisCode;
		this.effectif = effectif;
		this.valideDebut = valideDebut;
		this.valideFin = valideFin;
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