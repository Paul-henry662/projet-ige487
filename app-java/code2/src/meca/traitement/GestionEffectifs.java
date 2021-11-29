package meca.traitement;

import meca.meca.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import meca.accesAuxDonnees.*;

public class GestionEffectifs {

	private Connexion cx;
	private TableEffectif effectifs;

	/**
	 * 
	 * @param effectifs
	 */
	public GestionEffectifs(TableEffectif effectifs) {
		this.effectifs = effectifs;
		this.cx = effectifs.getConnection();
	}

	public List<TupleEffectif> listerEffectifs() throws SQLException {
		return this.effectifs.findAll();
	}

	/**
	 * 
	 * @param effMatr
	 * @throws meca.meca.MecaException 
	 * @throws SQLException 
	 */
	public TupleEffectif rechercherByMatr(String effMatr) throws meca.meca.MecaException, SQLException {
		if(effMatr.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(this.effectifs.existe(effMatr)) {
			return this.effectifs.findByMatr(effMatr);
		}
		else
			throw new MecaException("Ce matricule n'est pas enregistré");
	}

	/**
	 * 
	 * @param nom
	 * @throws SQLException 
	 */
	public List<TupleEffectif> rechercherByNom(String nom) throws SQLException {
		return this.effectifs.findByNom(nom);
	}

	/**
	 * 
	 * @param prenom
	 * @throws SQLException 
	 */
	public List<TupleEffectif> rechercherByPrenom(String prenom) throws SQLException {
		return this.effectifs.findByNom(prenom);
	}

	/**
	 * 
	 * @param dateNaiss
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TupleEffectif> rechercherByDateNaiss(String dateNaiss) throws MecaException, SQLException {
		try {
			Date dateNaissConv = Date.valueOf(dateNaiss);
			return this.effectifs.findByDateNaiss(dateNaissConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Valeur incorrecte pour la date (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param effMatrOld
	 * @param effMatrNew
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 * @throws meca.meca.MecaException 
	 * @throws SQLException 
	 */
	public void modifierEffectif(String effMatrOld, String effMatrNew, String nom, String prenom, String dateNaiss) throws meca.meca.MecaException, SQLException {
		if(effMatrOld.length() == 0 || effMatrNew.length() == 0 || nom.length() == 0 || prenom.length() == 0 || dateNaiss.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date dateNaissConv = Date.valueOf(dateNaiss);
			System.out.println(effMatrOld +  " " + effMatrNew);
			System.out.println(effMatrNew.equals(effMatrOld));
			
			if(!effMatrNew.equals(effMatrOld)) {
				if(!effectifs.existe(effMatrNew))
					effectifs.modifierEffectif(effMatrOld, effMatrNew, nom, prenom, dateNaissConv);
				else
					throw new MecaException("Le nouveau matricule est déjà associé à un autre ECA");
			}
			
			else 
				effectifs.modifierEffectif(effMatrOld, effMatrNew, nom, prenom, dateNaissConv);
			
			cx.commit();
			
		}catch (IllegalArgumentException e) {
			throw new MecaException("Valeur incorrecte pour la date (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param effMatr
	 * @param nom
	 * @param prenom
	 * @param dateNaiss
	 * @throws meca.meca.MecaException 
	 * @throws SQLException 
	 */
	public void ajouterEffectif(String effMatr, String nom, String prenom, String dateNaiss) throws meca.meca.MecaException, SQLException {
		
		if(effMatr.length() == 0 || nom.length() == 0 || prenom.length() == 0 || dateNaiss.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date dateNaissConv = Date.valueOf(dateNaiss);
			
			if(!this.effectifs.existe(effMatr)) {		
				this.effectifs.ajouterEffectif(effMatr, nom, prenom, dateNaissConv);
				cx.commit();
			}else {
				throw new MecaException("Ce matricule est déjà enregistré");
			}
			
		}catch (IllegalArgumentException e) {
			throw new MecaException("Valeur incorrecte pour la date (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param effMatr
	 * @throws meca.meca.MecaException 
	 * @throws SQLException 
	 */
	public void supprimerEffectif(String effMatr) throws meca.meca.MecaException, SQLException {
		if(effMatr.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(this.effectifs.existe(effMatr)) {
			this.effectifs.supprimerEffectif(effMatr);
			cx.commit();
		}else {
			cx.rollback();
			throw new MecaException("Ce matricule n'est pas enregistré");
		}
	}

}