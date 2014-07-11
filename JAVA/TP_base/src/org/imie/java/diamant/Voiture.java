/**
 * 
 */
package org.imie.java.diamant;


/**
 * @author imie
 *
 */
public class Voiture implements IVoiture {

	private Integer kilometrage=0;
	private CompVoiture compVoiture;
	
	
	public Voiture(){
		
	}
	
	public Voiture(CompVoiture compVoiture) {
		super();
		this.compVoiture = compVoiture;
	}


	/* (non-Javadoc)
	 * @see org.imie.java.diamant.IVoiture#rouler(java.lang.Integer)
	 */
	@Override
	public void rouler(Integer km) {
		compVoiture.rouler(km, this);

	}

	
	@Override
	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}


	/* (non-Javadoc)
	 * @see org.imie.java.diamant.IVoiture#getKilometrage()
	 */
	@Override
	public Integer getKilometrage() {
		return kilometrage;
	}

	@Override
	public void printState() {
		System.out.println(String.format("la voiture à parcouru %d km",kilometrage));
		
	}
	

}
