package presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class RechercheEffectifPanel extends MecaPanel {
	private JButton byMatrBtn;
	private JButton byNomBtn;
	private JButton byPrenomBtn;
	private JButton byDateNaissBtn;

	/**
	 * Create the panel.
	 */
	public RechercheEffectifPanel(MecaFrame frame) {
		super(frame);
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Rechercher dans les effectifs");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(170, 10, 266, 37);
		add(titleLabel);
		
		byMatrBtn = new JButton("Par matricule");
		byMatrBtn.setBounds(228, 57, 126, 37);
		add(byMatrBtn);
		
		byNomBtn = new JButton("Par nom");
		byNomBtn.setBounds(228, 139, 126, 37);
		add(byNomBtn);
		
		byPrenomBtn = new JButton("Par Prenom");
		byPrenomBtn.setBounds(228, 221, 126, 37);
		add(byPrenomBtn);
		
		byDateNaissBtn = new JButton("Par date de naissance");
		byDateNaissBtn.setBounds(228, 303, 126, 37);
		add(byDateNaissBtn);
	}

	public JButton getByMatrBtn() {
		return byMatrBtn;
	}

	public void setByMatrBtn(JButton byMatrBtn) {
		this.byMatrBtn = byMatrBtn;
	}

	public JButton getByNomBtn() {
		return byNomBtn;
	}

	public void setByNomBtn(JButton byNomBtn) {
		this.byNomBtn = byNomBtn;
	}

	public JButton getByPrenomBtn() {
		return byPrenomBtn;
	}

	public void setByPrenomBtn(JButton byPrenomBtn) {
		this.byPrenomBtn = byPrenomBtn;
	}

	public JButton getByDateNaissBtn() {
		return byDateNaissBtn;
	}

	public void setByDateNaissBtn(JButton byDateNaissBtn) {
		this.byDateNaissBtn = byDateNaissBtn;
	}

}
