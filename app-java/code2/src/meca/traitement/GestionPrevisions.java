package meca.traitement;

import meca.meca.*;

import java.util.List;

import meca.accesAuxDonnees.*;

public class GestionPrevisions {

	private Connexion cx;
	private TablePrevision previsions;

	/**
	 * 
	 * @param previsions
	 */
	public GestionPrevisions(TablePrevision previsions) {
		// TODO - implement GestionPrevisions.GestionPrevisions
		throw new UnsupportedOperationException();
	}

	public List<TuplePrevision> listerPrevisions() {
		// TODO - implement GestionPrevisions.listerPrevisions
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 */
	public TuplePrevision rechercherByCode(String previsionCode) {
		// TODO - implement GestionPrevisions.rechercherByCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionDate
	 */
	public List<TuplePrevision> rechercherByDate(String previsionDate) {
		// TODO - implement GestionPrevisions.rechercherByDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effectif
	 */
	public List<TuplePrevision> rechercherByEffectif(String effectif) {
		// TODO - implement GestionPrevisions.rechercherByEffectif
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effectif
	 */
	public List<TuplePrevision> rechercherByUnite(String effectif) {
		// TODO - implement GestionPrevisions.rechercherByUnite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param typeActivite
	 */
	public List<TuplePrevision> rechercherByActivite(String typeActivite) {
		// TODO - implement GestionPrevisions.rechercherByActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param quantite
	 */
	public List<TuplePrevision> rechercherByQuantite(double quantite) {
		// TODO - implement GestionPrevisions.rechercherByQuantite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodeDebut
	 */
	public List<TuplePrevision> rechercherByDebut(String periodeDebut) {
		// TODO - implement GestionPrevisions.rechercherByDebut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodeFin
	 */
	public List<TuplePrevision> rechercherByFin(String periodeFin) {
		// TODO - implement GestionPrevisions.rechercherByFin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCodeOld
	 * @param previsionCodeNew
	 * @param previsionDate
	 * @param effectif
	 * @param unite
	 * @param typeActivite
	 * @param quantite
	 * @param periodeDebut
	 * @param periodeFin
	 */
	public void modifierPrevision(String previsionCodeOld, String previsionCodeNew, String previsionDate, String effectif, String unite, String typeActivite, double quantite, String periodeDebut, String periodeFin) {
		// TODO - implement GestionPrevisions.modifierPrevision
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 * @param previsionDate
	 * @param effectif
	 * @param unite
	 * @param typeActivite
	 * @param quantite
	 * @param periodeDebut
	 * @param periodeFin
	 */
	public void ajouterPrevision(String previsionCode, String previsionDate, String effectif, String unite, String typeActivite, double quantite, String periodeDebut, String periodeFin) {
		// TODO - implement GestionPrevisions.ajouterPrevision
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 */
	public void supprimerPrevision(String previsionCode) {
		// TODO - implement GestionPrevisions.supprimerPrevision
		throw new UnsupportedOperationException();
	}

}