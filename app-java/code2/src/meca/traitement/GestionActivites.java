package meca.traitement;

import meca.meca.*;
import meca.accesAuxDonnees.*;

public class GestionActivites {

	private Connexion cx;
	private TablePermis permis;
	private TableTypeActivite typesActivites;
	private TablePermisActivite permisActivites;

	/**
	 * 
	 * @param permis
	 * @param typesActivites
	 * @param permisActivites
	 */
	public GestionActivites(TablePermis permis, TableTypeActivite typesActivites, TablePermisActivite permisActivites) {
		// TODO - implement GestionActivites.GestionActivites
		throw new UnsupportedOperationException();
	}

	public List<Permis> listerPermis() {
		// TODO - implement GestionActivites.listerPermis
		throw new UnsupportedOperationException();
	}

	public List<TupleTypeActivite> listerTypesActivites() {
		// TODO - implement GestionActivites.listerTypesActivites
		throw new UnsupportedOperationException();
	}

	public List<TuplePermisActivite> listerPermisActivites() {
		// TODO - implement GestionActivites.listerPermisActivites
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 */
	public TuplePermis rechercherPermisByCode(String permisCode) {
		// TODO - implement GestionActivites.rechercherPermisByCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effectif
	 */
	public List<TuplePermis> rechercherPermisByEffectif(String effectif) {
		// TODO - implement GestionActivites.rechercherPermisByEffectif
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param valideDebut
	 */
	public List<TuplePermis> rechercherPermisByDebut(String valideDebut) {
		// TODO - implement GestionActivites.rechercherPermisByDebut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param valideFin
	 */
	public List<TuplePermis> rechercherPermisByFin(String valideFin) {
		// TODO - implement GestionActivites.rechercherPermisByFin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public List<TupleTypeActivite> rechercherTypeActiviteByCode(String type) {
		// TODO - implement GestionActivites.rechercherTypeActiviteByCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public List<TupleTypeActivite> rechercherTypeActiviteByNom(String nom) {
		// TODO - implement GestionActivites.rechercherTypeActiviteByNom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param description
	 */
	public List<TupleTypeActivite> rechercherTypeActiviteByDescription(String description) {
		// TODO - implement GestionActivites.rechercherTypeActiviteByDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param actif
	 */
	public List<TupleTypeActivite> rechercherTypeActiviteByActif(boolean actif) {
		// TODO - implement GestionActivites.rechercherTypeActiviteByActif
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permis
	 * @param typeActivite
	 */
	public List<TuplePermisActivite> rechercherPermisActivite(String permis, String typeActivite) {
		// TODO - implement GestionActivites.rechercherPermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permis
	 */
	public List<TuplePermisActivite> rechercherPermisActiviteByPermis(String permis) {
		// TODO - implement GestionActivites.rechercherPermisActiviteByPermis
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param typeActivite
	 */
	public List<TuplePermisActivite> rechercherPermisActiviteByActivite(String typeActivite) {
		// TODO - implement GestionActivites.rechercherPermisActiviteByActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCodeOld
	 * @param permisCodeNew
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 */
	public void modiferPermis(String permisCodeOld, String permisCodeNew, String effectif, String valideDebut, String valideFin) {
		// TODO - implement GestionActivites.modiferPermis
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param typeOld
	 * @param typeNew
	 * @param nom
	 * @param description
	 * @param actif
	 */
	public void modifierTypeActivite(String typeOld, String typeNew, String nom, String description, boolean actif) {
		// TODO - implement GestionActivites.modifierTypeActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisOld
	 * @param typeActiviteOld
	 * @param permisNew
	 * @param typeActiviteNew
	 */
	public void modifierPermisActivite(String permisOld, String typeActiviteOld, String permisNew, String typeActiviteNew) {
		// TODO - implement GestionActivites.modifierPermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 */
	public void ajouterPermis(String permisCode, String effectif, String valideDebut, String valideFin) {
		// TODO - implement GestionActivites.ajouterPermis
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param nom
	 * @param description
	 * @param actif
	 */
	public void ajouterTypeActivite(String type, String nom, String description, boolean actif) {
		// TODO - implement GestionActivites.ajouterTypeActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permis
	 * @param typeActivite
	 */
	public void ajouterPermisActivite(String permis, String typeActivite) {
		// TODO - implement GestionActivites.ajouterPermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 */
	public void supprimerPermis(String permisCode) {
		// TODO - implement GestionActivites.supprimerPermis
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public void supprimerTypeActivite(String type) {
		// TODO - implement GestionActivites.supprimerTypeActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permis
	 * @param typeActivite
	 */
	public void supprimerPermisActivite(String permis, String typeActivite) {
		// TODO - implement GestionActivites.supprimerPermisActivite
		throw new UnsupportedOperationException();
	}

}