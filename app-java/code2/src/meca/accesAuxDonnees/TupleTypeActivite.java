package meca.accesAuxDonnees;

public class TupleTypeActivite {

	private String type;
	private String nom;
	private String description;
	private boolean actif;

	public TupleTypeActivite() {
	}

	public TupleTypeActivite(String type, String nom, String description, boolean actif) {
		super();
		this.type = type;
		this.nom = nom;
		this.description = description;
		this.actif = actif;
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