package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import accesDonees.TupleEffectif;
import meca.MecaException;
import traitement.GestionMeca;

public class Meca implements ActionListener{
	
	private GestionMeca gestionMeca;
	
	private MecaFrame frame;
	private HomePanel homePanel;
	
	private GestionEffectifsPanel gestionEffectifsPanel;
	private AjouterEffectifPanel ajouterEffectifPanel;
	private ListerEffectifsPanel listerEffectifsPanel;
	private ModifierEffectifPanel modifierEffectifPanel;

	public Meca(String serveur, String bd, String user, String pass) throws MecaException, SQLException {
		gestionMeca = new GestionMeca(serveur, bd, user, pass);
		
		frame = new MecaFrame();
		homePanel = new HomePanel(this);
		gestionEffectifsPanel = new GestionEffectifsPanel(this);
		ajouterEffectifPanel = new AjouterEffectifPanel(this);
		listerEffectifsPanel = new ListerEffectifsPanel(this);
		modifierEffectifPanel = new ModifierEffectifPanel(this);
	}
	
	public GestionMeca getGestionMeca() {
		return this.gestionMeca;
	}

	public static void main(String[] args) throws MecaException, SQLException {
		Meca meca = new Meca("local", "MECA", "postgres", "6Juin2002");
		
		meca.frame.switchPanel(meca.homePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		try {
			//Clic sur le bouton Gestion ECA de la page d'accueil
			if(e.getSource() == homePanel.getBtnGestionEffectifs())
				frame.switchPanel(gestionEffectifsPanel);
			
			//Clic sur le bouton Ajouter effectif de la page de gestion des ECA
			else if(e.getSource() == gestionEffectifsPanel.getBtnAjouterEffectif())
				frame.switchPanel(ajouterEffectifPanel);
			
			//Clic sur le bouton Modifier effectif de la page de gestion des ECA
			else if(e.getSource() == gestionEffectifsPanel.getBtnModifierEffectif()) {
				String effMatr = JOptionPane.showInputDialog("Matricule de l'ECA à modifier");
				
				if(effMatr != null) {
					modifierEffectifPanel.setEffMatr(effMatr);
					
					TupleEffectif effectif = this.getGestionMeca().getGestionEffectifs().rechercherEffectifByMatr(modifierEffectifPanel.getEffMatr());
					modifierEffectifPanel.getMatrField().setText(effectif.getEffMatr());
					modifierEffectifPanel.getNomField().setText(effectif.getNom());
					modifierEffectifPanel.getPrenomField().setText(effectif.getPrenom());
					modifierEffectifPanel.getDateNaissField().setText(effectif.getDateNaissance().toString());
					
					frame.switchPanel(modifierEffectifPanel);
				}
			}
			
			//Clic sur le bouton Supprimer Effectif de la page de gestion des ECA
			else if(e.getSource() == gestionEffectifsPanel.getBtnSupprimerEffectif()) {
				String effMatr = JOptionPane.showInputDialog("Matricule de l'ECA à supprimer"
						+ "\nNb: la suppression d'un effectif supprime également tous les permis "
						+ "et prévisions associés.");
				
				if(effMatr != null) {
					this.getGestionMeca().getGestionEffectifs().supprimerEffectif(effMatr);
					
					frame.displaySuccess("Effectif " + effMatr + " supprimé !");
				}
			}
			
			//Clic sur le bouton Modifier de la page de modification d'un ECA
			else if(e.getSource() == modifierEffectifPanel.getValiderBtn()) {
				String effMatrOld = modifierEffectifPanel.getEffMatr();
				String effMatrNew = modifierEffectifPanel.getMatrField().getText();
				String Nom = modifierEffectifPanel.getNomField().getText();
				String Prenom = modifierEffectifPanel.getPrenomField().getText();
				String DateNaissance = modifierEffectifPanel.getDateNaissField().getText();
				
				this.getGestionMeca().getGestionEffectifs().modifierEffectif(effMatrOld, effMatrNew, Nom, Prenom, DateNaissance);
				frame.displaySuccess("Effectif " + effMatrOld + " modifié!");
				frame.switchPanel(gestionEffectifsPanel);
			}
			
			//Clic sur le bouton Retour de la page de modification des ECA
			else if(e.getSource() == modifierEffectifPanel.getRetourBtn())
				frame.switchPanel(gestionEffectifsPanel);
			
			//Clic sur le bouton Lister Effectifs de la page de gestion des ECA
			else if(e.getSource() == gestionEffectifsPanel.getBtnListerEffectifs()) {
				frame.switchPanel(listerEffectifsPanel);
			}
			
			else if(e.getSource() == gestionEffectifsPanel.getBtnRetour())
				frame.switchPanel(homePanel);
			
			else if(e.getSource() == ajouterEffectifPanel.getValiderBtn()) {
				String effMatr = ajouterEffectifPanel.getMatrField().getText();
				String nom = ajouterEffectifPanel.getNomField().getText();
				String prenom = ajouterEffectifPanel.getPrenomField().getText();
				String dateNaissance = ajouterEffectifPanel.getDateNaissField().getText();
				
				System.out.println(effMatr);
				
				this.getGestionMeca().getGestionEffectifs().ajouterEffectif(effMatr, nom, prenom, dateNaissance);
				frame.displaySuccess("Nouvel Effectif ajouté");
				frame.switchPanel(gestionEffectifsPanel);
			}
			
			else if(e.getSource() == ajouterEffectifPanel.getRetourBtn())
				frame.switchPanel(gestionEffectifsPanel);
			
		}catch(Exception exception) {
			frame.displayError(exception.getMessage());
		}
		
	}
}
