package org.imie.java.TP1;

public class Launcher {

	public static void main(String[] args) {
		Person person = new Person("Aurore");
		Professor professor = new Professor("Simon",1);
		person.sayHello();
		professor.sayHello();

	}

}
