package accesDonees;

import java.sql.Date;

public class TuplePrevision {
	private String previsioncode;
	private Date previsionDate;
	private String effectif;
	private String unite;
	private String typeActivite;
	private double quantite;
	private Date periodeDebut;
	private Date periodefin;
	
	
	public TuplePrevision() {
	}
	
	public TuplePrevision(String previsioncode, Date previsionDate, String effectif, String unite, String typeActivite,
			double quantite, Date periodeDebut, Date periodefin) {
		this.previsioncode = previsioncode;
		this.previsionDate = previsionDate;
		this.effectif = effectif;
		this.unite = unite;
		this.typeActivite = typeActivite;
		this.quantite = quantite;
		this.periodeDebut = periodeDebut;
		this.periodefin = periodefin;
	}
	public String getPrevisioncode() {
		return previsioncode;
	}
	public void setPrevisioncode(String previsioncode) {
		this.previsioncode = previsioncode;
	}
	public Date getPrevisionDate() {
		return previsionDate;
	}
	public void setPrevisionDate(Date previsionDate) {
		this.previsionDate = previsionDate;
	}
	public String getEffectif() {
		return effectif;
	}
	public void setEffectif(String effectif) {
		this.effectif = effectif;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public String getTypeActivite() {
		return typeActivite;
	}
	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}
	public Date getPeriodeDebut() {
		return periodeDebut;
	}
	public void setPeriodeDebut(Date periodeDebut) {
		this.periodeDebut = periodeDebut;
	}
	public Date getPeriodefin() {
		return periodefin;
	}
	public void setPeriodefin(Date periodefin) {
		this.periodefin = periodefin;
	}

}
