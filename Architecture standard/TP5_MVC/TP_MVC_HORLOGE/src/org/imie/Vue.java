package org.imie;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.terminal.Terminal;

public class Vue implements Observer{
	
	private Model model;
	private Screen screen;



	public Vue(Model model) {
		super();
		this.model = model;
		
		screen = TerminalFacade.createScreen();
		screen.startScreen();
		screen.putString(10, 5, "Hello Lanterna!", Terminal.Color.RED,
				Terminal.Color.GREEN, ScreenCharacterStyle.Bold);
		screen.refresh();
		
		screen.stopScreen();
		
	}
	
	public void start(){
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

	@Override
	public void update(Observable o, Object arg) {
		System.out.printf("%d : %d :%d\n", model.getHeure(), model.getMinutes(), model.getSeconde());
		
	}
	

}
