/**
 * 
 */
package org.imie.java.diamant;

/**
 * @author imie
 *
 */
public class CompVoitureEssence  {

	private CompVoiture compVoiture;

	

	public CompVoitureEssence(CompVoiture compVoiture) {
		super();
		this.compVoiture = compVoiture;
	}

	/**
	 * @param km
	 * @param voiture
	 */
	public void rouler(Integer km,IVoitureEssence voiture) {
		if (voiture.getCapaciteLRestante()>=(km*voiture.getConsomationLKm())){
		voiture.setCapaciteLRestante(voiture.getCapaciteLRestante()- (km*voiture.getConsomationLKm()));	
		compVoiture.rouler(km,voiture);
		}else{
			System.out.println("pas assez d'essence");
		}
		

	}

	public void rechargerReservoir(Integer litre,IVoitureEssence voiture) {
		voiture.setCapaciteLRestante(Math.min(voiture.getCapaciteLMax(),voiture.getCapaciteLRestante()+litre));


	}
	
	

}
