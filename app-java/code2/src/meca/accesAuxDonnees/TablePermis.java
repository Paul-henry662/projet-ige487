package meca.accesAuxDonnees;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import meca.meca.*;

public class TablePermis {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindByCode;
	private PreparedStatement stmtFindByEffectif;
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
	public TablePermis(Connexion cx) throws SQLException {
		this.cx = cx;
		
		this.stmtInsert = cx.getConnection().prepareStatement("CALL Permis_ins(?, ?, ?, ?)");
		this.stmtDelete = cx.getConnection().prepareStatement("CALL Permis_ret(?)");
		this.stmtUpdate = cx.getConnection().prepareStatement("CALL Permis_mod(?, ?, ?, ?, ?)");
		this.stmtFindAll = cx.getConnection().prepareStatement("SELECT * FROM Permis_V");
		this.stmtFindByCode = cx.getConnection().prepareStatement("SELECT * FROM Permis_V WHERE permis_code = ?");
		this.stmtFindByEffectif = cx.getConnection().prepareStatement("SELECT * FROM Permis_V WHERE effectif = ?");
		this.stmtFindByDebut = cx.getConnection().prepareStatement("SELECT * FROM Permis_V WHERE valideDebut = ?");
		this.stmtFindByFin = cx.getConnection().prepareStatement("SELECT * FROM Permis_V WHERE valideFin = ?");
	}

	public Connexion getConnection() {
		return this.cx;
	}

	/**
	 * 
	 * @param permisCode
	 * @throws SQLException 
	 */
	public boolean existe(String permisCode) throws SQLException {
		stmtFindByCode.setString(1, permisCode);
		ResultSet result = stmtFindByCode.executeQuery();
		boolean existe = result.next();
		result.close();
		
		return existe;
	}

	public List<TuplePermis> findAll() throws SQLException {
		ResultSet result = stmtFindAll.executeQuery();
		List<TuplePermis> permis = new ArrayList<TuplePermis>();
		
		while(result.next()) {
			TuplePermis perm = new TuplePermis();
			perm.setPermisCode(result.getString(1));
			perm.setEffectif(result.getString(2));
			perm.setValideDebut(result.getDate(3));
			perm.setValideFin(result.getDate(4));
			
			permis.add(perm);
		}
		
		return permis;
	}

	public TuplePermis findByCode(String permisCode) throws SQLException {
		stmtFindByCode.setString(1, permisCode);
		ResultSet result = stmtFindByCode.executeQuery();
		result.next();
		
		TuplePermis permis = new TuplePermis();
		
		permis.setPermisCode(result.getString(1));
		permis.setEffectif(result.getString(2));
		permis.setValideDebut(result.getDate(3));
		permis.setValideFin(result.getDate(4));
		result.close();
			
		return permis;
	}

	public List<TuplePermis> findByEffectif(String effMatr) throws SQLException {
		stmtFindByEffectif.setString(1, effMatr);
		ResultSet result = stmtFindByEffectif.executeQuery();
		
		List<TuplePermis> permis = new ArrayList<TuplePermis>();
		
		while(result.next()) {
			TuplePermis perm = new TuplePermis();
			perm.setPermisCode(result.getString(1));
			perm.setEffectif(result.getString(2));
			perm.setValideDebut(result.getDate(3));
			perm.setValideFin(result.getDate(4));
			
			permis.add(perm);
		}
		
		return permis;
	}

	public List<TuplePermis> findByDebut(Date valideDebut) throws SQLException {
		stmtFindByDebut.setDate(1, valideDebut);
		ResultSet result = stmtFindByDebut.executeQuery();
		
		List<TuplePermis> permis = new ArrayList<TuplePermis>();
		
		while(result.next()) {
			TuplePermis perm = new TuplePermis();
			perm.setPermisCode(result.getString(1));
			perm.setEffectif(result.getString(2));
			perm.setValideDebut(result.getDate(3));
			perm.setValideFin(result.getDate(4));
			
			permis.add(perm);
		}
		
		return permis;
	}

	public List<TuplePermis> findByFin(Date valideFin) throws SQLException {
		stmtFindByFin.setDate(1, valideFin);
		ResultSet result = stmtFindByFin.executeQuery();
		
		List<TuplePermis> permis = new ArrayList<TuplePermis>();
		
		while(result.next()) {
			TuplePermis perm = new TuplePermis();
			perm.setPermisCode(result.getString(1));
			perm.setEffectif(result.getString(2));
			perm.setValideDebut(result.getDate(3));
			perm.setValideFin(result.getDate(4));
			
			permis.add(perm);
		}
		
		return permis;
	}

	/**
	 * 
	 * @param permisCodeOld
	 * @param permisCodeNew
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 * @throws SQLException 
	 */
	public void modifierPermis(String permisCodeOld, String permisCodeNew, String effectif, Date valideDebut, Date valideFin) throws SQLException {
		stmtUpdate.setString(1, permisCodeOld);
		stmtUpdate.setString(2, permisCodeNew);
		stmtUpdate.setString(3, effectif);
		stmtUpdate.setDate(4, valideDebut);
		stmtUpdate.setDate(5, valideFin);
		
		stmtUpdate.executeUpdate();
	}

	/**
	 * 
	 * @param permisCode
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 * @throws SQLException 
	 */
	public void ajouterPermis(String permisCode, String effectif, Date valideDebut, Date valideFin) throws SQLException {
		stmtInsert.setString(2, permisCode);
		stmtInsert.setString(3, effectif);
		stmtInsert.setDate(4, valideDebut);
		stmtInsert.setDate(5, valideFin);
		
		stmtInsert.executeUpdate();
	}

	/**
	 * 
	 * @param permisCode
	 * @throws SQLException 
	 */
	public void supprimerPermis(String permisCode) throws SQLException {
		stmtDelete.setString(1, permisCode);
		
		stmtDelete.executeUpdate();
	}

}