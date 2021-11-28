package presentation;

import java.util.List;

import accesDonees.TupleEffectif;

public class ListerEffectifsPanel extends MecaPanel {
	
	private static final long serialVersionUID = 1L;
	
	private MecaTable listeEffectifsTable; 

	public ListerEffectifsPanel(Meca meca) {
		super(meca);
		 
		listeEffectifsTable = new MecaTable();
		this.add(listeEffectifsTable);
		this.validate();
	}
	
	public void setTableData(List<TupleEffectif> effectifs) {

	}
}
