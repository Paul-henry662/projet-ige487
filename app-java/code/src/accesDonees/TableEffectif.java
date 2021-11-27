package accesDonees;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meca.Connexion;

public class TableEffectif {
	private Connexion cx;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByMatr;
	private PreparedStatement stmtFindByNom;
	private PreparedStatement stmtFindByPrenom;
	private PreparedStatement stmtFindByDateNaiss;
	
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
	
	public Connexion getConnexion() {
		return this.cx;
	}
	
	public boolean existe(String effMatr) throws SQLException {
		stmtFindByMatr.setString(1, effMatr);
		ResultSet result = stmtFindByMatr.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}
	
	public void ajouterEffectif(String effMatr, String nom, String prenom, Date dateNaissance) throws SQLException {
		stmtInsert.setString(1, effMatr);
		stmtInsert.setString(2, nom);
		stmtInsert.setString(3, prenom);
		stmtInsert.setDate(4, dateNaissance);
		
		stmtInsert.executeUpdate();
	}
	
	public void supprimerEffectif(String effMatr) throws SQLException {
		stmtDelete.setString(1, effMatr);
		
		stmtDelete.executeUpdate();
	}
	
	public List<TupleEffectif> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaissance(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}
	
	public void modifierEffectif(String effMatrOld, String effMatrNew, String nom, String prenom, Date dateNaissance) throws SQLException {
		stmtUpdate.setString(1, effMatrOld);
		stmtUpdate.setString(2, effMatrNew);
		stmtUpdate.setString(3, nom);
		stmtUpdate.setString(4, prenom);
		stmtUpdate.setDate(5, dateNaissance);
		
		stmtUpdate.executeUpdate();
	}
	
	public TupleEffectif findByMatr(String effMatr) throws SQLException {
		stmtFindByMatr.setString(1, effMatr);
		ResultSet result = stmtFindByMatr.executeQuery();
		result.next();
		
		TupleEffectif effectif = new TupleEffectif();
		
		effectif.setEffMatr(result.getString(1));
		effectif.setNom(result.getString(2));
		effectif.setPrenom(result.getString(3));
		effectif.setDateNaissance(result.getDate(4));
		result.close();
			
		return effectif;
	}
	
	public List<TupleEffectif> findByNom(String nom) throws SQLException{
		stmtFindByNom.setString(1, nom);
		ResultSet result = stmtFindByNom.executeQuery();
		
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaissance(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}
	
	public List<TupleEffectif> findByPrenom(String prenom) throws SQLException{
		stmtFindByPrenom.setString(1, prenom);
		ResultSet result = stmtFindByPrenom.executeQuery();
		
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaissance(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}
	
	public List<TupleEffectif> findByDateNaiss(Date dateNaissance) throws SQLException{
		stmtFindByDateNaiss.setDate(1, dateNaissance);
		ResultSet result = stmtFindByDateNaiss.executeQuery();
		
		List<TupleEffectif> effectifs = new ArrayList<TupleEffectif>();
		
		while(result.next()) {
			TupleEffectif effectif = new TupleEffectif();
			effectif.setEffMatr(result.getString(1));
			effectif.setNom(result.getString(2));
			effectif.setPrenom(result.getString(3));
			effectif.setDateNaissance(result.getDate(4));
			
			effectifs.add(effectif);
		}
		
		return effectifs;
	}
}
