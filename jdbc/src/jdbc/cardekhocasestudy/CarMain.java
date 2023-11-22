package jdbc.cardekhocasestudy;

import java.sql.SQLException;
import java.util.Scanner;

public class CarMain {
	private static CarOperation carOperation=new CarOperation();
	private static boolean flag=true;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		while(flag) {
			carOperations();
		}
	}
	
	public static void carOperations() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==========CAR-DEKHO==========\n1.Add/Remove car details.\n2.Search Car Details.\n3.Edit Car Details.\n4.Exit");
		System.out.println("Enter your Choice");
		int choice1 = scanner.nextInt();
		
		switch(choice1) {
		case 1:
			System.out.println("1.Add Car Details.\n2.Remove Car Details.\n3.Go back to main menu.");
			int choice2=scanner.nextInt();
			switch(choice2) {
			case 1:
				carOperation.addCarDetails();
				break;
			case 2:
				carOperation.removeCarDetails();
				break;
			case 3:
				carOperations();
				break;
			default:
				System.out.println("Invalid Choice...");
			}
			
			break;
		case 2:
			System.out.println("1.Search by name.\n2.Search by brand.\n3.Search by fuel_type.\n4.Search by price.\n5.Go back to main menu.");
			System.out.println("Enter your choice");
			int choice3=scanner.nextInt();
			switch(choice3) {
			case 1:
				carOperation.searchByName();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				carOperations();
				break;
			default:
				System.out.println("Invalid Choice...");			
			}
			break;
		case 3:
			System.out.println("1.Enter car id.\n2.Go back to main menu.");
			int choice4=scanner.nextInt();
			switch(choice4) {
			case 1:
				carOperation.updateCarDetails(scanner.nextInt());
				break;
			case 2:
				carOperations();
				break;
			default :
				System.out.println("Invalid Choice.");
			}
			
				
		case 4:
			System.out.println("Thank You!");
			flag=false;
			break;
		default:
			System.out.println("Invalid Choice...");
		}
		
	}
	

}
