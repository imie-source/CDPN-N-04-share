package org.imie;

import java.util.Observable;

public class Model extends Observable {

	private Integer seconde = 0;

	private Integer minute = 0;

	private Integer heure = 0;

	private TimeRunnable timeRunnable;

	public class TimeRunnable implements Runnable {

		Boolean running = true;

		@Override
		public void run() {
			while (running) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				seconde++;
				setChanged();
				notifyObservers();
				
			}

		}
		
		public void stopThread(){
			running=false;
		}

	}

	public Model() {
		super();
		timeRunnable = new TimeRunnable();
		Thread timeThread = new Thread(timeRunnable);
		timeThread.start();

	}

	public Integer getSeconde() {
		return seconde;
	}

	public void setSeconde(Integer seconde) {
		this.seconde = seconde;
	}

	public Integer getMinutes() {
		return minute;
	}

	public void setMinutes(Integer minutes) {
		this.minute = minutes;
	}

	public Integer getHeure() {
		return heure;
	}

	public void setHeure(Integer heure) {
		this.heure = heure;
	}

	public void stop() {
		timeRunnable.stopThread();
		
	}

}
