package com.jspiders.designpatterns.creational;

import java.util.Scanner;

public class FactoryMain {
	
	private static Beverage beverage;
	
	public static void main(String[] args) {
		try {
			factory().order();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Beverage is not ordered.");
		}
	}
	public static Beverage factory() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 1 to order Masala Tea.\nEnter 2 to order Ginger Tea.\nEnter 3 to order Lemon tea.\nEnter 4 to order Green Tea.");
		System.out.println("Enter your choice..");
		int choice = scanner.nextInt();
		
		switch(choice) {
		
		case 1:
			beverage = new masalaTea();
			break;
		case 2:
			beverage = new gingerTea();
			break;
		case 3:
			beverage = new lemonTea();
			break;
		case 4:
			beverage = new greenTea();
			break;
		default:
			System.out.println("Invalid Choice.");
				
		}
		
		return beverage;
	}

}
