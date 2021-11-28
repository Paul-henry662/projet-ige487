package presentation;

public class AjouterEffectifPanel extends MecaPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MecaLabel matrLabel;
	private MecaLabel nomLabel;
	private MecaLabel prenomLabel;
	private MecaLabel dateNaissLabel;
	
	private MecaTextField matrField;
	private MecaTextField nomField;
	private MecaTextField prenomField;
	private MecaTextField dateNaissField;
	private MecaButton validerBtn;
	private MecaButton retourBtn;
	
	public AjouterEffectifPanel(Meca meca) {
		super(meca);
		
		this.matrLabel = new MecaLabel("Matricule");
		this.nomLabel = new MecaLabel("Nom");
		this.prenomLabel = new MecaLabel("Prenom");
		this.dateNaissLabel = new MecaLabel("Date de naissance (yyyy-mm-dd)");
		
		this.matrField = new MecaTextField();
		this.nomField = new MecaTextField();
		this.prenomField = new MecaTextField();
		this.dateNaissField = new MecaTextField();
		

		this.validerBtn = new MecaButton(this, "Ajouter");
		this.retourBtn = new MecaButton(this, "Retour");
		
		this.add(matrLabel);
		this.add(matrField);
		
		this.add(nomLabel);
		this.add(nomField);
		
		this.add(prenomLabel);
		this.add(prenomField);
		
		this.add(dateNaissLabel);
		this.add(dateNaissField);
		
		this.add(validerBtn);
		this.add(retourBtn);
	}

	public MecaTextField getMatrField() {
		return matrField;
	}

	public MecaTextField getNomField() {
		return nomField;
	}

	public MecaTextField getPrenomField() {
		return prenomField;
	}

	public MecaTextField getDateNaissField() {
		return dateNaissField;
	}

	public MecaButton getValiderBtn() {
		return validerBtn;
	}
	
	public MecaButton getRetourBtn() {
		return retourBtn;
	}

}
