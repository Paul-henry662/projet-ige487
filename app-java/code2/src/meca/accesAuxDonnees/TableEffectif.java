package meca.accesAuxDonnees;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meca.meca.*;

public class TableEffectif {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByMatr;
	private PreparedStatement stmtFindByNom;
	private PreparedStatement stmtFindByPrenom;
	private PreparedStatement stmtFindByDateNaiss;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private Connexion cx;

	/**
	 * 
	 * @param cx
	 * @throws SQLException 
	 */
	public TableEffectif(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Effectif_ins(?, ?, ?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Effectif_ret(?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Effectif_mod(?, ?, ?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Effectif_V");
		this.stmtFindByMatr = cx.getConnection().prepareStatement("SELECT * FROM Effectif_V WHERE eff_matr = ?");
		this.stmtFindByNom = cx.getConnection().prepareStatement("SELECT * FROM Effectif_V WHERE LOWER(nom) = LOWER(?)");
		this.stmtFindByPrenom = cx.getConnection().prepareStatement("SELECT * FROM Effectif_V WHERE LOWER(prenom) = LOWER(?)");
		this.stmtFindByDateNaiss = cx.getConnection().prepareStatement("SELECT * FROM Effectif_V WHERE dateNaissance = ?");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param effMatr
	 * @throws SQLException 
	 */
	public boolean existe(String effMatr) throws SQLException {
		stmtFindByMatr.setString(1, effMatr);
		ResultSet result = stmtFindByMatr.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}

	public List<TupleEffectif> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaiss(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}

	/**
	 * 
	 * @param effMatr
	 * @throws SQLException 
	 */
	public TupleEffectif findByMatr(String effMatr) throws SQLException {
		stmtFindByMatr.setString(1, effMatr);
		ResultSet result = stmtFindByMatr.executeQuery();
		result.next();
		
		TupleEffectif effectif = new TupleEffectif();
		
		effectif.setEffMatr(result.getString(1));
		effectif.setNom(result.getString(2));
		effectif.setPrenom(result.getString(3));
		effectif.setDateNaiss(result.getDate(4));
		result.close();
			
		return effectif;
	}

	/**
	 * 
	 * @param nom
	 * @throws SQLException 
	 */
	public List<TupleEffectif> findByNom(String nom) throws SQLException {
		stmtFindByNom.setString(1, nom);
		ResultSet result = stmtFindByNom.executeQuery();
		
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaiss(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}

	/**
	 * 
	 * @param prenom
	 * @throws SQLException 
	 */
	public List<TupleEffectif> findByPrenom(String prenom) throws SQLException {
		stmtFindByPrenom.setString(1, prenom);
		ResultSet result = stmtFindByPrenom.executeQuery();
		
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaiss(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}

	/**
	 * 
	 * @param dateNaiss
	 * @throws SQLException 
	 */
	public List<TupleEffectif> findByDateNaiss(Date dateNaiss) throws SQLException {
		stmtFindByDateNaiss.setDate(1, dateNaiss);
		ResultSet result = stmtFindByDateNaiss.executeQuery();
		
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaiss(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}

	/**
	 * 
	 * @param effMatrOld
	 * @param effMatrNew
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 * @throws SQLException 
	 */
	public void modifierEffectif(String effMatrOld, String effMatrNew, String nom, String prenom, Date dateNaiss) throws SQLException {
		stmtUpdate.setString(1, effMatrOld);
		stmtUpdate.setString(2, effMatrNew);
		stmtUpdate.setString(3, nom);
		stmtUpdate.setString(4, prenom);
		stmtUpdate.setDate(5, dateNaiss);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param effMatr
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 * @throws SQLException 
	 */
	public void ajouterEffectif(String effMatr, String nom, String prenom, Date dateNaiss) throws SQLException {
		stmtInsert.setString(1, effMatr);
		stmtInsert.setString(2, nom);
		stmtInsert.setString(3, prenom);
		stmtInsert.setDate(4, dateNaiss);
		
		stmtInsert.executeUpdate();
	}

	/**
	 * 
	 * @param effMatr
	 * @throws SQLException 
	 */
	public void supprimerEffectif(String effMatr) throws SQLException {
		stmtDelete.setString(1, effMatr);
		
		stmtDelete.executeUpdate();
	}

}