package meca.accesAuxDonnees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	 * @throws SQLException 
	 */
	public TablePermisActivite(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Permis_activite_ins(?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Permis_activite_ret(?, ?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Permis_activite_mod(?, ?, ?)");
		this.stmtFind = cx.getConnection().prepareStatement("SELECT * FROM Permis_activite_V WHERE permis = ? AND type_activite = ?");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Permis_activite_V");
		this.stmtFindByPermis = cx.getConnection().prepareStatement("SELECT * FROM Permis_activite_V WHERE permis = ?");
		this.stmtFindByActivite = cx.getConnection().prepareStatement("SELECT * FROM Permis_activite_V WHERE type_activite = ?");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 * @throws SQLException 
	 */
	public boolean existe(String permisCode, String typeActivite) throws SQLException {
		stmtFind.setString(1, permisCode);
		stmtFind.setString(2, typeActivite);
		
		ResultSet result = stmtFind.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 * @throws SQLException 
	 */
	public TuplePermisActivite find(String permisCode, String typeActivite) throws SQLException {
		stmtFind.setString(1, permisCode);
		stmtFind.setString(2, typeActivite);
		
		ResultSet result = stmtFind.executeQuery();
		
		TuplePermisActivite permisActivite = new TuplePermisActivite();
		
		permisActivite.setPermisCode(result.getString(1));
		permisActivite.setTypeActivite(result.getString(2));
		permisActivite.setDescription(result.getString(3));
		
		return permisActivite;
	}

	public List<TuplePermisActivite> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		List<TuplePermisActivite> permisActivites = new ArrayList<TuplePermisActivite>();
		
		while(result.next()) {
			TuplePermisActivite permisActivite = new TuplePermisActivite();
			permisActivite.setPermisCode(result.getString(1));
			permisActivite.setTypeActivite(result.getString(2));
			permisActivite.setDescription(result.getString(3));
			
			permisActivites.add(permisActivite);
		}
		
		return permisActivites;
	}

	/**
	 * 
	 * @param permisCode
	 * @throws SQLException 
	 */
	public List<TuplePermisActivite> findByPermis(String permisCode) throws SQLException {
		stmtFindByPermis.setString(1, permisCode);
		
		ResultSet result = stmtFindByPermis.executeQuery();
		List<TuplePermisActivite> permisActivites = new ArrayList<TuplePermisActivite>();
		
		while(result.next()) {
			TuplePermisActivite permisActivite = new TuplePermisActivite();
			permisActivite.setPermisCode(result.getString(1));
			permisActivite.setTypeActivite(result.getString(2));
			permisActivite.setDescription(result.getString(3));
			
			permisActivites.add(permisActivite);
		}
		
		return permisActivites;
	}

	/**
	 * 
	 * @param type
	 * @throws SQLException 
	 */
	public List<TuplePermisActivite> findByActivite(String type) throws SQLException {
		stmtFindByActivite.setString(1, type);
		
		ResultSet result = stmtFindByActivite.executeQuery();
		List<TuplePermisActivite> permisActivites = new ArrayList<TuplePermisActivite>();
		
		while(result.next()) {
			TuplePermisActivite permisActivite = new TuplePermisActivite();
			permisActivite.setPermisCode(result.getString(1));
			permisActivite.setTypeActivite(result.getString(2));
			permisActivite.setDescription(result.getString(3));
			
			permisActivites.add(permisActivite);
		}
		
		return permisActivites;
	}

	/**
	 * 
	 * @param permisCodeOld
	 * @param typeActiviteOld
	 * @param permisCodeNew
	 * @param typeActiviteNew
	 * @throws SQLException 
	 */
	public void modifierPermisActivite(String permisCodeOld, String typeActiviteOld, String permisCodeNew, String typeActiviteNew) throws SQLException {
		stmtUpdate.setString(1, permisCodeOld);
		stmtUpdate.setString(2, typeActiviteOld);
		stmtUpdate.setString(3, permisCodeNew);
		stmtUpdate.setString(4, typeActiviteNew);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 * @throws SQLException 
	 */
	public void ajouterPermisActivite(String permisCode, String typeActivite) throws SQLException {
		stmtInsert.setString(1, permisCode);
		stmtInsert.setString(2, typeActivite);
		
		stmtInsert.executeUpdate();
	}

	/**
	 * 
	 * @param permisCode
	 * @param typeActivite
	 * @throws SQLException 
	 */
	public void supprimerPermisActivite(String permisCode, String typeActivite) throws SQLException {
		stmtDelete.setString(1, permisCode);
		stmtDelete.setString(2, typeActivite);
		
		stmtDelete.executeUpdate();
	}

}