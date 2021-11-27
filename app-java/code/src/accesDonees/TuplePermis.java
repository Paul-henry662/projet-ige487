package accesDonees;

import java.sql.Date;

public class TuplePermis {
	private String permiscode;
	private String effectif; 
	private Date validedebut;
	private Date validefin;
	
	
	public TuplePermis() {
	}
	
	public TuplePermis(String permiscode, String effectif, Date validedebut, Date validefin) {
		this.permiscode = permiscode;
		this.effectif = effectif;
		this.validedebut = validedebut;
		this.validefin = validefin;
	}
	public String getPermiscode() {
		return permiscode;
	}
	public void setPermiscode(String permiscode) {
		this.permiscode = permiscode;
	}
	public String getEffectif() {
		return effectif;
	}
	public void setEffectif(String effectif) {
		this.effectif = effectif;
	}
	public Date getValidedebut() {
		return validedebut;
	}
	public void setValidedebut(Date validedebut) {
		this.validedebut = validedebut;
	}
	public Date getValidefin() {
		return validefin;
	}
	public void setValidefin(Date validefin) {
		this.validefin = validefin;
	}
	

}
