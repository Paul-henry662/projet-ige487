package presentation;

public class HomePanel extends MecaPanel {
	
	private MecaButton btnGestionEffectifs;
	private MecaButton btnGestionActivites;
	private MecaButton btnGestionUnites;
	private MecaButton btnGestionPrevisions;
	private MecaButton btnRetour;
	
	public HomePanel(Meca meca) {
		super(meca);
		
		this.btnGestionEffectifs = new MecaButton(this, "Gestion ECA");
		this.btnGestionActivites = new MecaButton(this, "Gestion Activités");
		this.btnGestionUnites = new MecaButton(this, "Gestion UO");
		this.btnGestionPrevisions = new MecaButton(this, "Gestion Prévisions");
		
		this.add(btnGestionEffectifs);
		this.add(btnGestionActivites);
		this.add(btnGestionUnites);
		this.add(btnGestionPrevisions);
	}

	public MecaButton getBtnGestionEffectifs() {
		return btnGestionEffectifs;
	}

	public MecaButton getBtnGestionActivites() {
		return btnGestionActivites;
	}

	public MecaButton getBtnGestionUnites() {
		return btnGestionUnites;
	}

	public MecaButton getBtnGestionPrevisions() {
		return btnGestionPrevisions;
	}

}
