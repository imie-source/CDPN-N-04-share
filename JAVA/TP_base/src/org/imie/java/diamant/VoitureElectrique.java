/**
 * 
 */
package org.imie.java.diamant;

/**
 * @author imie
 *
 */
public class VoitureElectrique extends Voiture implements IVoitureElectrique {

	private Integer capaciteHRestante=0;
	private final Integer capaciteHMax;
	private final Integer consomationKm;
	private final CompVoitureElectrique compVoitureElectrique;
	
	public VoitureElectrique (Integer capaciteHMax,Integer consomationKm,CompVoitureElectrique compVoitureElectrique){
		super();
		this.capaciteHMax = capaciteHMax;
		this.consomationKm = consomationKm;
		this.compVoitureElectrique=compVoitureElectrique;
	}
	
	/* (non-Javadoc)
	 * @see org.imie.java.diamant.IVoiture#rouler(java.lang.Integer)
	 */
	@Override
	public void rouler(Integer km) {
		compVoitureElectrique.rouler(km, this);
		

	}

	/* (non-Javadoc)
	 * @see org.imie.java.diamant.IVoitureEletrique#rechargerBatterie(java.lang.Integer)
	 */
	@Override
	public void rechargerBatterie(Integer temps) {
		compVoitureElectrique.rechargerBatterie(temps, this);

	}

	@Override
	public Integer getCapaciteHRestante() {
		return capaciteHRestante;
	}

	/**
	 * @return the capaciteHMax
	 */
	@Override
	public Integer getCapaciteHMax() {
		return capaciteHMax;
	}

	/**
	 * @return the consomationKm
	 */
	@Override
	public Integer getConsomationHKm() {
		return consomationKm;
	}

	/**
	 * @param capaciteHRestante the capaciteHRestante to set
	 */
	@Override
	public void setCapaciteHRestante(Integer capaciteHRestante) {
		this.capaciteHRestante = capaciteHRestante;
	}

	/* (non-Javadoc)
	 * @see org.imie.java.diamant.Voiture#printState()
	 */
	@Override
	public void printState() {
		System.out.println(String.format("il reste %d unité electrique",capaciteHRestante));
		super.printState();
	}
	
	
	
	

}
