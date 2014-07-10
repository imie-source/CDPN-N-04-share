package org.imie.java;

import java.util.Random;

public class Ex25 {
	
	public enum Etat{
		obstacle('X'),dame('O');
		
		Character affichage;
		Etat(Character affichage){
			this.affichage=affichage;
		}
		public Character getAffichage() {
			return affichage;
		}
		
	}

	public static Integer nbDeplacement (Integer depX, Integer depY,Integer posX,Integer posY,Etat[][] plateau){
		Integer retour = 0;
		posX+=depX;
		posY+=depY;
		while (posX>=0 && posX<8 && posY>=0 && posY<8 && plateau[posX][posY]==null) {
			retour ++;
			posX+=depX;
			posY+=depY;
			
		}
		return retour;
	}
	
	public static void main(String[] args) {
		Etat[][] plateau = new Etat[8][8];
		for (Integer i= 0;i<=8;i++){
			Integer posX = new Random().nextInt(8);
			Integer posY = new Random().nextInt(8);
			if (plateau[posX][posY]==null){
				plateau[posX][posY]=Etat.obstacle;
			}else{
				i--;
			}
		}
		
		Integer posXDame = new Random().nextInt(8);
		Integer posYDame = new Random().nextInt(8);
		plateau[posXDame][posYDame]=Etat.dame;
		
		displayPlateau(plateau);
		
		Integer nbDep = 0;
		nbDep+=nbDeplacement(1, 1, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(1, 0, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(1, -1, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(0, -1, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(-1, -1, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(-1, 0, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(-1, 1, posXDame, posYDame, plateau);
		nbDep+=nbDeplacement(0, 1, posXDame, posYDame, plateau);
		System.out.println(nbDep);
		
		
		

	}

	private static void displayPlateau(Etat[][] plateau) {
		for (int i = 0; i < 8; i++) {
			System.out.print("--");
		}
		System.out.println("-");
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				//System.out.print(plateau[i][j]);
				Character aff=' ';
				if(plateau[i][j]!=null){
					aff= plateau[i][j].getAffichage();
				}
				System.out.print("|"+aff);	
				//System.out.print("|X");	
			}
			System.out.println("|");
			for (int j = 0; j < 8; j++) {
				System.out.print("--");
			}
			System.out.println("-");
		}
		System.out.println("");
	}

}
