package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MecaFrame extends JFrame {
	
	private Meca meca;

	/**
	 * Create the frame.
	 */
	public MecaFrame(Meca meca) {
		this.meca = meca;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1521, 833);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public Meca getActionListener() {
		return this.meca;
	}
	
	public void switchPanel(MecaPanel panel) {
		this.getContentPane().removeAll();
		getContentPane().add(panel);
		this.validate();
		this.repaint();
	}
	
	public void displayError(String message) {
		JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	public void displaySuccess(String message) {
		JOptionPane.showMessageDialog(this, message, "Succes", JOptionPane.INFORMATION_MESSAGE);
	}
}
