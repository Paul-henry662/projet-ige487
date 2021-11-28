package presentation;

import javax.swing.JTextField;

public class MecaTextField extends JTextField{
	
	private static int FIELD_WIDTH = 10;
	
	public MecaTextField() {
		this.setColumns(FIELD_WIDTH);
	}
	
	public MecaTextField(String text) {
		this.setColumns(FIELD_WIDTH);
		this.setText(text);
	}
}
