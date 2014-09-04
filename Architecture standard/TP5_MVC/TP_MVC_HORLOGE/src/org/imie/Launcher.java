package org.imie;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Model model = new Model();
		Boolean end=false;
		
		Scanner scanner = new Scanner(System.in);
		
		String saisie;
		
		while(!end){
			saisie = scanner.nextLine();
			switch (saisie) {
			case "X":
				model.stop();
				end=true;
				break;

			default:
				break;
			}
		}
			
	}

}
