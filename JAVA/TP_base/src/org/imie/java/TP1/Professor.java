package org.imie.java.TP1;

public class Professor extends Person {

	private Integer salary;
	
	public Professor(String name,Integer salary) {
		super(name);
		this.salary=salary;
	}

	@Override
	public void sayHello() {
		System.out.println(String.format("Hello,  my name is %s and i earn %d Euros", this.getName(),this.salary));
	}
	
	

}
