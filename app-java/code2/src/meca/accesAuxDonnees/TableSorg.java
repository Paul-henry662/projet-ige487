package meca.accesAuxDonnees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meca.meca.*;

public class TableSorg {

	private PreparedStatement stmtFind;
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByUnite;
	private PreparedStatement stmtFindBySuperUnite;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtInsert;
	private PreparedStatement stmtDelete;
	private Connexion cx;

	/**
	 * 
	 * @param cx
	 * @throws SQLException 
	 */
	public TableSorg(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Sorg_ins(?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Sorg_ret(?, ?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Sorg_mod(?, ?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Sorg_V");
		this.stmtFind = cx.getConnection().prepareStatement("SELECT * FROM Sorg_V WHERE unite = ? AND super_unite = ?");
		this.stmtFindByUnite = cx.getConnection().prepareStatement("SELECT * FROM Sorg_V WHERE unite = ?");
		this.stmtFindBySuperUnite = cx.getConnection().prepareStatement("SELECT * FROM Unite_V WHERE super_unite = ?");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws SQLException 
	 */
	public boolean existe(String uniteCode, String superUniteCode) throws SQLException {
		stmtFind.setString(1, uniteCode);
		stmtFind.setString(2, superUniteCode);
		
		ResultSet result = stmtFind.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}
	
	
	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws SQLException 
	 */
	public List<TupleSorg> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		
		List<TupleSorg> sorgs = new ArrayList<TupleSorg>();
		
		while(result.next()) {
			TupleSorg sorg = new TupleSorg();
			sorg.setUniteCode(result.getString(1));
			sorg.setUniteNom(result.getString(2));
			sorg.setSuperUniteCode(result.getString(3));
			sorg.setSuperUniteCode(result.getString(4));
			
			sorgs.add(sorg);
		}
		
		return sorgs;
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws SQLException 
	 */
	public TupleSorg find(String unite, String superUnite) throws SQLException {
		stmtFind.setString(1, unite);
		stmtFind.setString(2, superUnite);
		
		ResultSet result = stmtFind.executeQuery();
		result.next();
		
		TupleSorg sorg = new TupleSorg();
		
		sorg.setUniteCode(result.getString(1));
		sorg.setUniteNom(result.getString(2));
		sorg.setSuperUniteCode(result.getString(3));
		sorg.setSuperUniteCode(result.getString(4));

		result.close();
			
		return sorg;
	}

	/**
	 * 
	 * @param unite
	 * @throws SQLException 
	 */
	public List<TupleSorg> findByUnite(String unite) throws SQLException {
		stmtFindByUnite.setString(1, unite);
		ResultSet result = stmtFindByUnite.executeQuery();
		
		List<TupleSorg> sorgs = new ArrayList<TupleSorg>();
		
		while(result.next()) {
			TupleSorg sorg = new TupleSorg();
			sorg.setUniteCode(result.getString(1));
			sorg.setUniteNom(result.getString(2));
			sorg.setSuperUniteCode(result.getString(3));
			sorg.setSuperUniteCode(result.getString(4));
			
			sorgs.add(sorg);
		}
		
		return sorgs;
	}

	/**
	 * 
	 * @param unite
	 * @throws SQLException 
	 */
	public List<TupleSorg> findBySuperUnite(String superUnite) throws SQLException {
		stmtFindBySuperUnite.setString(1, superUnite);
		ResultSet result = stmtFindBySuperUnite.executeQuery();
		
		List<TupleSorg> sorgs = new ArrayList<TupleSorg>();
		
		while(result.next()) {
			TupleSorg sorg = new TupleSorg();
			sorg.setUniteCode(result.getString(1));
			sorg.setUniteNom(result.getString(2));
			sorg.setSuperUniteCode(result.getString(3));
			sorg.setSuperUniteCode(result.getString(4));
			
			sorgs.add(sorg);
		}
		
		return sorgs;
	}

	/**
	 * 
	 * @param uniteOld
	 * @param superUniteOld
	 * @param uniteNew
	 * @param superUniteNew
	 * @throws SQLException 
	 */
	public void modifierSorg(String uniteOld, String superUniteOld, String uniteNew, String superUniteNew) throws SQLException {
		stmtUpdate.setString(1, uniteOld);
		stmtUpdate.setString(2, superUniteOld);
		stmtUpdate.setString(3, uniteNew);
		stmtUpdate.setString(3, superUniteNew);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws SQLException 
	 */
	public void ajouterSorg(String unite, String superUnite) throws SQLException {
		stmtInsert.setString(1, unite);
		stmtInsert.setString(2, superUnite);
		
		stmtInsert.executeUpdate();
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws SQLException 
	 */
	public void supprimerSorg(String unite, String superUnite) throws SQLException {
		stmtDelete.setString(1, unite);
		stmtDelete.setString(1, superUnite);
		
		stmtDelete.executeUpdate();
	}

}