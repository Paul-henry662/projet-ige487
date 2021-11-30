package meca.accesAuxDonnees;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Prevision_mod(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V");
		this.stmtFindByCode = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE prevision_code = ?");
		this.stmtFindByDate = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE prevision_date = ?");
		this.stmtFindByEffectif = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE effectif = ?");
		this.stmtFindByUnite = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE unite = ?");
		this.stmtFindByActivite = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE type_activite = ?");
		this.stmtFindByQuantite = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE quantite = ?");
		this.stmtFindByDebut = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE periode_debut = ?");
		this.stmtFindByFin = cx.getConnection().prepareStatement("SELECT * FROM Prevision_V WHERE periode_fin = ?");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param previsionCode
	 * @throws SQLException 
	 */
	public boolean existe(String previsionCode) throws SQLException {
		stmtFindByCode.setString(1, previsionCode);
		ResultSet result = stmtFindByCode.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}

	public List<TuplePrevision> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param previsionCode
	 * @throws SQLException 
	 */
	public TuplePrevision findByCode(String previsionCode) throws SQLException {
		stmtFindByCode.setString(1, previsionCode);
		
		ResultSet result = stmtFindByCode.executeQuery();

		TuplePrevision prevision = new TuplePrevision();
		
		prevision.setPrevisionCode(result.getString(1));
		prevision.setPrevisionDate(result.getDate(2));
		prevision.setEffectif(result.getString(3));
		prevision.setUnite(result.getString(4));
		prevision.setTypeActivite(result.getString(5));
		prevision.setQuantite(result.getDouble(6));
		prevision.setPeriodeDebut(result.getDate(7));
		prevision.setPeriodeFin(result.getDate(8));
		
		return prevision;
	}

	/**
	 * 
	 * @param previsionDate
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByDate(Date previsionDate) throws SQLException {
		stmtFindByDate.setDate(1, previsionDate);
		
		ResultSet result = stmtFindByDate.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param effectif
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByEffectif(String effectif) throws SQLException {
		stmtFindByEffectif.setString(1, effectif);
		
		ResultSet result = stmtFindByEffectif.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param unite
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByUnite(String unite) throws SQLException {
		stmtFindByUnite.setString(1, unite);
		
		ResultSet result = stmtFindByUnite.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param typeActivite
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByActivite(String typeActivite) throws SQLException {
		stmtFindByActivite.setString(1, typeActivite);
		
		ResultSet result = stmtFindByActivite.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param quantite
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByQuantite(double quantite) throws SQLException {
		stmtFindByQuantite.setDouble(1, quantite);
		
		ResultSet result = stmtFindByQuantite.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param periodeDebut
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByDebut(Date periodeDebut) throws SQLException {
		stmtFindByDebut.setDate(1, periodeDebut);
		
		ResultSet result = stmtFindByDebut.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
	}

	/**
	 * 
	 * @param periodeFin
	 * @throws SQLException 
	 */
	public List<TuplePrevision> findByFin(Date periodeFin) throws SQLException {
		stmtFindByFin.setDate(1, periodeFin);
		
		ResultSet result = stmtFindByFin.executeQuery();
		List<TuplePrevision> previsions = new ArrayList<TuplePrevision>();
		
		while(result.next()) {
			TuplePrevision prevision = new TuplePrevision();
			prevision.setPrevisionCode(result.getString(1));
			prevision.setPrevisionDate(result.getDate(2));
			prevision.setEffectif(result.getString(3));
			prevision.setUnite(result.getString(4));
			prevision.setTypeActivite(result.getString(5));
			prevision.setQuantite(result.getDouble(6));
			prevision.setPeriodeDebut(result.getDate(7));
			prevision.setPeriodeFin(result.getDate(8));
			
			previsions.add(prevision);
		}
		
		return previsions;
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
	 * @throws SQLException 
	 */
	public void modifierPrevision(String previsionCodeOld, String previsionCodeNew, Date previsionDate, String effectif, String unite, String typeActivite, double quantite, Date periodeDebut, Date periodeFin) throws SQLException {
		stmtUpdate.setString(1, previsionCodeOld);
		stmtUpdate.setString(2, previsionCodeNew);
		stmtUpdate.setDate(3, previsionDate);
		stmtUpdate.setString(4, effectif);
		stmtUpdate.setString(5, unite);
		stmtUpdate.setString(6, typeActivite);
		stmtUpdate.setDouble(7, quantite);
		stmtUpdate.setDate(8, periodeDebut);
		stmtUpdate.setDate(9, periodeFin);
		
		stmtUpdate.executeUpdate();
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
	 * @throws SQLException 
	 */
	public void ajouterPrevision(String previsionCode, Date previsionDate, String effectif, String unite, String typeActivite, double quantite, Date periodeDebut, Date periodeFin) throws SQLException {
		stmtUpdate.setString(1, previsionCode);
		stmtUpdate.setDate(2, previsionDate);
		stmtUpdate.setString(3, effectif);
		stmtUpdate.setString(4, unite);
		stmtUpdate.setString(5, typeActivite);
		stmtUpdate.setDouble(6, quantite);
		stmtUpdate.setDate(7, periodeDebut);
		stmtUpdate.setDate(8, periodeFin);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param previsionCode
	 * @throws SQLException 
	 */
	public void supprimerPrevision(String previsionCode) throws SQLException {
		stmtDelete.setString(1, previsionCode);
		
		stmtDelete.executeUpdate();
	}

}