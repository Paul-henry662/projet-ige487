package meca.traitement;

import meca.meca.*;

import java.sql.SQLException;
import meca.accesAuxDonnees.*;

public class GestionMeca {

	private GestionEffectifs gestionEffectifs;
	private GestionActivites gestionActivites;
	private GestionUnites gestionUnites;
	private GestionPrevisions gestionPrevisions;
	private Connexion cx;
	private TableEffectif effectifs;
	private TablePermis permis;
	private TableTypeActivite typesActivites;
	private TablePermisActivite permisActivites;
	private TableUnite unites;
	private TableSorg sorgs;
	private TablePrevision previsions;

	/**
	 * 
	 * @param serveur
	 * @param bd
	 * @param user
	 * @param pass
	 * @throws SQLException 
	 * @throws MecaException 
	 */
	public GestionMeca(String serveur, String bd, String user, String pass) throws SQLException, MecaException {
		this.cx = new Connexion(serveur, bd, user, pass);
		this.effectifs = new TableEffectif(cx);
		this.gestionEffectifs = new GestionEffectifs(effectifs);
	}

	
	public GestionEffectifs getGestionEffectifs() {
		return gestionEffectifs;
	}


	public GestionActivites getGestionActivites() {
		return gestionActivites;
	}


	public GestionUnites getGestionUnites() {
		return gestionUnites;
	}


	public GestionPrevisions getGestionPrevisions() {
		return gestionPrevisions;
	}


	public void quitter() {
		// TODO - implement GestionMeca.quitter
		throw new UnsupportedOperationException();
	}

	public Connexion getCx() {
		return this.cx;
	}

}