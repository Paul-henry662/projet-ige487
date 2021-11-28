package presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MecaFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "MECA";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public MecaFrame() {
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void switchPanel(MecaPanel panel) {
		this.getContentPane().removeAll();
		this.add(panel);
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
