package presentation;

import java.sql.SQLException;

import meca.meca.MecaException;
import meca.traitement.GestionMeca;

public class Meca {
	
	private GestionMeca gestionMeca;
	
	public Meca(String serveur, String bd, String user, String pass) throws SQLException, MecaException {
		this.gestionMeca = new GestionMeca(serveur, bd, user, pass);
	}

	public static void main(String[] args) throws SQLException, MecaException {
		Meca meca = new Meca("local", "MECA","paulhenry", "azerty");		
		
		meca.gestionMeca.getGestionUnites().ajouterUnite("UNITE101", "nomUnite101");
	}

}
