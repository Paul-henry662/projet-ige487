package traitement;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import accesDonees.TableEffectif;
import accesDonees.TupleEffectif;
import meca.Connexion;
import meca.MecaException;

public class GestionEffectifs {
	private Connexion cx;
	private TableEffectif effectifs;
	
	public GestionEffectifs(TableEffectif effectifs) {
		this.effectifs = effectifs;
		this.cx = effectifs.getConnexion();
	}
	
	public void ajouterEffectif(String effMatr, String nom, String prenom, String dateNaissance) throws SQLException, MecaException {
		
		if(effMatr.length() == 0 || nom.length() == 0 || prenom.length() == 0 || dateNaissance.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		try {
			Date dateNaiss = Date.valueOf(dateNaissance);
			
			if(!this.effectifs.existe(effMatr)) {		
				this.effectifs.ajouterEffectif(effMatr, nom, prenom, dateNaiss);
				cx.commit();
			}else {
				throw new MecaException("Ce matricule est déjà enregistré");
			}
			
		}catch (IllegalArgumentException e) {
			throw new MecaException("Valeur incorrecte pour la date (yyyy-mm-dd)");
		}
		
	}
	
	public void supprimerEffectif(String effMatr) throws SQLException, MecaException {
		
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
	
	public List<TupleEffectif> listerEffectifs() throws SQLException {
		return this.effectifs.findAll();
	}
	
	public void modifierEffectif(String effMatrOld, String effMatrNew, String nom, String prenom, String dateNaissance) throws SQLException, MecaException {
		if(effMatrOld.length() == 0 || effMatrNew.length() == 0 || nom.length() == 0 || prenom.length() == 0 || dateNaissance.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date dateNaiss = Date.valueOf(dateNaissance);
			System.out.println(effMatrOld +  " " + effMatrNew);
			System.out.println(effMatrNew.equals(effMatrOld));
			
			if(!effMatrNew.equals(effMatrOld)) {
				if(!effectifs.existe(effMatrNew))
					effectifs.modifierEffectif(effMatrOld, effMatrNew, nom, prenom, dateNaiss);
				else
					throw new MecaException("Le nouveau matricule est déjà associé à un autre ECA");
			}
			
			else 
				effectifs.modifierEffectif(effMatrOld, effMatrNew, nom, prenom, dateNaiss);
			
			cx.commit();
			
		}catch (IllegalArgumentException e) {
			throw new MecaException("Valeur incorrecte pour la date (yyyy-mm-dd)");
		}
	}

	
	public TupleEffectif rechercherEffectifByMatr(String effMatr) throws SQLException, MecaException {
		if(effMatr.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		if(this.effectifs.existe(effMatr)) {
			return this.effectifs.findByMatr(effMatr);
		}
		else
			throw new MecaException("Ce matricule n'est pas enregistré");
	}
	
	public List<TupleEffectif> rechercherEffectifByNom(String nom) throws SQLException {
		return this.effectifs.findByNom(nom);
	}
	
	public List<TupleEffectif> rechercherEffectifByPrenom(String prenom) throws SQLException {
		return this.effectifs.findByPrenom(prenom);
	}
	
	public List<TupleEffectif> rechercherEffectifByDateNaiss(Date dateNaissance) throws SQLException {
		return this.effectifs.findByDateNaiss(dateNaissance);
	}
}
