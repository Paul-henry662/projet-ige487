package presentation;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePanel extends MecaPanel {
	private JButton ajouterEffectifBtn;
	private JButton modifierEffectifBtn;
	private JButton supprimerEffectifBtn;
	private JButton listerEffectifsBtn;
	private JButton rechercherEffectifBtn;
	private JButton ajouterPermisBtn;
	private JButton ajouterTypeActiviteBtn;
	private JButton ajouterPermisActiviteBtn;
	private JButton modifierPermisBtn;
	private JButton modifierTypeActiviteBtn;
	private JButton modifierPermisActiviteBtn;
	private JButton supprimerPermisActiviteBtn;
	private JButton supprimerTypeActiviteBtn;
	private JButton supprimerPermistn;
	private JButton listerPermisActivitesBtn;
	private JButton listerTypesActivitesBtn;
	private JButton listerPermisBtn;
	private JButton rechercherPermisBtn;
	private JButton rechercherPermisActiviteBtn;
	private JButton modifierPrevisionBtn;
	private JButton supprimerPrevisionBtn;
	private JButton rechercherPrevisionBtn;
	private JButton listerPrevisionsBtn;
	private JButton ajouterPrevisionBtn;
	private JButton rechercherSorgBtn;
	private JButton supprimerSorgBtn;
	private JButton ajouterSorgBtn;
	private JButton supprimerUniteBtn;
	private JButton modifierUniteBtn;
	private JButton listerSorgBtn;
	private JButton modifierSorgBtn;
	private JButton rechercherUniteBtn;
	private JButton listerUnitesBtn;
	private JButton ajouterUniteBtn;

	/**
	 * Create the panel.
	 */
	public HomePanel(MecaFrame frame) {
		super(frame);
		setLayout(null);
		
		JLabel gestionEffectifsLabel = new JLabel("Gestion des ECA");
		gestionEffectifsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gestionEffectifsLabel.setBounds(29, 0, 198, 64);
		add(gestionEffectifsLabel);
		
		JLabel lblGestionDesActivites = new JLabel("Gestion des Activit\u00E9s");
		lblGestionDesActivites.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestionDesActivites.setBounds(308, 0, 198, 64);
		add(lblGestionDesActivites);
		
		JLabel lblGestionDesUnits = new JLabel("Gestion des UO");
		lblGestionDesUnits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestionDesUnits.setBounds(308, 320, 198, 64);
		add(lblGestionDesUnits);
		
		JLabel lblGestionDesPrvisions = new JLabel("Gestion des pr\u00E9visions");
		lblGestionDesPrvisions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGestionDesPrvisions.setBounds(916, 320, 198, 64);
		add(lblGestionDesPrvisions);
		
		ajouterEffectifBtn = new JButton("Ajouter un effectif");
		ajouterEffectifBtn.setBounds(29, 72, 172, 42);
		add(ajouterEffectifBtn);
		ajouterEffectifBtn.addActionListener(frame.getActionListener());
		
		modifierEffectifBtn = new JButton("Modifier un effectif");
		modifierEffectifBtn.setBounds(29, 165, 172, 42);
		add(modifierEffectifBtn);
		modifierEffectifBtn.addActionListener(frame.getActionListener());
		
		supprimerEffectifBtn = new JButton("Supprimer un effectif");
		supprimerEffectifBtn.setBounds(29, 258, 172, 42);
		add(supprimerEffectifBtn);
		supprimerEffectifBtn.addActionListener(frame.getActionListener());
		
		listerEffectifsBtn = new JButton("Lister les effectifs");
		listerEffectifsBtn.setBounds(29, 351, 172, 42);
		add(listerEffectifsBtn);
		listerEffectifsBtn.addActionListener(frame.getActionListener());
		
		rechercherEffectifBtn = new JButton("Rechercher dans les effectifs");
		rechercherEffectifBtn.setBounds(29, 444, 172, 42);
		add(rechercherEffectifBtn);
		
		ajouterPermisBtn = new JButton("Ajouter un permis");
		ajouterPermisBtn.setBounds(308, 74, 172, 42);
		add(ajouterPermisBtn);
		
		modifierPermisBtn = new JButton("Modifier un permis");
		modifierPermisBtn.setBounds(511, 72, 172, 42);
		add(modifierPermisBtn);
		
		supprimerPermistn = new JButton("Supprimer un permis");
		supprimerPermistn.setBounds(714, 72, 172, 42);
		add(supprimerPermistn);
		
		listerPermisBtn = new JButton("Lister les permis");
		listerPermisBtn.setBounds(917, 72, 172, 42);
		add(listerPermisBtn);
		
		ajouterTypeActiviteBtn = new JButton("Ajouter un type d'activit\u00E9");
		ajouterTypeActiviteBtn.setBounds(308, 165, 172, 42);
		add(ajouterTypeActiviteBtn);
		
		modifierTypeActiviteBtn = new JButton("Modifier un type d'activit\u00E9");
		modifierTypeActiviteBtn.setBounds(511, 163, 172, 42);
		add(modifierTypeActiviteBtn);
		
		supprimerTypeActiviteBtn = new JButton("Supprimer un type d'activit\u00E9");
		supprimerTypeActiviteBtn.setBounds(714, 163, 172, 42);
		add(supprimerTypeActiviteBtn);
		
		listerTypesActivitesBtn = new JButton("Lister les types d'activit\u00E9");
		listerTypesActivitesBtn.setBounds(917, 163, 172, 42);
		add(listerTypesActivitesBtn);
		
		ajouterPermisActiviteBtn = new JButton("Associer un permis ");
		ajouterPermisActiviteBtn.setBounds(308, 258, 172, 42);
		add(ajouterPermisActiviteBtn);
		
		modifierPermisActiviteBtn = new JButton("Modifier une associtation P-A");
		modifierPermisActiviteBtn.setBounds(511, 256, 172, 42);
		add(modifierPermisActiviteBtn);
		
		supprimerPermisActiviteBtn = new JButton("Supprimer une association P-A");
		supprimerPermisActiviteBtn.setBounds(714, 256, 172, 42);
		add(supprimerPermisActiviteBtn);
		
		listerPermisActivitesBtn = new JButton("Lister les associations P-A");
		listerPermisActivitesBtn.setBounds(917, 256, 172, 42);
		add(listerPermisActivitesBtn);
		listerPermisActivitesBtn.addActionListener(frame.getActionListener());
		
		ajouterUniteBtn = new JButton("Ajouter une UO");
		ajouterUniteBtn.setBounds(308, 396, 172, 42);
		add(ajouterUniteBtn);
		
		modifierUniteBtn = new JButton("Modifier une UO");
		modifierUniteBtn.setBounds(511, 394, 172, 42);
		add(modifierUniteBtn);
		
		listerUnitesBtn = new JButton("Lister les UO");
		listerUnitesBtn.setBounds(308, 460, 172, 42);
		add(listerUnitesBtn);
		
		supprimerUniteBtn = new JButton("Supprimer une UO");
		supprimerUniteBtn.setBounds(511, 460, 172, 42);
		add(supprimerUniteBtn);
		
		rechercherUniteBtn = new JButton("Rechercher dans les UO");
		rechercherUniteBtn.setBounds(308, 527, 172, 42);
		add(rechercherUniteBtn);
		
		ajouterPrevisionBtn = new JButton("Ajouter une pr\u00E9vision");
		ajouterPrevisionBtn.setBounds(916, 396, 172, 42);
		add(ajouterPrevisionBtn);
		
		modifierPrevisionBtn = new JButton("Modifier une pr\u00E9vision");
		modifierPrevisionBtn.setBounds(1119, 394, 172, 42);
		add(modifierPrevisionBtn);
		
		supprimerPrevisionBtn = new JButton("supprimerPrevision");
		supprimerPrevisionBtn.setBounds(1119, 460, 172, 42);
		add(supprimerPrevisionBtn);
		
		listerPrevisionsBtn = new JButton("Lister les pr\u00E9visions");
		listerPrevisionsBtn.setBounds(916, 460, 172, 42);
		add(listerPrevisionsBtn);
		
		rechercherPrevisionBtn = new JButton("Rechercher dans les pr\u00E9visions");
		rechercherPrevisionBtn.setBounds(916, 527, 172, 42);
		add(rechercherPrevisionBtn);
		
		rechercherPermisBtn = new JButton("Rechercher dans les permis");
		rechercherPermisBtn.setBounds(1119, 72, 172, 42);
		add(rechercherPermisBtn);
		
		JButton rechercherTypeActiviteBtn = new JButton("Rechercher dans les types d'activite");
		rechercherTypeActiviteBtn.setBounds(1119, 163, 172, 42);
		add(rechercherTypeActiviteBtn);
		
		rechercherPermisActiviteBtn = new JButton("Rechercher dans les associations P-A");
		rechercherPermisActiviteBtn.setBounds(1119, 256, 172, 42);
		add(rechercherPermisActiviteBtn);
		
		ajouterSorgBtn = new JButton("Ajouter une structure");
		ajouterSorgBtn.setBounds(511, 527, 172, 42);
		add(ajouterSorgBtn);
		
		modifierSorgBtn = new JButton("Modifier une structure");
		modifierSorgBtn.setBounds(308, 597, 172, 42);
		add(modifierSorgBtn);
		
		supprimerSorgBtn = new JButton("Supprimer une structure");
		supprimerSorgBtn.setBounds(511, 595, 172, 42);
		add(supprimerSorgBtn);
		
		listerSorgBtn = new JButton("Lister les structures");
		listerSorgBtn.setBounds(308, 661, 172, 42);
		add(listerSorgBtn);
		
		rechercherSorgBtn = new JButton("Rechercher dans les structures");
		rechercherSorgBtn.setBounds(511, 661, 172, 42);
		add(rechercherSorgBtn);
	}

	public JButton getAjouterEffectifBtn() {
		return ajouterEffectifBtn;
	}

	public JButton getModifierEffectifBtn() {
		return modifierEffectifBtn;
	}

	public JButton getSupprimerEffectifBtn() {
		return supprimerEffectifBtn;
	}

	public JButton getListerEffectifsBtn() {
		return listerEffectifsBtn;
	}

	public JButton getRechercherEffectifBtn() {
		return rechercherEffectifBtn;
	}

	public JButton getAjouterPermisBtn() {
		return ajouterPermisBtn;
	}

	public JButton getAjouterTypeActiviteBtn() {
		return ajouterTypeActiviteBtn;
	}

	public JButton getAjouterPermisActiviteBtn() {
		return ajouterPermisActiviteBtn;
	}

	public JButton getModifierPermisBtn() {
		return modifierPermisBtn;
	}

	public JButton getModifierTypeActiviteBtn() {
		return modifierTypeActiviteBtn;
	}

	public JButton getModifierPermisActiviteBtn() {
		return modifierPermisActiviteBtn;
	}

	public JButton getSupprimerPermisActiviteBtn() {
		return supprimerPermisActiviteBtn;
	}

	public JButton getSupprimerTypeActiviteBtn() {
		return supprimerTypeActiviteBtn;
	}

	public JButton getSupprimerPermistn() {
		return supprimerPermistn;
	}

	public JButton getListerPermisActivitesBtn() {
		return listerPermisActivitesBtn;
	}

	public JButton getListerTypesActivitesBtn() {
		return listerTypesActivitesBtn;
	}

	public JButton getListerPermisBtn() {
		return listerPermisBtn;
	}

	public JButton getRechercherPermisBtn() {
		return rechercherPermisBtn;
	}

	public JButton getRechercherPermisActiviteBtn() {
		return rechercherPermisActiviteBtn;
	}

	public JButton getModifierPrevisionBtn() {
		return modifierPrevisionBtn;
	}

	public JButton getSupprimerPrevisionBtn() {
		return supprimerPrevisionBtn;
	}

	public JButton getRechercherPrevisionBtn() {
		return rechercherPrevisionBtn;
	}

	public JButton getListerPrevisionsBtn() {
		return listerPrevisionsBtn;
	}

	public JButton getAjouterPrevisionBtn() {
		return ajouterPrevisionBtn;
	}

	public JButton getRechercherSorgBtn() {
		return rechercherSorgBtn;
	}

	public JButton getSupprimerSorgBtn() {
		return supprimerSorgBtn;
	}

	public JButton getAjouterSorgBtn() {
		return ajouterSorgBtn;
	}

	public JButton getSupprimerUniteBtn() {
		return supprimerUniteBtn;
	}

	public JButton getModifierUniteBtn() {
		return modifierUniteBtn;
	}

	public JButton getListerSorgBtn() {
		return listerSorgBtn;
	}

	public JButton getModifierSorgBtn() {
		return modifierSorgBtn;
	}

	public JButton getRechercherUniteBtn() {
		return rechercherUniteBtn;
	}

	public JButton getListerUnitesBtn() {
		return listerUnitesBtn;
	}

	public JButton getAjouterUniteBtn() {
		return ajouterUniteBtn;
	}
}
