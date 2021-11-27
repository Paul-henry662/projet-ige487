package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import meca.MecaException;
import traitement.GestionMeca;

public class Meca implements ActionListener{
	
	private GestionMeca gestionMeca;
	
	private MecaFrame frame;
	private HomePanel homePanel;
	private GestionEffectifsPanel gestionEffectifsPanel;

	public Meca(String serveur, String bd, String user, String pass) throws MecaException, SQLException {
		gestionMeca = new GestionMeca(serveur, bd, user, pass);
		
		frame = new MecaFrame();
		homePanel = new HomePanel(this);
		gestionEffectifsPanel = new GestionEffectifsPanel(this);
	}
	
	public GestionMeca getGestionMeca() {
		return this.gestionMeca;
	}

	public static void main(String[] args) throws MecaException, SQLException {
		Meca meca = new Meca("local", "MECA", "postgres", "6Juin2002");
		
		meca.frame.switchPanel(meca.homePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homePanel.getBtnGestionEffectifs())
			frame.switchPanel(gestionEffectifsPanel);
		else if(e.getSource() == gestionEffectifsPanel.getBtnRetour())
			frame.switchPanel(homePanel);
	}

}
