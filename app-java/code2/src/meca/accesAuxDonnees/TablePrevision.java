package meca.accesAuxDonnees;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import meca.meca.*;

public class TablePrevision {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByCode;
	private PreparedStatement stmtFindByDate;
	private PreparedStatement stmtFindByEffectif;
	private PreparedStatement stmtFindByUnite;
	private PreparedStatement stmtFindByActivite;
	private PreparedStatement stmtFindByQuantite;
	private PreparedStatement stmtFindByDebut;
	private PreparedStatement stmtFindByFin;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private Connexion cx;

	/**
	 * 
	 * @param cx
	 * @throws SQLException 
	 */
	public TablePrevision(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Prevision_ins(?, ?, ?, ?, ?, ?, ?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Prevision_ret(?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Prevision_mod(?, ?, ?, ?, ?, ?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V");
		this.stmtFindByCode = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE prevision_code = ?");
		this.stmtFindByDate = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE prevision_date = ?");
		this.stmtFindByEffectif = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE LOWER(prenom) = LOWER(?)");
		this.stmtFindByUnite = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE dateNaissance = ?");
		this.stmtFindByActivite = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE dateNaissance = ?");
		this.stmtFindByQuantite = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE dateNaissance = ?");
		this.stmtFindByDebut = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE dateNaissance = ?");
		this.stmtFindByFin = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE dateNaissance = ?");
	}

	public Connexion getConnection() {
		// TODO - implement TablePrevision.getConnection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 */
	public boolean existe(String previsionCode) {
		// TODO - implement TablePrevision.existe
		throw new UnsupportedOperationException();
	}

	public List<TuplePrevision> findAll() {
		// TODO - implement TablePrevision.findAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 */
	public TuplePrevision findByCode(String previsionCode) {
		// TODO - implement TablePrevision.findByCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionDate
	 */
	public List<TuplePrevision> findByDate(Date previsionDate) {
		// TODO - implement TablePrevision.findByDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effectif
	 */
	public List<TuplePrevision> findByEffectif(String effectif) {
		// TODO - implement TablePrevision.findByEffectif
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param unite
	 */
	public List<TuplePrevision> findByUnite(String unite) {
		// TODO - implement TablePrevision.findByUnite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param typeActivite
	 */
	public List<TuplePrevision> findByActivite(String typeActivite) {
		// TODO - implement TablePrevision.findByActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param quantite
	 */
	public List<TuplePrevision> findByQuantite(double quantite) {
		// TODO - implement TablePrevision.findByQuantite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodeDebut
	 */
	public List<TuplePrevision> findByDebut(Date periodeDebut) {
		// TODO - implement TablePrevision.findByDebut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionDate
	 */
	public List<TuplePrevision> findByFin(Date previsionDate) {
		// TODO - implement TablePrevision.findByFin
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
	public void modifierPrevision(String previsionCodeOld, String previsionCodeNew, Date previsionDate, String effectif, String unite, String typeActivite, double quantite, Date periodeDebut, Date periodeFin) {
		// TODO - implement TablePrevision.modifierPrevision
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
	public void ajouterPrevision(String previsionCode, Date previsionDate, String effectif, String unite, String typeActivite, double quantite, Date periodeDebut, Date periodeFin) {
		// TODO - implement TablePrevision.ajouterPrevision
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 */
	public void supprimerPrevision(String previsionCode) {
		// TODO - implement TablePrevision.supprimerPrevision
		throw new UnsupportedOperationException();
	}

}