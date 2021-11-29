package meca.meca;

import java.sql.SQLException;

import meca.traitement.GestionMeca;

public class Meca {
	
	private GestionMeca gestionMeca;
	
	public Meca(String serveur, String bd, String user, String pass) throws SQLException, MecaException {
		this.gestionMeca = new GestionMeca(serveur, bd, user, pass);
	}

	public static void main(String[] args) throws SQLException, MecaException {
		Meca meca = new Meca("local", "MECA", "marlene", "azerty");
		
		System.out.println(meca.gestionMeca.getGestionEffectifs().rechercherByMatr("00000002"));
	}

}
