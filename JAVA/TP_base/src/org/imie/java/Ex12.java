package org.imie.java;

public class Ex12 {

	public static void main(String[] args) {
		Integer[] tab = {12,34,76,43,65,21};
		for (int i = tab.length-1; i > 0; i--) {
			Integer tmp = tab[i];
			tab[i]=tab[i-1];
			tab[i-1]=tmp;
		}
		
		for (Integer value : tab) {
			System.out.println(value);
		}
	}
}
