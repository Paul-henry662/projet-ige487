package presentation;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class AjouterEffectifPanel extends MecaPanel {
	private JTextField effMatrField;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField dateNaissField;
	private JLabel effMatrLabel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel dateNaissLabel;
	private JButton validerBtn;
	private JLabel titleLabel;

	/**
	 * Create the panel.
	 */
	public AjouterEffectifPanel(MecaFrame frame) {
		super(frame);
		setLayout(null);
		
		effMatrField = new JTextField();
		effMatrField.setBounds(297, 93, 118, 19);
		add(effMatrField);
		effMatrField.setColumns(10);
		
		nomField = new JTextField();
		nomField.setBounds(297, 138, 118, 19);
		add(nomField);
		nomField.setColumns(10);
		
		prenomField = new JTextField();
		prenomField.setBounds(297, 181, 118, 19);
		add(prenomField);
		prenomField.setColumns(10);
		
		dateNaissField = new JTextField();
		dateNaissField.setBounds(297, 228, 118, 19);
		add(dateNaissField);
		dateNaissField.setColumns(10);
		
		effMatrLabel = new JLabel("Matricule");
		effMatrLabel.setBounds(182, 96, 45, 13);
		add(effMatrLabel);
		
		nomLabel = new JLabel("Nom");
		nomLabel.setBounds(182, 141, 45, 13);
		add(nomLabel);
		
		prenomLabel = new JLabel("Prenom");
		prenomLabel.setBounds(182, 184, 45, 13);
		add(prenomLabel);
		
		dateNaissLabel = new JLabel("Date de naissance");
		dateNaissLabel.setBounds(182, 231, 105, 13);
		add(dateNaissLabel);
		
		validerBtn = new JButton("Ajouter");
		validerBtn.setBounds(243, 297, 99, 34);
		add(validerBtn);
		validerBtn.addActionListener(frame.getActionListener());
		
		titleLabel = new JLabel("Ajouter un effectif");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(182, 21, 190, 34);
		add(titleLabel);
	}

	public JTextField getEffMatrField() {
		return effMatrField;
	}

	public void setEffMatrField(JTextField effMatrField) {
		this.effMatrField = effMatrField;
	}

	public JTextField getNomField() {
		return nomField;
	}

	public void setNomField(JTextField nomField) {
		this.nomField = nomField;
	}

	public JTextField getPrenomField() {
		return prenomField;
	}

	public void setPrenomField(JTextField prenomField) {
		this.prenomField = prenomField;
	}

	public JTextField getDateNaissField() {
		return dateNaissField;
	}

	public void setDateNaissField(JTextField dateNaissField) {
		this.dateNaissField = dateNaissField;
	}

	public JLabel getDateNaissLabel() {
		return dateNaissLabel;
	}

	public void setDateNaissLabel(JLabel dateNaissLabel) {
		this.dateNaissLabel = dateNaissLabel;
	}

	public JButton getValiderBtn() {
		return validerBtn;
	}

	public void setValiderBtn(JButton validerBtn) {
		this.validerBtn = validerBtn;
	}

}
