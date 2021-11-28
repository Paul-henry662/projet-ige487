package meca.accesAuxDonnees;

public class TupleTypeActivite {

	private String type;
	private String nom;
	private String description;
	private boolean actif;

	public TupleTypeActivite() {
		// TODO - implement TupleTypeActivite.TupleTypeActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param nom
	 * @param description
	 * @param actif
	 */
	public TupleTypeActivite(String type, String nom, String description, boolean actif) {
		// TODO - implement TupleTypeActivite.TupleTypeActivite
		throw new UnsupportedOperationException();
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getActif() {
		return this.actif;
	}

	/**
	 * 
	 * @param actif
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}

}