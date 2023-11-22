package com.jspiders.designpatterns.structural;

public class StudentAdapter extends Student implements Game {

	@Override
	public void football() {
		setId(1);
		setName("pranita");
		setEmail("pranita@gmail.com");
		
		System.out.println(getName()+" is captain of football team.");
		
	}

	@Override
	public void hockey() {
		setId(2);
		setName("payal");
		setEmail("payal@gmail.com");
		
		System.out.println(getName()+" is captain of hockey team.");
		
	}

	
	
}
