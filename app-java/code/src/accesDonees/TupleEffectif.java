package accesDonees;

import java.sql.Date;

public class TupleEffectif {
	private String effMatr;
	private String nom;
	private String prenom ;
	private Date dateNaissance;
	
	public TupleEffectif() {
	}

	public TupleEffectif(String effMatr, String nom, String prenom, Date dateNaissance) {
		this.effMatr = effMatr;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;	
	}
	
	public String getEffMatr() {
		return effMatr;
	}
	public void setEffMatr(String effMatr) {
		this.effMatr = effMatr;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
		return "\nMatricule: "+this.effMatr
				+"\nNom: "+this.nom
				+"\nPrenom: "+this.prenom
				+"\nDate de naissance: "+this.dateNaissance+"\n";
	}
}
