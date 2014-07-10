package org.imie.java;

public class Ex20 {

	public enum Piece {
		cinquante(50,"50 Cents"), vingt(20,"20 cents"),dix(10,"10 cents"), cinq(5,"5 Cents"), deux(2,"2 Cents");

		private Integer value;
		private String affichage;

		Piece(Integer value,String Affichage) {
			this.value = value;
			this.affichage= Affichage;
		}

		public Integer getValue() {
			return value;
		}

		public String getAffichage() {
			return affichage;
		}
		

	}

	public static void calculePiece(Integer indice, Integer reste,
			String precedent) {
		Integer valuePiece = Piece.values()[indice].getValue();
		Integer maxPiece = (int) Math.floor(reste / valuePiece);
		String courant = null;
		for (Integer nbPiece = maxPiece; nbPiece >= 0; nbPiece--) {
			courant = precedent.concat(nbPiece.toString()).concat(" * ")
					.concat(Piece.values()[indice].getAffichage());
			Integer resteAutrePiece = reste - (nbPiece * valuePiece);
			if (resteAutrePiece == 0) {
				System.out.println(courant);
			} else {
				if (indice < Piece.values().length - 1) {
					courant = courant.concat(" + ");
					calculePiece(indice + 1, resteAutrePiece, courant);
				}
			}
		}
	}

	public static void main(String[] args) {

		calculePiece(0, 100, "");
	}

}
