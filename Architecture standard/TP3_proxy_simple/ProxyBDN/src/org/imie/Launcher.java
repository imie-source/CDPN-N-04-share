package org.imie;

public class Launcher {

	public static void main(String[] args) {
		Personne personne = new Personne();
		personne.setTennis(false);
		personne.setPropre(false);
		personne.setArgent(100);
		IBDN BDN = new BDNSecu (new BDN());
		BDN.entrer(personne);
		BDN.boire(personne);
		BDN.boire(personne);
		BDN.boire(personne);
		BDN.sortir(personne);
		

	}

}
