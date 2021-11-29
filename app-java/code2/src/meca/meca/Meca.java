package meca.meca;

import java.sql.SQLException;

import meca.traitement.GestionMeca;

public class Meca {
	
	private GestionMeca gestionMeca;
	
	public Meca(String serveur, String bd, String user, String pass) throws SQLException, MecaException {
		this.gestionMeca = new GestionMeca(serveur, bd, user, pass);
	}

	public static void main(String[] args) throws SQLException, MecaException {
		Meca meca = new Meca("local", "MECA","paulhenry", "groupe2");
		
		meca.gestionMeca.getGestionEffectifs().ajouterEffectif("00000012", "azerty", "babylone", "2002-06-06");
		
	}

}
