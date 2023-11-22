package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Paratha;

public class Resto extends Thread{
	private Paratha paratha = new Paratha();
	
	public Resto(Paratha paratha) {
		this.paratha=paratha;
	}
	@Override
	public void run() {
		paratha.prepareParatha(10);
	}
}
