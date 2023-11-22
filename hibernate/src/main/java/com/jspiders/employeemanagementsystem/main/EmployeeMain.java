package com.jspiders.employeemanagementsystem.main;

import java.util.Scanner;

import com.jspiders.employeemanagementsystem.dao.EmployeeDAO;
import com.jspiders.employeemanagementsystem.dto.Employee;



public class EmployeeMain {
	
	private static EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add employee.\nEnter 2 to delete employee.");
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			Employee employee = new Employee();
			scanner.nextLine();
			System.out.println("Enter employee name.");
			employee.setName(scanner.nextLine());
			System.out.println("Enter employee email.");
			employee.setEmail(scanner.nextLine());
			System.out.println("Enter employee salary.");
			employee.setSalary(scanner.nextDouble());
			
			employeeDAO.addEmployee(employee);
			break;
			
		case 2:
			scanner.nextLine();
			System.out.println("Enter employee id");
			int id = scanner.nextInt();
			employeeDAO.deleteEmployee(id);
			break;
		
		}
		
	}

}

