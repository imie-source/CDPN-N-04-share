package org.imie.java.diamant;

public class Launcher {

	public static void main(String[] args) {
		CompVoiture compVoiture= new CompVoiture();
		CompVoitureElectrique compVoitureElectrique = new CompVoitureElectrique(compVoiture);
		CompVoitureEssence compVoitureEssence = new CompVoitureEssence(compVoiture);
		CompVoitureHybride compVoitureHybride = new CompVoitureHybride(compVoitureElectrique,compVoitureEssence);
		IVoitureHybride voiture = new VoitureHybride(compVoitureHybride,6000,7,2000,20);
		//		IVoitureEssence voiture= new VoitureEssence(6000,7);
		//voiture.rechargerReservoir(4000);
		voiture.rechargerBatterie(1000);
		voiture.rechargerReservoir(1000);
		voiture.rouler(100);
		voiture.printState();
		voiture.rouler(15);
		voiture.printState();
		voiture.rouler(15);
		voiture.printState();
		voiture.rouler(15);
		voiture.printState();
		
		voiture.rouler(15);
		voiture.printState();
		
		

	}

}
