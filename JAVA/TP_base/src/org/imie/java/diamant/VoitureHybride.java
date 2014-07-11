package org.imie.java.diamant;


public class VoitureHybride extends Voiture implements IVoitureHybride {

	private CompVoitureHybride compVoitureHybride;
	
	private Integer capaciteLRestante=0;
	private final Integer capaciteLMax;
	private final Integer consomationLKm;
	private Integer capaciteHRestante=0;
	private final Integer capaciteHMax;
	private final Integer consomationHKm;
	
	public VoitureHybride(CompVoitureHybride compVoitureHybride,Integer capaciteLMax,Integer consomationLKm,Integer capaciteHMax,Integer consomationHKm) {
		super();
		this.compVoitureHybride = compVoitureHybride;
		this.capaciteLMax=capaciteLMax;
		this.consomationLKm=consomationLKm;
		this.capaciteHMax=capaciteHMax;
		this.consomationHKm=consomationHKm;
	}

	@Override
	public void rechargerReservoir(Integer litre) {
		compVoitureHybride.rechargerReservoir(litre, this);

	}

	@Override
	public Integer getCapaciteLRestante() {
		
		return capaciteLRestante;
	}

	@Override
	public void rouler(Integer km) {
		compVoitureHybride.rouler(km, this);

	}

	@Override
	public void rechargerBatterie(Integer temps) {
		compVoitureHybride.rechargerBatterie(temps, this);

	}

	@Override
	public Integer getCapaciteHRestante() {
		// TODO Auto-generated method stub
		return capaciteHRestante;
	}


	@Override
	public Integer getCapaciteHMax() {
		// TODO Auto-generated method stub
		return capaciteHMax;
	}

	@Override
	public void setCapaciteHRestante(Integer capaciteHRestante) {
		this.capaciteHRestante = capaciteHRestante;
		
	}

	@Override
	public Integer getConsomationHKm() {
		// TODO Auto-generated method stub
		return consomationHKm;
	}

	@Override
	public void printState() {
		System.out.println(String.format("il reste %d unité electrique",capaciteHRestante));
		System.out.println(String.format("il reste %d centilitre d'essence",capaciteLRestante));
		super.printState();
		
	}

	@Override
	public Integer getCapaciteLMax() {
		// TODO Auto-generated method stub
		return capaciteLMax;
	}

	@Override
	public Integer getConsomationLKm() {
		// TODO Auto-generated method stub
		return consomationLKm;
	}

	@Override
	public void setCapaciteLRestante(Integer capaciteLRestante) {
		this.capaciteLRestante=capaciteLRestante;
		
	}

}
