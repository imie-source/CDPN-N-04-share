package org.imie;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Model model = new Model();
		Vue vue = new Vue(model);
		model.addObserver(vue);
		
		vue.start();
			
	}

}
