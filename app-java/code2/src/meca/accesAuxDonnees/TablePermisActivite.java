package meca.accesAuxDonnees;

import meca.meca.*;

public class TablePermisActivite {
	private PreparedStatement stmtFind;
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByPermis;
	private PreparedStatement stmtFindByActivite;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private Connexion cx;

	/**
	 * 
	 * @param cx
	 */
	public TablePermisActivite(Connexion cx) {
		// TODO - implement TablePermisActivite.TablePermisActivite
		throw new UnsupportedOperationException();
	}

	public Connexion getConnection() {
		// TODO - implement TablePermisActivite.getConnection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 */
	public boolean existe(String permisCode, String typeActivite) {
		// TODO - implement TablePermisActivite.existe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 */
	public TuplePermisActivite find(String permisCode, String typeActivite) {
		// TODO - implement TablePermisActivite.find
		throw new UnsupportedOperationException();
	}

	public List<TuplePermisActivite> findAll() {
		// TODO - implement TablePermisActivite.findAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 */
	public List<TuplePermisActivite> findByPermis(String permisCode) {
		// TODO - implement TablePermisActivite.findByPermis
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public List<TuplePermisActivite> findByActivite(String type) {
		// TODO - implement TablePermisActivite.findByActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCodeOld
	 * @param typeActiviteOld
	 * @param permisCodeNew
	 * @param typeActiviteNew
	 */
	public void modifierPermisActivite(String permisCodeOld, String typeActiviteOld, String permisCodeNew, String typeActiviteNew) {
		// TODO - implement TablePermisActivite.modifierPermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 */
	public void ajouterPermisActivite(String permisCode, String typeActivite) {
		// TODO - implement TablePermisActivite.ajouterPermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 */
	public void supprimerPermisActivite(String permisCode, String typeActivite) {
		// TODO - implement TablePermisActivite.supprimerPermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cx
	 */
	public TablePermisActivite(Connexion cx) {
		// TODO - implement TablePermisActivite.TablePermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cx
	 */
	public TablePermisActivite(Connexion cx) {
		// TODO - implement TablePermisActivite.TablePermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cx
	 */
	public TablePermisActivite(Connexion cx) {
		// TODO - implement TablePermisActivite.TablePermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cx
	 */
	public TablePermisActivite(Connexion cx) {
		// TODO - implement TablePermisActivite.TablePermisActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cx
	 */
	public TablePermisActivite(Connexion cx) {
		// TODO - implement TablePermisActivite.TablePermisActivite
		throw new UnsupportedOperationException();
	}

}