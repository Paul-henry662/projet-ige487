package meca.accesAuxDonnees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	 * @throws SQLException 
	 */
	public TableTypeActivite(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Type_activite_ins(?, ?, ?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Type_activite_ret(?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Type_activite_mod(?, ?, ?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Type_activite_V");
		this.stmtFindByType = cx.getConnection().prepareStatement("SELECT * FROM Type_activite_V WHERE type = ?");
		this.stmtFindByNom = cx.getConnection().prepareStatement("SELECT * FROM Type_activite_V WHERE nom = ?");
		this.stmtFindByDescription = cx.getConnection().prepareStatement("SELECT * FROM Type_activite_V WHERE description = ? "
				+ "OR description LIKE '%?%' OR description LIKE '?%' OR description LIKE'%?'");
		this.stmtFindByActif = cx.getConnection().prepareStatement("SELECT * FROM Type_activite_V WHERE actif = ?");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param type
	 * @throws SQLException 
	 */
	public boolean existe(String type) throws SQLException {
		stmtFindByType.setString(1, type);
		ResultSet result = stmtFindByType.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}

	public List<TupleTypeActivite> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		List<TupleTypeActivite> typesActivites = new ArrayList<TupleTypeActivite>();
		
		while(result.next()) {
			TupleTypeActivite typeActivite = new TupleTypeActivite();
			typeActivite.setType(result.getString(1));
			typeActivite.setNom(result.getString(2));
			typeActivite.setDescription(result.getString(3));
			typeActivite.setActif(result.getBoolean(4));
			
			typesActivites.add(typeActivite);
		}
		
		return typesActivites;
	}

	/**
	 * 
	 * @param type
	 * @throws SQLException 
	 */
	public TupleTypeActivite findByType(String type) throws SQLException {
		stmtFindByType.setString(1, type);
		ResultSet result = stmtFindByType.executeQuery();
		result.next();
		
		TupleTypeActivite typeActivite = new TupleTypeActivite();
		
		typeActivite.setType(result.getString(1));
		typeActivite.setNom(result.getString(2));
		typeActivite.setDescription(result.getString(3));
		typeActivite.setActif(result.getBoolean(4));
		result.close();
			
		return typeActivite;
	}

	/**
	 * 
	 * @param nom
	 * @throws SQLException 
	 */
	public TupleTypeActivite findByNom(String nom) throws SQLException {
		stmtFindByNom.setString(1, nom);
		ResultSet result = stmtFindByNom.executeQuery();
		result.next();
		
		TupleTypeActivite typeActivite = new TupleTypeActivite();
		
		typeActivite.setType(result.getString(1));
		typeActivite.setNom(result.getString(2));
		typeActivite.setDescription(result.getString(3));
		typeActivite.setActif(result.getBoolean(4));
		result.close();
			
		return typeActivite;
	}

	/**
	 * 
	 * @param description
	 * @throws SQLException 
	 */
	public List<TupleTypeActivite> findByDescription(String description) throws SQLException {
		stmtFindByDescription.setString(1, description);
		ResultSet result = stmtFindByDescription.executeQuery();
		
		List<TupleTypeActivite> typesActivites = new ArrayList<TupleTypeActivite>();
		
		while(result.next()) {
			TupleTypeActivite typeActivite = new TupleTypeActivite();
			typeActivite.setType(result.getString(1));
			typeActivite.setNom(result.getString(2));
			typeActivite.setDescription(result.getString(3));
			typeActivite.setActif(result.getBoolean(4));
			
			typesActivites.add(typeActivite);
		}
		
		return typesActivites;
	}

	/**
	 * 
	 * @param actif
	 * @throws SQLException 
	 */
	public List<TupleTypeActivite> findByActif(boolean actif) throws SQLException {
		stmtFindByActif.setBoolean(1, actif);
		ResultSet result = stmtFindByDescription.executeQuery();
		
		List<TupleTypeActivite> typesActivites = new ArrayList<TupleTypeActivite>();
		
		while(result.next()) {
			TupleTypeActivite typeActivite = new TupleTypeActivite();
			typeActivite.setType(result.getString(1));
			typeActivite.setNom(result.getString(2));
			typeActivite.setDescription(result.getString(3));
			typeActivite.setActif(result.getBoolean(4));
			
			typesActivites.add(typeActivite);
		}
		
		return typesActivites;
	}

	/**
	 * 
	 * @param typeOld
	 * @param typeNew
	 * @param nom
	 * @param description
	 * @param actif
	 * @throws SQLException 
	 */
	public void modifierTypeActivite(String typeOld, String typeNew, String nom, String description, boolean actif) throws SQLException {
		stmtUpdate.setString(1, typeOld);
		stmtUpdate.setString(2, typeNew);
		stmtUpdate.setString(3, nom);
		stmtUpdate.setString(4, description);
		stmtUpdate.setBoolean(5, actif);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param type
	 * @param nom
	 * @param description
	 * @param actif
	 * @throws SQLException 
	 */
	public void ajouterTypeActivite(String type, String nom, String description, boolean actif) throws SQLException {
		stmtInsert.setString(1, type);
		stmtInsert.setString(2, nom);
		stmtInsert.setString(3, description);
		stmtInsert.setBoolean(4, actif);
		
		stmtInsert.executeUpdate();
	}

	/**
	 * 
	 * @param type
	 * @throws SQLException 
	 */
	public void supprimerTypeActivite(String type) throws SQLException {
		stmtDelete.setString(1, type);
		
		stmtDelete.executeUpdate();
	}

}