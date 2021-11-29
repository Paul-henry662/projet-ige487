package meca.accesAuxDonnees;

import java.sql.Date;

public class TupleEffectif {

	private String effMatr;
	private String nom;
	private String prenom;
	private Date dateNaiss;

	public TupleEffectif() {

	}
	
	public TupleEffectif(String effMatr, String nom, String prenom, Date dateNaiss) {
		this.effMatr = effMatr;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
	}

	/**
	 * 
	 * @param effMatr
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 */
	public TupleEffectif(String effMatr, String nom, String prenom, String dateNaiss) {
		// TODO - implement TupleEffectif.TupleEffectif
		throw new UnsupportedOperationException();
	}

	public String getEffMatr() {
		return this.effMatr;
	}

	/**
	 * 
	 * @param effMatr
	 */
	public void setEffMatr(String effMatr) {
		this.effMatr = effMatr;
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

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return this.dateNaiss;
	}

	/**
	 * 
	 * @param dateNaiss
	 */
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	@Override
	public String toString() {
		return "\nMatricule: "+this.effMatr
				+"\nNom: "+this.nom
				+"\nPrenom: "+this.prenom
				+"\nDate de naissance: "+this.dateNaiss;
	}
}