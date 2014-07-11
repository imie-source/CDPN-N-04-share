package org.imie.java.diamant;

public interface IVoiture {
	public void rouler(Integer km);

	public Integer getKilometrage();

	void setKilometrage(Integer kilometrage);
	
	public void printState();

}
