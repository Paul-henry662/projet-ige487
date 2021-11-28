package meca.traitement;

import meca.meca.*;
import meca.accesAuxDonnees.*;

public class GestionEffectifs {

	private Connexion cx;
	private TableEffectif effectifs;

	/**
	 * 
	 * @param effectifs
	 */
	public GestionEffectifs(TableEffectif effectifs) {
		// TODO - implement GestionEffectifs.GestionEffectifs
		throw new UnsupportedOperationException();
	}

	public List<TupleEffectif> listerEffectifs() {
		// TODO - implement GestionEffectifs.listerEffectifs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effMatr
	 */
	public TupleEffectif rechercherByMatr(String effMatr) {
		// TODO - implement GestionEffectifs.rechercherByMatr
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public List<TupleEffectif> rechercherByNom(String nom) {
		// TODO - implement GestionEffectifs.rechercherByNom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prenom
	 */
	public List<TupleEffectif> rechercherByPrenom(String prenom) {
		// TODO - implement GestionEffectifs.rechercherByPrenom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dateNaiss
	 */
	public List<TupleEffectif> rechercherByDateNaiss(String dateNaiss) {
		// TODO - implement GestionEffectifs.rechercherByDateNaiss
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effMatrOld
	 * @param effMatrNew
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 */
	public void modifierEffectif(String effMatrOld, String effMatrNew, String nom, String prenom, String dateNaiss) {
		// TODO - implement GestionEffectifs.modifierEffectif
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effMatr
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 */
	public void ajouterEffectif(String effMatr, String nom, String prenom, String dateNaiss) {
		// TODO - implement GestionEffectifs.ajouterEffectif
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effMatr
	 */
	public void supprimerEffectif(String effMatr) {
		// TODO - implement GestionEffectifs.supprimerEffectif
		throw new UnsupportedOperationException();
	}

}