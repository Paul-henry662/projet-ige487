package meca;

public class TupleUnite {
	private String uniteCode;
	private String uniteNom;
	
	
	public TupleUnite() {
	}
	
	public TupleUnite(String uniteCode, String uniteNom) {
		this.uniteCode = uniteCode;
		this.uniteNom = uniteNom;
	}
	public String getUniteCode() {
		return uniteCode;
	}
	public void setUnitecode(String uniteCode) {
		this.uniteCode = uniteCode;
	}
	public String getUniteNom() {
		return uniteNom;
	}
	public void setUniteNom(String uniteNom) {
		this.uniteNom = uniteNom;
	}

}
