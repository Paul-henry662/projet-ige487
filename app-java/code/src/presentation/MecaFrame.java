package presentation;

import javax.swing.JFrame;

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
		this.setVisible(true);
	}
	
	public void switchPanel(MecaPanel panel) {
		this.getContentPane().removeAll();
		this.add(panel);
		this.validate();
		this.repaint();
	}
}
