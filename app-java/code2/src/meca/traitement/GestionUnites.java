package meca.traitement;

import meca.meca.*;

import java.sql.SQLException;
import java.util.List;

import meca.accesAuxDonnees.*;

public class GestionUnites {

	private Connexion cx;
	private TableUnite unites;
	private TableSorg sorgs;

	/**
	 * 
	 * @param unites
	 * @param sorgs
	 */
	public GestionUnites(TableUnite unites, TableSorg sorgs) {
		this.unites = unites;
		this.sorgs = sorgs;
		
		this.cx = unites.getConnection();
	}

	public List<TupleUnite> listerUnites() throws SQLException {
		return this.unites.findAll();
	}

	public List<TupleSorg> listerSorgs() throws SQLException {
		return this.sorgs.findAll();
	}

	/**
	 * 
	 * @param uniteCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public TupleUnite rechercherUniteByCode(String uniteCode) throws MecaException, SQLException {
		if(this.unites.existeCode(uniteCode))
			return this.unites.findByCode(uniteCode);
		else
			throw new MecaException("Ce code n'est pas enregistr�");
	}

	/**
	 * 
	 * @param uniteNom
	 * @throws SQLException 
	 * @throws MecaException 
	 */
	public TupleUnite rechercherUniteByNom(String uniteNom) throws SQLException, MecaException {
		if(this.unites.existeNom(uniteNom))
			return this.unites.findByNom(uniteNom);
		else
			throw new MecaException("Ce nom n'est pas enregistr�");
	}

	/**
	 * 
	 * @param unite
	 * @throws SQLException 
	 */
	public List<TupleSorg> rechercherSorgByUnite(String unite) throws SQLException {
		return this.sorgs.findByUnite(unite);
	}

	/**
	 * 
	 * @param superUnite
	 * @throws SQLException 
	 */
	public List<TupleSorg> rechercherSorgBySuperUnite(String superUnite) throws SQLException {
		return this.sorgs.findBySuperUnite(superUnite);
	}

	/**
	 * 
	 * @param uniteCodeOld
	 * @param uniteCodeNew
	 * @param uniteNom
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void modifierUnite(String uniteCodeOld, String uniteCodeNew, String uniteNom) throws MecaException, SQLException {
		if(uniteCodeNew.length() == 0 || uniteNom.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!uniteCodeNew.equals(uniteCodeOld)) {
			if(!unites.existeCode(uniteCodeNew)) {
				this.unites.modifierUnite(uniteCodeOld, uniteCodeNew, uniteNom);
				cx.commit();
			}else {
				cx.rollback();
				throw new MecaException("Le nouveau code d'unit� est d�j� enregistr�");
			}
		}

	}

	/**
	 * 
	 * @param uniteOld
	 * @param superUniteOld
	 * @param uniteNew
	 * @param superUniteNew
	 * @throws SQLException 
	 * @throws MecaException 
	 */
	public void modifierSorg(String uniteOld, String superUniteOld, String uniteNew, String superUniteNew) throws SQLException, MecaException {
		if(uniteNew.length() == 0 || superUniteNew.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!sorgs.existe(uniteNew, superUniteNew)) {
			this.sorgs.modifierSorg(uniteOld, superUniteOld, uniteNew, superUniteNew);
			cx.commit();
		}else {
			cx.rollback();
			throw new MecaException("Cette structure organisationnelle est d�j� enregistr�e");
		}

	}

	/**
	 * 
	 * @param uniteCode
	 * @param uniteNom
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterUnite(String uniteCode, String uniteNom) throws MecaException, SQLException {
		if(uniteCode.length() == 0 || uniteNom.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(this.unites.existeCode(uniteCode) || this.unites.existeNom(uniteNom)) {
			cx.rollback();
			throw new MecaException("Le code et/ou le matricule est d�j� enregistr�");
		}
		else {
			this.unites.ajouterUnite(uniteCode, uniteNom);
			cx.commit();
		}
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterSorg(String unite, String superUnite) throws MecaException, SQLException {
		if(unite.length() == 0 || superUnite.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!this.sorgs.existe(unite, superUnite)) {
			this.sorgs.ajouterSorg(unite, superUnite);
			cx.commit();
		}
		else {
			cx.rollback();
			throw new MecaException("Cette structure organisationnelle est d�j� enregistr�e");
		}
	}

	/**
	 * 
	 * @param uniteCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerUnite(String uniteCode) throws MecaException, SQLException {
		if(uniteCode.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!this.unites.existeCode(uniteCode)) {
			this.unites.supprimerUnite(uniteCode);
			cx.commit();
		}
		else {
			cx.rollback();
			throw new MecaException("Ce code n'est pas enregistr�");
		}
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerSorg(String unite, String superUnite) throws MecaException, SQLException {
		if(unite.length() == 0 || superUnite.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(this.sorgs.existe(unite, superUnite)) {
			this.sorgs.supprimerSorg(unite, superUnite);
			cx.commit();
		}
		else {
			cx.rollback();
			throw new MecaException("Cette structure organisationnelle n'est pas enregistr�e");
		}
	}

}