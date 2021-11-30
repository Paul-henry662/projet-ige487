package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import meca.accesAuxDonnees.TupleEffectif;
import meca.meca.MecaException;
import meca.traitement.GestionMeca;

public class Meca implements ActionListener{
	
	private static final String SERVEUR = "local";
	private static final String BD = "MECA";
	private GestionMeca gestionMeca;
	
	private LoginFrame loginFrame;
	private MecaFrame frame;
	
	private HomePanel homePanel;
	private AjouterEffectifPanel ajouterEffectifPanel;
	private ModifierEffectifPanel modifierEffectifPanel;
	private RechercheEffectifPanel rechercheEffectifPanel;
	private ResultatRechercheEffectifPanel resultatRechercheEffectifPanel;
	
	public Meca() throws SQLException, MecaException {
		this.loginFrame = new LoginFrame(this);
	}

	public static void main(String[] args) throws SQLException, MecaException {
		Meca meca = new Meca();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == loginFrame.getConnexionBtn()) {
				String user = loginFrame.getUserField().getText();
				String pass = loginFrame.getPassField().getText();
				
				try {
					this.gestionMeca = new GestionMeca(SERVEUR, BD, user, pass);
					loginFrame.displaySuccess("Bienvenue, " + user);
					loginFrame.dispose();
					this.initialize();
				} catch (SQLException | MecaException e1) {
					loginFrame.displayError("Echec de la connexion"
							+ "\nVérifiez le nom d'utilisateur et/ou le mot de passe");
				}
			}
			else if(e.getSource() == homePanel.getAjouterEffectifBtn()) {
				frame.switchPanel(ajouterEffectifPanel);
			}
			else if(e.getSource() == ajouterEffectifPanel.getValiderBtn()) {
				String effMatr = ajouterEffectifPanel.getEffMatrField().getText();
				String nom = ajouterEffectifPanel.getNomField().getText();
				String prenom = ajouterEffectifPanel.getPrenomField().getText();
				String dateNaiss = ajouterEffectifPanel.getDateNaissField().getText();
				
				this.gestionMeca.getGestionEffectifs().ajouterEffectif(effMatr, nom, prenom, dateNaiss);
				frame.displaySuccess("Nouvel ECA ajouté");
				frame.switchPanel(homePanel);
			}
			else if(e.getSource() == homePanel.getModifierEffectifBtn()) {
				String effMatr = JOptionPane.showInputDialog("Matricule de l'effectif à modifier");
				
				TupleEffectif effectif = this.gestionMeca.getGestionEffectifs().rechercherByMatr(effMatr);
				modifierEffectifPanel.setEffMatr(effMatr);
				
				this.modifierEffectifPanel.getEffMatrField().setText(effMatr);
				this.modifierEffectifPanel.getNomField().setText(effectif.getNom());
				this.modifierEffectifPanel.getPrenomField().setText(effectif.getPrenom());
				this.modifierEffectifPanel.getDateNaissField().setText(effectif.getDateNaiss().toString());
				
				frame.switchPanel(modifierEffectifPanel);
			}
			else if(e.getSource() == modifierEffectifPanel.getValiderBtn()) {
				String effMatrOld = modifierEffectifPanel.getEffMatr();
				String effMatrNew = modifierEffectifPanel.getEffMatrField().getText();
				String nom = modifierEffectifPanel.getNomField().getText();
				String prenom = modifierEffectifPanel.getPrenomField().getText();
				String dateNaiss = modifierEffectifPanel.getDateNaissField().getText();
				
				this.gestionMeca.getGestionEffectifs().modifierEffectif(effMatrOld, effMatrNew, nom, prenom, dateNaiss);
				frame.displaySuccess("Effectif "+effMatrOld+" modifié");
				frame.switchPanel(homePanel);
			}
			else if(e.getSource() == homePanel.getSupprimerEffectifBtn()) {
				String effMatr = JOptionPane.showInputDialog("Matricule de l'effectif à supprimer"
						+ "\nNB: La suppression d'un ECA entraine celle de tous les permis et prévisions associés.");
				
				this.gestionMeca.getGestionEffectifs().supprimerEffectif(effMatr);
				frame.displaySuccess("Effectif "+effMatr+" supprimé");
			}
			else if(e.getSource() == homePanel.getListerEffectifsBtn()) {
				for(TupleEffectif effectif : this.gestionMeca.getGestionEffectifs().listerEffectifs()) {
					JLabel effectifLabel = new JLabel(effectif.toString());
	
					resultatRechercheEffectifPanel.add(effectifLabel);
					frame.switchPanel(resultatRechercheEffectifPanel);
				}
				
				System.out.println(this.gestionMeca.getGestionEffectifs().listerEffectifs());
			}
			
		}catch(Exception exception) {
			frame.displayError(exception.getMessage());
		}
	}
	
	public void initialize() {
		this.frame = new MecaFrame(this);
		this.homePanel = new HomePanel(frame);
		this.ajouterEffectifPanel = new AjouterEffectifPanel(frame);
		this.modifierEffectifPanel = new ModifierEffectifPanel(frame);
		this.rechercheEffectifPanel = new RechercheEffectifPanel(frame);
		this.resultatRechercheEffectifPanel = new ResultatRechercheEffectifPanel(frame);
		frame.switchPanel(homePanel);
	}

}
