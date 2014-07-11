package org.imie.java.diamant;

public interface IVoitureEssence extends IVoiture {
	public void rechargerReservoir(Integer litre);

	Integer getCapaciteLRestante();

	Integer getCapaciteLMax();

	Integer getConsomationLKm();

	void setCapaciteLRestante(Integer capaciteLRestante);
}
