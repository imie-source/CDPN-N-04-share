package org.imie.java.diamant;

public interface IVoitureElectrique extends IVoiture {
	
	public void rechargerBatterie(Integer temps);

	Integer getCapaciteHRestante();

	Integer getCapaciteHMax();

	void setCapaciteHRestante(Integer capaciteHRestante);

	Integer getConsomationHKm();

}
