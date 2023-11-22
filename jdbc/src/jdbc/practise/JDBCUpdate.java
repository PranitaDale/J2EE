package jdbc.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdate {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	
	
	public static void main(String[] args) {
		
		try {
			connection = openConnection();
			query="UPDATE student SET fees = 35000 WHERE fees>=50000";
			preparedStatement=connection.prepareStatement(query);
			int row=preparedStatement.executeUpdate();
			System.out.println(row+" Records Updated...");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	
	public static void closeConnection() throws SQLException{
		if(connection!=null) {
			connection.close();
		}
		if(preparedStatement!=null) {
			preparedStatement.close();
		}
		
	}

}
