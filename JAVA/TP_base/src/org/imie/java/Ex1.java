package org.imie.java;

public class Ex1 {

	public static void main(String[] args) {
		Integer age = Integer.valueOf(args[0]);
		
//		pousssin 6 7
		if (age>=6 && age<=7){
			System.out.println("poussin");
		}
//		pupille	8 9		
		else if (age >=8 && age <=9) {
			System.out.println("pupille");
		}
//		minime 10 11
		else if (age >=10 && age <=11) {
			System.out.println("minime");
		}
//		cadet >12
		else if (age>12) {
			System.out.println("cadet");
		}

	}

}
