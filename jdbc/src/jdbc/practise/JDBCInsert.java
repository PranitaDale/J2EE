package jdbc.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert {
	static Scanner scanner = new Scanner(System.in);
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		try {
			connection = openConnection();
			query="INSERT INTO student VALUES(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			
			for(int i=1; i<=5; i++) {
			System.out.println("Enter student id.");
			preparedStatement.setInt(1, scanner.nextInt());
			scanner.nextLine();
			System.out.println("Enter student name");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter student email");
			preparedStatement.setString(3, scanner.nextLine());
			System.out.println("Enter student age");
			preparedStatement.setInt(4, scanner.nextInt());
			System.out.println("Enter student fees");
			preparedStatement.setDouble(5, scanner.nextDouble());
			preparedStatement.addBatch();
			}
			
			int[] res = preparedStatement.executeBatch();
			System.out.println(res.length+" row(s) affected.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static Connection openConnection() throws SQLException, ClassNotFoundException {
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
	}
	

}
