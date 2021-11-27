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
	
	public void ajouterEffectif(String effMatr, String nom, String prenom, Date dateNaissance) throws SQLException, MecaException {
		if(!this.effectifs.existe(effMatr)) {
			this.effectifs.ajouterEffectif(effMatr, nom, prenom, dateNaissance);
			cx.commit();
		}else {
			cx.rollback();
			throw new MecaException("Ce matricule est déjà enregistré");
		}
	}
	
	public void supprimerEffectif(String effMatr) throws SQLException, MecaException {
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
	
	public void modifierEffectif(String effMatrOld, String effMatrNew, String nom, String prenom, Date dateNaissance) throws SQLException, MecaException {
		if(this.effectifs.existe(effMatrOld)) {
			if(!this.effectifs.existe(effMatrNew)) {
				this.effectifs.modifierEffectif(effMatrOld, effMatrNew, nom, prenom, dateNaissance);
				cx.commit();
			}else {
				cx.rollback();
				throw new MecaException("Le nouveau matricule est déjà enregistré");
			}
		}
	}

	
	public TupleEffectif rechercherEffectifByMatr(String effMatr) throws SQLException, MecaException {
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
