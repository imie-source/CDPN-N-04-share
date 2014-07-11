package org.imie.java.diamant;

public class CompVoitureHybride {
	
	private CompVoitureElectrique compVoitureElectrique;
	private CompVoitureEssence compVoitureEssence;
	
	
	
	public CompVoitureHybride(CompVoitureElectrique compVoitureElectrique,
			CompVoitureEssence compVoitureEssence) {
		super();
		this.compVoitureElectrique = compVoitureElectrique;
		this.compVoitureEssence = compVoitureEssence;
	}

	public void rouler(Integer km,IVoitureHybride voiture){
		if (km<20 && voiture.getCapaciteHRestante()>=(voiture.getConsomationHKm()*km)){
			compVoitureElectrique.rouler(km, voiture);
		}else{
			compVoitureEssence.rouler(km, voiture);
		}
	}

	public void rechargerReservoir(Integer litre,IVoitureEssence voiture) {
		compVoitureEssence.rechargerReservoir(litre, voiture);
	}
	
	public void rechargerBatterie(Integer temps,IVoitureElectrique voiture) {
		compVoitureElectrique.rechargerBatterie(temps, voiture);

	}
	
}
