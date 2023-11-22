package com.jspiders.jdbc.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {

	private static Connection connection;
	private static Statement statement;
	private static String query;

	public static void main(String[] args) throws IOException {

		try {
			connection = openConnection();
			statement = connection.createStatement();
			query = " UPDATE student SET name = 'prajakta', age = '20', email='praj@gmail.com',fees = 30000 WHERE ID=4";
			statement.executeUpdate(query);
			int row = statement.executeUpdate(query);
			System.out.println(row+" row(s) updated.");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static Connection openConnection() throws SQLException, ClassNotFoundException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");

	}

	private static void closeConnection() throws SQLException {

		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}

	}

}
