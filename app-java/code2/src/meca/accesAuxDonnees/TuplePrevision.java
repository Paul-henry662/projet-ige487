package meca.accesAuxDonnees;

public class TuplePrevision {

	private String previsionCode;
	private Date previsionDate;
	private String effectif;
	private String unite;
	private String typeActivite;
	private double quantite;
	private Date periodeDebut;
	private Date periodeFin;

	public TuplePrevision() {
		// TODO - implement TuplePrevision.TuplePrevision
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param previsionCode
	 * @param previsionDate
	 * @param effectif
	 * @param unite
	 * @param typeActivite
	 * @param quantite
	 * @param periodeDebut
	 * @param periodeFin
	 */
	public TuplePrevision(String previsionCode, Date previsionDate, String effectif, String unite, String typeActivite, double quantite, Date periodeDebut, Date periodeFin) {
		// TODO - implement TuplePrevision.TuplePrevision
		throw new UnsupportedOperationException();
	}

	public String getPrevisionCode() {
		return this.previsionCode;
	}

	/**
	 * 
	 * @param previsionCode
	 */
	public void setPrevisionCode(String previsionCode) {
		this.previsionCode = previsionCode;
	}

	public Date getPrevisionDate() {
		return this.previsionDate;
	}

	/**
	 * 
	 * @param previsionDate
	 */
	public void setPrevisionDate(Date previsionDate) {
		this.previsionDate = previsionDate;
	}

	public String getEffectif() {
		return this.effectif;
	}

	/**
	 * 
	 * @param effectif
	 */
	public void setEffectif(String effectif) {
		this.effectif = effectif;
	}

	public String getUnite() {
		return this.unite;
	}

	/**
	 * 
	 * @param unite
	 */
	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getTypeActivite() {
		return this.typeActivite;
	}

	/**
	 * 
	 * @param typeActivite
	 */
	public void setTypeActivite(String typeActivite) {
		this.typeActivite = typeActivite;
	}

	public double getQuantite() {
		return this.quantite;
	}

	/**
	 * 
	 * @param quantite
	 */
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public Date getPeriodeDebut() {
		return this.periodeDebut;
	}

	/**
	 * 
	 * @param periodeDebut
	 */
	public void setPeriodeDebut(Date periodeDebut) {
		this.periodeDebut = periodeDebut;
	}

	public Date getPeriodeFin() {
		return this.periodeFin;
	}

	/**
	 * 
	 * @param periodeFin
	 */
	public void setPeriodeFin(Date periodeFin) {
		this.periodeFin = periodeFin;
	}

}