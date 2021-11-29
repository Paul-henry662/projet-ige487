package meca.accesAuxDonnees;

import java.sql.PreparedStatement;
import java.util.List;

import meca.meca.*;

public class TableTypeActivite {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByType;
	private PreparedStatement stmtFindByNom;
	private PreparedStatement stmtFindByDescription;
	private PreparedStatement stmtFindByActif;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private Connexion cx;

	/**
	 * 
	 * @param cx
	 */
	public TableTypeActivite(Connexion cx) {
		// TODO - implement TableTypeActivite.TableTypeActivite
		throw new UnsupportedOperationException();
	}

	public Connexion getConnection() {
		// TODO - implement TableTypeActivite.getConnection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public boolean existe(String type) {
		// TODO - implement TableTypeActivite.existe
		throw new UnsupportedOperationException();
	}

	public List<TupleTypeActivite> findAll() {
		// TODO - implement TableTypeActivite.findAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public TupleTypeActivite findByType(String type) {
		// TODO - implement TableTypeActivite.findByType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nom
	 */
	public TupleTypeActivite findByNom(String nom) {
		// TODO - implement TableTypeActivite.findByNom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param description
	 */
	public List<TupleTypeActivite> findByDescription(String description) {
		// TODO - implement TableTypeActivite.findByDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param actif
	 */
	public List<TupleTypeActivite> findByActif(boolean actif) {
		// TODO - implement TableTypeActivite.findByActif
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
		// TODO - implement TableTypeActivite.modifierTypeActivite
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
		// TODO - implement TableTypeActivite.ajouterTypeActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public void supprimerTypeActivite(String type) {
		// TODO - implement TableTypeActivite.supprimerTypeActivite
		throw new UnsupportedOperationException();
	}

}