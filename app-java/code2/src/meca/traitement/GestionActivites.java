package meca.traitement;

import meca.meca.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import meca.accesAuxDonnees.*;

public class GestionActivites {

	private Connexion cx;
	private TablePermis permis;
	private TableTypeActivite typesActivites;
	private TablePermisActivite permisActivites;

	

	public GestionActivites(TablePermis permis, TableTypeActivite typesActivites, TablePermisActivite permisActivites) {
		this.permis = permis;
		this.typesActivites = typesActivites;
		this.permisActivites = permisActivites;
		
		this.cx = permis.getConnection();
	}

	public List<TuplePermis> listerPermis() throws SQLException {
		return this.permis.findAll();
	}

	public List<TupleTypeActivite> listerTypesActivites() throws SQLException {
		return this.typesActivites.findAll();
	}

	public List<TuplePermisActivite> listerPermisActivites() throws SQLException {
		return this.permisActivites.findAll();
	}

	/**
	 * 
	 * @param permisCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public TuplePermis rechercherPermisByCode(String permisCode) throws MecaException, SQLException {
		if(permisCode.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return permis.findByCode(permisCode);
	}

	/**
	 * 
	 * @param effectif
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePermis> rechercherPermisByEffectif(String effectif) throws MecaException, SQLException {
		if(effectif.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return permis.findByEffectif(effectif);
	}

	/**
	 * 
	 * @param valideDebut
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePermis> rechercherPermisByDebut(String valideDebut) throws MecaException, SQLException {
		if(valideDebut.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date valideDebutConv = Date.valueOf(valideDebut);
			return permis.findByDebut(valideDebutConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param valideFin
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePermis> rechercherPermisByFin(String valideFin) throws MecaException, SQLException {
		if(valideFin.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		try {
			Date valideFinConv = Date.valueOf(valideFin);
			return permis.findByDebut(valideFinConv);
		}catch(IllegalArgumentException e) {
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param type
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public TupleTypeActivite rechercherTypeActiviteByCode(String type) throws MecaException, SQLException {
		if(type.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return typesActivites.findByType(type);
	}

	/**
	 * 
	 * @param nom
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public TupleTypeActivite rechercherTypeActiviteByNom(String nom) throws MecaException, SQLException {
		if(nom.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return typesActivites.findByNom(nom);
	}

	/**
	 * 
	 * @param description
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TupleTypeActivite> rechercherTypeActiviteByDescription(String description) throws MecaException, SQLException {
		if(description.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return typesActivites.findByDescription(description);
	}

	/**
	 * 
	 * @param actif
	 * @throws SQLException 
	 */
	public List<TupleTypeActivite> rechercherTypeActiviteByActif(boolean actif) throws SQLException {
		return typesActivites.findByActif(actif);
	}

	/**
	 * 
	 * @param permis
	 * @param typeActivite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public TuplePermisActivite rechercherPermisActivite(String permis, String typeActivite) throws MecaException, SQLException {
		if(permis.length() == 0 || typeActivite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return permisActivites.find(permis, typeActivite);
	}

	/**
	 * 
	 * @param permis
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePermisActivite> rechercherPermisActiviteByPermis(String permis) throws MecaException, SQLException {
		if(permis.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return permisActivites.findByPermis(permis);
	}

	/**
	 * 
	 * @param typeActivite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public List<TuplePermisActivite> rechercherPermisActiviteByActivite(String typeActivite) throws MecaException, SQLException {
		if(typeActivite.length() == 0)
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		
		return permisActivites.findByActivite(typeActivite);
	}

	/**
	 * 
	 * @param permisCodeOld
	 * @param permisCodeNew
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void modifierPermis(String permisCodeOld, String permisCodeNew, String effectif, String valideDebut, String valideFin) throws MecaException, SQLException {
		if(permisCodeOld.length() == 0 || permisCodeNew.length() == 0 || effectif.length() == 0 || valideDebut.length() == 0 || valideFin.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		try {
			Date valideDebutConv = Date.valueOf(valideDebut);
			Date valideFinConv = Date.valueOf(valideFin);
			
			permis.modifierPermis(permisCodeOld, permisCodeNew, effectif, valideDebutConv, valideFinConv);
			
			cx.commit();
			
		}catch(IllegalArgumentException e) {
			cx.rollback();
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param typeOld
	 * @param typeNew
	 * @param nom
	 * @param description
	 * @param actif
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void modifierTypeActivite(String typeOld, String typeNew, String nom, String description, boolean actif) throws MecaException, SQLException {
		if(typeOld.length() == 0 || typeNew.length() == 0 || nom.length() == 0 || description.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		typesActivites.modifierTypeActivite(typeOld, typeNew, nom, description, actif);
		
		cx.commit();
	}

	/**
	 * 
	 * @param permisOld
	 * @param typeActiviteOld
	 * @param permisNew
	 * @param typeActiviteNew
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void modifierPermisActivite(String permisOld, String typeActiviteOld, String permisNew, String typeActiviteNew) throws MecaException, SQLException {
		if(permisNew.length() == 0 || typeActiviteNew.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		permisActivites.modifierPermisActivite(permisOld, typeActiviteOld, permisNew, typeActiviteNew);
		cx.commit();
	}

	/**
	 * 
	 * @param permisCode
	 * @param effectif
	 * @param valideDebut
	 * @param valideFin
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterPermis(String permisCode, String effectif, String valideDebut, String valideFin) throws MecaException, SQLException {
		if(permisCode.length() == 0 || effectif.length() == 0 || valideDebut.length() == 0 || valideFin.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(permis.existe(permisCode)) {
			cx.rollback();
			throw new MecaException("Ce code de permis est déjà enregistré");
		}
		
		try {
			Date valideDebutConv = Date.valueOf(valideDebut);
			Date valideFinConv = Date.valueOf(valideFin);
			
			permis.ajouterPermis(permisCode, effectif, valideDebutConv, valideFinConv);
			
			cx.commit();
		}catch(IllegalArgumentException e) {
			cx.rollback();
			throw new MecaException("Format de date invalide (yyyy-mm-dd)");
		}
	}

	/**
	 * 
	 * @param type
	 * @param nom
	 * @param description
	 * @param actif
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterTypeActivite(String type, String nom, String description, boolean actif) throws MecaException, SQLException {
		if(type.length() == 0 || nom.length() == 0 || description.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(typesActivites.existe(type)) {
			cx.rollback();
			throw new MecaException("Ce code de type d'activité est déjà enregistré");
		}
		
		typesActivites.ajouterTypeActivite(type, nom, description, actif);
		
		cx.commit();
	}

	/**
	 * 
	 * @param permis
	 * @param typeActivite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void ajouterPermisActivite(String permis, String typeActivite) throws MecaException, SQLException {
		if(permis.length() == 0 || typeActivite.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(permisActivites.existe(permis, typeActivite)) {
			cx.rollback();
			throw new MecaException("Cette association permis-activité est déjà enregistrée");
		}
		
		permisActivites.ajouterPermisActivite(permis, typeActivite);
		
		cx.commit();
	}

	/**
	 * 
	 * @param permisCode
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerPermis(String permisCode) throws MecaException, SQLException {
		if(permisCode.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!permis.existe(permisCode)) {
			cx.rollback();
			throw new MecaException("Ce code de permis n'est pas enregistré");
		}
		
		permis.supprimerPermis(permisCode);
		
		cx.commit();
	}

	/**
	 * 
	 * @param type
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerTypeActivite(String type) throws MecaException, SQLException {
		if(type.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!typesActivites.existe(type)) {
			cx.rollback();
			throw new MecaException("Ce code de type d'activité n'est pas enregistré");
		}
		
		typesActivites.supprimerTypeActivite(type);
		
		cx.commit();
	}

	/**
	 * 
	 * @param permis
	 * @param typeActivite
	 * @throws MecaException 
	 * @throws SQLException 
	 */
	public void supprimerPermisActivite(String permis, String typeActivite) throws MecaException, SQLException {
		if(permis.length() == 0 || typeActivite.length() == 0) {
			cx.rollback();
			throw new MecaException("Un ou plusieurs champ(s) manquant(s)");
		}
		
		if(!permisActivites.existe(permis, typeActivite)) {
			cx.rollback();
			throw new MecaException("Ce code de permis n'est pas enregistré");
		}
		
		permisActivites.supprimerPermisActivite(permis, typeActivite);
		
		cx.commit();
	}

}