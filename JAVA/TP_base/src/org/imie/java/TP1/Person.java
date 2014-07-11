package org.imie.java.TP1;

public class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println(String.format("Hello,  my name is %s", this.name));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
