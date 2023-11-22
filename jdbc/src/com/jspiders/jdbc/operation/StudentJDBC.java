package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentJDBC {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public void addStudent(Student student)  {
		
		try {
			connection = openConnecction();
			query = "INSERT INTO student VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setInt(4, student.getAge());
			preparedStatement.setDouble(5, student.getFees());
			
				

			int row = preparedStatement.executeUpdate();
			System.out.println(row+" row(s) affected.");
						
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		finally
		{
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public List<Student> getAllStudents(){
		ArrayList<Student> list = new ArrayList<>();
		try {
			connection = openConnecction();
			query = "SELECT * FROM student";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setAge(resultSet.getInt(4));
				student.setFees(resultSet.getDouble(5));
				list.add(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public Student getStudentById(int id) {
		Student student = new Student();
		try {
			connection = openConnecction();
			query = "SELECT * FROM student WHERE id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setAge(resultSet.getInt(4));
				student.setFees(resultSet.getDouble(5));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
		
	}
	public void deleteStudent(int id) {
		try {
			connection = openConnecction();
			query="DELETE FROM student WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row+" row(s) affected." );
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateStudent(int id, Scanner scanner) {
		try {
			connection = openConnecction();
			query="UPDATE student SET name = ?, email=?, age=?, fees=? WHERE id =?";
			preparedStatement=connection.prepareStatement(query);
			scanner.nextLine();
			System.out.println("Enter Student Name.");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.println("Enter Student Email."); 
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter Student Age.");
			preparedStatement.setInt(3, scanner.nextInt());
			System.out.println("Enter Student Fees.");
			preparedStatement.setDouble(4, scanner.nextDouble());
			
			preparedStatement.setInt(5, id);
			
			int row = preparedStatement.executeUpdate();
			System.out.println(row+ " row(s) affected.");

			} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	public static Connection openConnecction() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	public static void closeConnection() throws SQLException {
		
		if(connection != null) {
			connection.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
	}

}
