package org.imie.java;

public class Ex6 {

	public static Integer fact(Integer p){
		Integer retour = null;
		if(p<=1){
			retour=1;
		}else{
			retour = p * fact(p-1);
		}
		return retour;
	}
	
	public static void main(String[] args) {
		Integer resultat= fact(0);
		System.out.println(resultat);

	}

}
