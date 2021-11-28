package presentation;

import java.awt.Color;

import javax.swing.JButton;

public class MecaButton extends JButton{
	private MecaPanel panel;
	
	public MecaButton(MecaPanel panel, String text) {
		this.panel = panel;
		this.setText(text);
		this.addActionListener(this.panel.meca);
		this.setFocusable(false);
	}
}
