package meca.accesAuxDonnees;

public class TuplePermisActivite {

	private String permisCode;
	private String typeActivite;
	private String description;

	public TuplePermisActivite() {

	}
	

	public TuplePermisActivite(String permisCode, String typeActivite, String description) {
		this.permisCode = permisCode;
		this.typeActivite = typeActivite;
		this.description = description;
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

	public String getTypeActivite() {
		return this.typeActivite;
	}

	/**
	 * 
	 * @param typeActivite
	 */
	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}