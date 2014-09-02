package org.imie;

public class BDN implements IBDN {

	@Override
	public void entrer(Personne personne) {
		System.out.println(BDN.class + ": Bonjour");
		personne.payer(20);
		
	}

	@Override
	public void boire(Personne personne) {
		System.out.println(BDN.class + ": 20E pour votre boisson svp");
		personne.payer(20);
		System.out.println(BDN.class + ": voici votre verre");
		personne.boir();
	}

	@Override
	public void sortir(Personne personne) {
		System.out.println(BDN.class + ": Bonne nuit");
		
	}

}
