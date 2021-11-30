package meca.traitement;

import meca.meca.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import meca.accesAuxDonnees.*;

public class GestionPrevisions {

	private Connexion cx;
	private TablePrevision previsions;

	/**
	 * 
	 * @param previsions
	 */
	public GestionPrevisions(TablePrevision previsions) {
		this.previsions = previsions;
	}

	public List<TuplePrevision> listerPrevisions() throws SQLException {
		return this.previsions.findAll();
	}

	/**
	 * 
	 * @param previsionCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public TuplePrevision rechercherByCode(String previsionCode) throws MecaException, SQLException {
		if(previsionCode.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return previsions.findByCode(previsionCode);
	}

	/**
	 * 
	 * @param previsionDate
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePrevision> rechercherByDate(String previsionDate) throws MecaException, SQLException {
		if(previsionDate.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date previsionDateConv = Date.valueOf(previsionDate);
			
			return previsions.findByDate(previsionDateConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
		
	}

	/**
	 * 
	 * @param effectif
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePrevision> rechercherByEffectif(String effectif) throws MecaException, SQLException {
		if(effectif.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return previsions.findByEffectif(effectif);
	}

	/**
	 * 
	 * @param effectif
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePrevision> rechercherByUnite(String unite) throws MecaException, SQLException {
		if(unite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return previsions.findByUnite(unite);
	}

	/**
	 * 
	 * @param typeActivite
	 * @throws SQLException 
	 * @throws MecaException 
	 */
	public List<TuplePrevision> rechercherByActivite(String typeActivite) throws SQLException, MecaException {
		if(typeActivite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return previsions.findByActivite(typeActivite);
	}

	/**
	 * 
	 * @param quantite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePrevision> rechercherByQuantite(String quantite) throws MecaException, SQLException {
		if(quantite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			double quantiteConv = Double.valueOf(quantite);
			
			return previsions.findByQuantite(quantiteConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Format invalide pour la quantite de travail (Double)");
		}
	}

	/**
	 * 
	 * @param periodeDebut
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePrevision> rechercherByDebut(String periodeDebut) throws MecaException, SQLException {
		if(periodeDebut.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date periodeDebutConv = Date.valueOf(periodeDebut);
			
			return previsions.findByDebut(periodeDebutConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param periodeFin
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePrevision> rechercherByFin(String periodeFin) throws MecaException, SQLException {
		if(periodeFin.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date periodeDebutConv = Date.valueOf(periodeFin);
			
			return previsions.findByDebut(periodeDebutConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param previsionCodeOld
	 * @param previsionCodeNew
	 * @param previsionDate
	 * @param effectif
	 * @param unite
	 * @param typeActivite
	 * @param quantite
	 * @param periodeDebut
	 * @param periodeFin
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void modifierPrevision(String previsionCodeOld, String previsionCodeNew, String previsionDate, String effectif, String unite, String typeActivite, String quantite, String periodeDebut, String periodeFin) throws MecaException, SQLException {
		if(previsionCodeNew.length() == 0 || previsionDate.length() == 0 || effectif.length() == 0 || unite.length() == 0 || typeActivite.length() == 0 || quantite.length() == 0 || periodeDebut.length() == 0 || periodeFin.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		
		try {
			Date previsionDateConv = Date.valueOf(previsionDate);
			Date periodeDebutConv = Date.valueOf(periodeDebut);
			Date periodeFinConv = Date.valueOf(periodeFin);
			
			double quantiteConv = Double.valueOf(quantite);
			
			if(!previsionCodeNew.equals(previsionCodeOld)) {
				if(!previsions.existe(previsionCodeNew)) {
					previsions.modifierPrevision(previsionCodeOld, previsionCodeNew, previsionDateConv, effectif, unite, typeActivite, quantiteConv, periodeDebutConv, periodeFinConv);
					cx.commit();
				}else {
					cx.rollback();
					throw new MecaException("Le nouveau code est déjà enregistré");
				}
			}
		}catch(IllegalArgumentException e) {
			cx.rollback();
			throw new MecaException("Format de date ou de quantité incorrect.");
		}

	}

	/**
	 * 
	 * @param previsionCode
	 * @param previsionDate
	 * @param effectif
	 * @param unite
	 * @param typeActivite
	 * @param quantite
	 * @param periodeDebut
	 * @param periodeFin
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterPrevision(String previsionCode, String previsionDate, String effectif, String unite, String typeActivite, String quantite, String periodeDebut, String periodeFin) throws SQLException, MecaException {
		if(previsionCode.length() == 0 || previsionDate.length() == 0 || effectif.length() == 0 || unite.length() == 0 || typeActivite.length() == 0 || quantite.length() == 0 || periodeDebut.length() == 0 || periodeFin.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		
		try {
			Date previsionDateConv = Date.valueOf(previsionDate);
			Date periodeDebutConv = Date.valueOf(periodeDebut);
			Date periodeFinConv = Date.valueOf(periodeFin);
			
			double quantiteConv = Double.valueOf(quantite);
			

			if(!previsions.existe(previsionCode)) {
				previsions.ajouterPrevision(previsionCode, previsionDateConv, effectif, unite, typeActivite, quantiteConv, periodeDebutConv, periodeFinConv);
				cx.commit();
			}else {
				cx.rollback();
				throw new MecaException("Le nouveau code est déjà enregistré");
			}

		}catch(IllegalArgumentException e) {
			cx.rollback();
			throw new MecaException("Format de date ou de quantité incorrect.");
		}
	}

	/**
	 * 
	 * @param previsionCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerPrevision(String previsionCode) throws SQLException, MecaException {
		if(previsionCode.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!previsions.existe(previsionCode)) {
			cx.rollback();
			throw new MecaException("Ce code de prévision n'est pas enregistré");
		}
		else {
			previsions.supprimerPrevision(previsionCode);
			cx.commit();
		}
	}

}