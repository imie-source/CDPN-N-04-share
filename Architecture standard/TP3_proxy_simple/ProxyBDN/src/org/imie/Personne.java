package org.imie;

import javax.management.RuntimeErrorException;

public class Personne {

	Boolean tennis;
	String prenom;
	Integer argent=0;
	Double gAlcool=0.0;
	Boolean propre;

	public Boolean getTennis() {
		return tennis;
	}

	public void setTennis(Boolean tennis) {
		this.tennis = tennis;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getArgent() {
		return argent;
	}

	public void setArgent(Integer argent) {
		this.argent = argent;
	}

	public Double getgAlcool() {
		return gAlcool;
	}

	public void setgAlcool(Double gAlcool) {
		this.gAlcool = gAlcool;
	}

	public Boolean getPropre() {
		return propre;
	}

	public void setPropre(Boolean propre) {
		this.propre = propre;
	}
	
	public void seRabiller(){
		System.out.println(Personne.class + ": ok, je me rabille");
		propre=true;
	}
	
	public void payer(Integer montant){
		if(argent>montant){
		argent=argent-montant;
		System.out.printf(Personne.class + ": %d Euros payé\n", montant);
		System.out.printf(Personne.class + ": il reste %d Euros\n", argent);
		}else{
			System.out.println(Personne.class + ": j'ai pas assez d'argent");
			throw new RuntimeException();
		}
	}
	
	public void boir(){
		gAlcool=gAlcool+0.25;
		System.out.println(Personne.class + ":glou glou");
	}

}
