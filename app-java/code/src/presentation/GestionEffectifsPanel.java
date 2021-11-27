package presentation;

public class GestionEffectifsPanel extends MecaPanel {
	
	private MecaButton btnAjouterEffectif;
	private MecaButton btnSupprimerEffectif;
	private MecaButton btnModifierEffectif;
	private MecaButton btnListerEffectifs;
	private MecaButton btnRetour;
	
	public GestionEffectifsPanel(Meca meca) {
		super(meca);
		
		btnAjouterEffectif = new MecaButton(this, "Ajouter effectif");
		btnSupprimerEffectif = new MecaButton(this, "Supprimer effectif");
		btnModifierEffectif = new MecaButton(this, "Modifier effectif");
		btnListerEffectifs = new MecaButton(this, "Lister effectifs");
		btnRetour = new MecaButton(this, "Retour");
		
		this.add(btnAjouterEffectif);
		this.add(btnSupprimerEffectif);
		this.add(btnModifierEffectif);
		this.add(btnListerEffectifs);
		this.add(btnRetour);
	}

	public MecaButton getBtnAjouterEffectif() {
		return btnAjouterEffectif;
	}

	public MecaButton getBtnSupprimerEffectif() {
		return btnSupprimerEffectif;
	}

	public MecaButton getBtnModifierEffectif() {
		return btnModifierEffectif;
	}

	public MecaButton getBtnListerEffectifs() {
		return btnListerEffectifs;
	}

	public MecaButton getBtnRetour() {
		return btnRetour;
	}

}
