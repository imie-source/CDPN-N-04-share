package org.imie;

public class BDNSecu implements IBDN {

	private IBDN bdn;

	public BDNSecu(BDN bdn) {
		super();
		this.bdn = bdn;
	}

	@Override
	public void entrer(Personne personne) {
		if (personne.getTennis()) {
			System.out.println(BDNSecu.class
					+ ": T'as des tennis, Tu rentres pas");
		} else {
			if (!personne.getPropre()) {
				personne.seRabiller();
			}
			try {
				bdn.entrer(personne);
			} catch (Exception e) {
				this.sortir(personne);
			}
		}

	}

	@Override
	public void boire(Personne personne) {
		if (personne.getgAlcool() > 2) {
			System.out.println(BDNSecu.class + ": t"
					+ "T'as trop bu pour boire encore");
		} else {
			try {
				bdn.boire(personne);
				if (personne.getArgent() < 0) {
					this.sortir(personne);
				}
			} catch (Exception e) {
				this.sortir(personne);

			}
		}

	}

	@Override
	public void sortir(Personne personne) {
		bdn.sortir(personne);
		if (personne.getgAlcool() > 0.5) {
			System.out.println(BDNSecu.class
					+ ": Obligation de prendre un taxi");
		} else {
			System.out.println(BDNSecu.class + ": Bonne nuit");
		}

	}

}
