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
			throw new MecaException("Ce code n'est pas enregistré");
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
			throw new MecaException("Ce nom n'est pas enregistré");
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
		if(uniteCodeNew.length() == 0 || uniteNom.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		else
			this.unites.modifierUnite(uniteCodeOld, uniteCodeNew, uniteNom);
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
		if(uniteNew.length() == 0 || superUniteNew.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		else
			this.sorgs.modifierSorg(uniteOld, superUniteOld, uniteNew, superUniteNew);
	}

	/**
	 * 
	 * @param uniteCode
	 * @param uniteNom
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterUnite(String uniteCode, String uniteNom) throws MecaException, SQLException {
		if(uniteCode.length() == 0 || uniteNom.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(this.unites.existeCode(uniteCode) || this.unites.existeNom(uniteNom))
			throw new MecaException("Le code et/ou le matricule est déjà enregistré");
		else
			this.unites.ajouterUnite(uniteCode, uniteNom);
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterSorg(String unite, String superUnite) throws MecaException, SQLException {
		if(unite.length() == 0 || superUnite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(!this.sorgs.existe(unite, superUnite))
			this.sorgs.ajouterSorg(unite, superUnite);
		else
			throw new MecaException("Cette structure organisationnelle est déjà enregistrée");
	}

	/**
	 * 
	 * @param uniteCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerUnite(String uniteCode) throws MecaException, SQLException {
		if(uniteCode.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(!this.unites.existeCode(uniteCode))
			this.unites.supprimerUnite(uniteCode);
		else
			throw new MecaException("Ce code n'est pas enregistré");
	}

	/**
	 * 
	 * @param unite
	 * @param superUnite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerSorg(String unite, String superUnite) throws MecaException, SQLException {
		if(unite.length() == 0 || superUnite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(this.sorgs.existe(unite, superUnite))
			this.sorgs.supprimerSorg(unite, superUnite);
		else
			throw new MecaException("Cette structure organisationnelle n'est pas enregistrée");
	}

}