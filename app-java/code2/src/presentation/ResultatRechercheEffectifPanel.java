package presentation;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ResultatRechercheEffectifPanel extends MecaPanel {
	private static final String[] EFFECTIF_ENTETE = {"Matricule", "Nom", "Prenom", "Date de naissance"};
	
	private String[][] tableData = {
			{"000001", "azerty", "Azerty", "2002-06-06"}
	};

	/**
	 * Create the panel.
	 */
	public ResultatRechercheEffectifPanel(MecaFrame frame) {
		super(frame);
		setLayout(null);
	}
}
