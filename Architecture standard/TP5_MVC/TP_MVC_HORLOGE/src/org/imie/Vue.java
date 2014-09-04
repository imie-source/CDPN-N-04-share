package org.imie;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.terminal.Terminal;

public class Vue implements Observer {

	private Model model;
	private Screen screen;
	Boolean activ = true;
	private String commande = "";

	public Vue(Model model) {
		super();
		this.model = model;

	}

	public void start() {

		screen = TerminalFacade.createScreen(TerminalFacade
				.createTextTerminal());
		screen.startScreen();
		screen.putString(10, 5, "Hello Lanterna!", Terminal.Color.RED,
				Terminal.Color.GREEN, ScreenCharacterStyle.Bold);
		screen.refresh();

//		Boolean activ = true;

//		Scanner scanner = new Scanner(System.in);
//
//		String saisie;

		while (activ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			input();
		}
		
		// while(!end){
		// saisie = scanner.nextLine();
		// switch (saisie) {
		// case "X":
		// model.stop();
		// end=true;
		// break;
		//
		// default:
		// break;
		// }
		// }
		screen.stopScreen();
	}

	private void input() {
		Key key = screen.readInput();
		if (key != null) {
			// thread.activ=false;
			if (key.getKind().equals(Key.Kind.Enter)) {
				traiterCommande(commande);
				commande = "";
			} else if (key.getKind().equals(Key.Kind.Backspace)) {
				if (commande.length() > 0) {
					commande = commande.substring(0, commande.length() - 1);
				}
			} else {
				commande += key.getCharacter();
			}
		}	
	}
	
	
	private void traiterCommande(String commande2) {
		System.out.println(commande2);
		
		if ("/q".equals(commande2)) {
			screen.stopScreen();
			model.stop();
			activ=false;
		}

	}


	@Override
	public void update(Observable o, Object arg) {
		MessageFormat formater = new MessageFormat(
				"{0,number,00} : {1,number,00} : {2,number,00}");
		Object[] data = { model.getHeure(), model.getMinutes(),
				model.getSeconde() };
		formater.format(data);
		// System.out.println(formater.format(data));
		screen.clear();

		screen.putString(0, 1, formater.format(data), Terminal.Color.WHITE,
				Terminal.Color.BLACK, ScreenCharacterStyle.Bold);
		screen.putString(0, 3, commande, Terminal.Color.WHITE,
				Terminal.Color.BLACK);

		screen.refresh();
		// System.out.printf("%d : %d :%d\n", model.getHeure(),
		// model.getMinutes(), model.getSeconde());

	}

}
