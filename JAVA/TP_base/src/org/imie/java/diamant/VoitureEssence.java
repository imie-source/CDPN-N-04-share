/**
 * 
 */
package org.imie.java.diamant;

/**
 * @author imie
 *
 */
public class VoitureEssence extends Voiture implements IVoitureEssence {

	private Integer capaciteLRestante=0;
	private final Integer capaciteLMax;
	private final Integer consomationKm;
	private final CompVoitureEssence compVoitureEssence;
	
	public VoitureEssence (Integer capaciteLMax,Integer consomationKm,CompVoitureEssence compVoitureEssence){
		super();
		this.capaciteLMax = capaciteLMax;
		this.consomationKm = consomationKm;
		this.compVoitureEssence = compVoitureEssence;
	}
	
	
	/* (non-Javadoc)
	 * @see org.imie.java.diamant.IVoitureEssence#rechargerReservoir(java.lang.Integer)
	 */
	@Override
	public void rechargerReservoir(Integer litre) {
		compVoitureEssence.rechargerReservoir(litre, this);

	}
	
	

	/* (non-Javadoc)
	 * @see org.imie.java.diamant.Voiture#rouler(java.lang.Integer)
	 */
	@Override
	public void rouler(Integer km) {
		compVoitureEssence.rouler(km, this);
	}


	/* (non-Javadoc)
	 * @see org.imie.java.diamant.IVoitureEssence#getCapaciteLRestante()
	 */
	@Override
	public Integer getCapaciteLRestante() {

		return capaciteLRestante;
	}


	/**
	 * @return the capaciteLMax
	 */
	@Override
	public Integer getCapaciteLMax() {
		return capaciteLMax;
	}


	/**
	 * @return the consomationKm
	 */
	@Override
	public Integer getConsomationLKm() {
		return consomationKm;
	}


	/**
	 * @param capaciteLRestante the capaciteLRestante to set
	 */
	@Override
	public void setCapaciteLRestante(Integer capaciteLRestante) {
		this.capaciteLRestante = capaciteLRestante;
	}
	
	@Override
	public void printState() {
		System.out.println(String.format("il reste %d centilitre d'essence",capaciteLRestante));
		super.printState();
	}
	

}
