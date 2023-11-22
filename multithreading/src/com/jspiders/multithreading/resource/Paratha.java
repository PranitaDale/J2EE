package com.jspiders.multithreading.resource;

public class Paratha {
	
	int availableParatha;
	public synchronized void orderParatha(int numberOfParatha) {
		if(numberOfParatha>availableParatha) {
			System.out.println(numberOfParatha+" parathas are not availabel please wait...");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			availableParatha-=numberOfParatha;
			System.out.println("order for "+numberOfParatha+" parathas is successful...");
		}
	}
	public synchronized  void prepareParatha(int numberOfParatha) {
		System.out.println(numberOfParatha+" parathas are getting prepared.");
		availableParatha+=numberOfParatha;
		System.out.println(availableParatha+" parathas are available.");
		notify();
	}

	
}
