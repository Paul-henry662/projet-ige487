package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginFrame extends JFrame {

	private Meca meca;
	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
	private JButton connexionBtn;

	/**
	 * Create the frame.
	 */
	public LoginFrame(Meca meca) {
		setTitle("Connexion");
		this.meca = meca;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		connexionBtn = new JButton("Connexion");
		connexionBtn.setBounds(146, 171, 116, 21);
		connexionBtn.addActionListener(meca);
		contentPane.add(connexionBtn);
		
		userField = new JTextField();
		userField.setBounds(219, 72, 96, 19);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JTextField();
		passField.setBounds(219, 115, 96, 19);
		contentPane.add(passField);
		passField.setColumns(10);
		
		JLabel userLabel = new JLabel("Nom d'utilisateur");
		userLabel.setBounds(93, 75, 116, 13);
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("Mot de passe");
		passLabel.setBounds(93, 118, 116, 13);
		contentPane.add(passLabel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JTextField getUserField() {
		return userField;
	}

	public JTextField getPassField() {
		return passField;
	}
	
	public void displayError(String message) {
		JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	public void displaySuccess(String message) {
		JOptionPane.showMessageDialog(this, message, "Succes", JOptionPane.INFORMATION_MESSAGE);
	}

	public JButton getConnexionBtn() {
		return connexionBtn;
	}

}
