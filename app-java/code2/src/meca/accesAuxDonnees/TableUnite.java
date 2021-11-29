package meca.accesAuxDonnees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meca.meca.*;

public class TableUnite {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByCode;
	private PreparedStatement stmtFindByNom;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private Connexion cx;

	/**
	 * 
	 * @param cx
	 * @throws SQLException 
	 */
	public TableUnite(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Unite_ins(?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Unite_ret(?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Unite_mod(?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Unite_V");
		this.stmtFindByCode = cx.getConnection().prepareStatement("SELECT * FROM Unite_V WHERE unite_code = ?");
		this.stmtFindByNom = cx.getConnection().prepareStatement("SELECT * FROM Unite_V WHERE LOWER(unite_nom) = LOWER(?)");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param uniteCode
	 * @throws SQLException 
	 */
	public boolean existeCode(String uniteCode) throws SQLException {
		stmtFindByCode.setString(1, uniteCode);
		ResultSet result = stmtFindByCode.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}
	
	/**
	 * 
	 * @param uniteCode
	 * @throws SQLException 
	 */
	public boolean existeNom(String uniteNom) throws SQLException {
		stmtFindByNom.setString(1, uniteNom);
		ResultSet result = stmtFindByCode.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}
	
	public List<TupleUnite> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		
		List<TupleUnite> unites = new ArrayList<TupleUnite>();
		
		while(result.next()) {
			TupleUnite unite = new TupleUnite();
			unite.setUniteCode(result.getString(1));
			unite.setUniteNom(result.getString(2));
			
			unites.add(unite);
		}
		
		return unites;
	}

	/**
	 * 
	 * @param uniteCode
	 * @throws SQLException 
	 */
	public TupleUnite findByCode(String uniteCode) throws SQLException {
		stmtFindByCode.setString(1, uniteCode);
		ResultSet result = stmtFindByCode.executeQuery();
		result.next();
		
		TupleUnite unite = new TupleUnite();
		
		unite.setUniteCode(result.getString(1));
		unite.setUniteNom(result.getString(2));

		result.close();
			
		return unite;
	}

	/**
	 * 
	 * @param uniteNom
	 */
	public TupleUnite findByNom(String uniteNom) throws SQLException {
		stmtFindByNom.setString(1, uniteNom);
		
		ResultSet result = stmtFindByNom.executeQuery();
		result.next();
		
		TupleUnite unite = new TupleUnite();
		
		unite.setUniteCode(result.getString(1));
		unite.setUniteNom(result.getString(2));

		result.close();
			
		return unite;
	}

	/**
	 * 
	 * @param uniteCodeOld
	 * @param uniteCodeNew
	 * @param uniteNom
	 * @throws SQLException 
	 */
	public void modifierUnite(String uniteCodeOld, String uniteCodeNew, String uniteNom) throws SQLException {
		stmtUpdate.setString(1, uniteCodeOld);
		stmtUpdate.setString(2, uniteCodeNew);
		stmtUpdate.setString(3, uniteNom);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param uniteCode
	 * @param uniteNom
	 * @throws SQLException 
	 */
	public void ajouterUnite(String uniteCode, String uniteNom) throws SQLException {
		stmtInsert.setString(1, uniteCode);
		stmtInsert.setString(2, uniteNom);
		
		stmtInsert.executeUpdate();
	}

	/**
	 * 
	 * @param uniteCode
	 * @throws SQLException 
	 */
	public void supprimerUnite(String uniteCode) throws SQLException {
		stmtDelete.setString(1, uniteCode);
		
		stmtDelete.executeUpdate();
	}

}