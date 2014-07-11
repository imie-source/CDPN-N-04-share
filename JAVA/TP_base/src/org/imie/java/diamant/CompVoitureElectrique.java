/**
 * 
 */
package org.imie.java.diamant;

/**
 * @author imie
 *
 */
public class CompVoitureElectrique  {

	private CompVoiture compVoiture;

	

	public CompVoitureElectrique(CompVoiture compVoiture) {
		super();
		this.compVoiture = compVoiture;
	}

	/**
	 * @param km
	 * @param voiture
	 */
	public void rouler(Integer km,IVoitureElectrique voiture) {
		if (voiture.getCapaciteHRestante()>=(km*voiture.getConsomationHKm())){
			voiture.setCapaciteHRestante(voiture.getCapaciteHRestante()-(km*voiture.getConsomationHKm()));
			compVoiture.rouler(km,voiture);
		}else{
			System.out.println("pas assez d'energie");
		}
		

	}

	public void rechargerBatterie(Integer temps,IVoitureElectrique voiture) {
		voiture.setCapaciteHRestante(Math.min(voiture.getCapaciteHMax(),voiture.getCapaciteHRestante()+temps));


	}
	
	

}
