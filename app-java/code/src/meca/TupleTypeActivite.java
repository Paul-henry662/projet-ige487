package meca;

public class TupleTypeActivite {
	private String type;
	private String nom;
	private String description;
	private Boolean actif;
	
	
	public TupleTypeActivite() {
	}
	
	public TupleTypeActivite(String type, String nom, String description, Boolean actif) {
		this.type = type;
		this.nom = nom;
		this.description = description;
		this.actif = actif;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
}
