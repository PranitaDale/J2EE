package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDelete {

	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main (String[] agrs) {
		
		try {
			connection = openConnection();
			statement = connection.createStatement();
			query = "DELETE FROM student WHERE id = 5";
			int row = statement.executeUpdate(query);
			System.out.println(row+" row(s) affected.");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
			
		
	}
	
	private static Connection openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	
	private static void closeConnection() throws SQLException {
		
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		
	}
	
}
