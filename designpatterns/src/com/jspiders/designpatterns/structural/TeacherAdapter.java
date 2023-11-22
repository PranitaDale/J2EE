package com.jspiders.designpatterns.structural;

public class TeacherAdapter extends Teacher implements Game {
	

		@Override
		public void football() {
			setId(1);
			setName("prajakta");
			setEmail("prajakta@gmail.com");
			
			System.out.println(getName()+" is coach of football team.");
			
		}

		@Override
		public void hockey() {
			setId(2);
			setName("ratika");
			setEmail("ratika@gmail.com");
			
			System.out.println(getName()+" is coach of hockey team.");
			
		}

		
		
	}



