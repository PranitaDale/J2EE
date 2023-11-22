package com.jspiders.employeemanagementsystem.main;

import java.util.Scanner;

import com.jpsiders.employeemanagementsystem.dto.Employee;
import com.jspiders.employeemanagementsystem.dao.EmployeeDAO;

public class EmployeeMain {
	
	private static EmployeeDAO employeeDAO = new EmployeeDAO();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("Enter 1 to add employee.\nEnter 2 to delete employee.\nEnter 3 to update employee.\nEnter 4 to find employee by id.\nEnter 5 to find all employees.\nEnter 6 to exit.");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:	Employee employee = new Employee();
					scanner.nextLine();
					System.out.println("Enter employee name");
					employee.setName(scanner.nextLine());
					System.out.println("Enter employee email");
					employee.setEmail(scanner.nextLine());
					System.out.println("Enter employee salary");
					employee.setSalary(scanner.nextDouble());
					employeeDAO.addEmployee(employee);
					break;
			case 2: employeeDAO.getAllEmployees();
				    System.out.println("Enter employee id to delete");
					employeeDAO.deleteEmployee(scanner.nextInt());
					System.out.println("Employee deleted...");
				    break;
			case 3: employeeDAO.getAllEmployees();
					System.out.println("Enter employee id to update");
					employeeDAO.updateEmployee(scanner.nextInt(), scanner);
					System.out.println("Employee updated.");
				break;
			case 4: System.out.println("Enter employee id ");
			        Employee employee3 = employeeDAO.getEmployeeById(scanner.nextInt());
			        if(employee3!=null) {
			        	System.out.println(employee3);
			        }else {
			        	System.out.println("Employee not found..");
			        }
				break;
			case 5:employeeDAO.getAllEmployees();
				break;
			case 6:flag=false;
				   System.out.println("Thank You!");
				break;
				default : System.out.println("Invalid Choice...");
			
			}
		}
	}

}
