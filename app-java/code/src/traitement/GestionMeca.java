package traitement;

import java.sql.SQLException;

import accesDonees.TableEffectif;
import meca.Connexion;
import meca.MecaException;

public class GestionMeca {
	private Connexion cx;
	private GestionEffectifs gestionEffectifs;
	private TableEffectif effectifs;
	
	public GestionMeca(String serveur, String bd, String user, String password) throws MecaException, SQLException {
		this.cx = new Connexion(serveur, bd, user, password);
		this.effectifs = new TableEffectif(cx);
		this.gestionEffectifs = new GestionEffectifs(effectifs);
	}
	
	public Connexion getCx() {
		return cx;
	}
	public GestionEffectifs getGestionEffectifs() {
		return gestionEffectifs;
	}
	
	public void quitter() {
		
	}
}
