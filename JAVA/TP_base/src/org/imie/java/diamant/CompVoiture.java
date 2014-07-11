package org.imie.java.diamant;

public class CompVoiture {

	public void rouler(Integer km, IVoiture voiture) {
		voiture.setKilometrage(voiture.getKilometrage()+km);
		
	}

}
