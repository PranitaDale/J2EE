package jdbc.cardekhocasestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CarOperation {
	
	Scanner scanner = new Scanner(System.in);
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	public void addCarDetails() {
		
		
		try {
			connection = openConnection();
			query="INSERT INTO car_details VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("How many number of cars you want to add?");
			int no = scanner.nextInt();
			
			for(int i=1; i<=no; i++) {
			
			System.out.println("Enter car id.");
			preparedStatement.setInt(1,scanner.nextInt());
			scanner.nextLine();
			System.out.println("Enter car name");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter car brand");
			preparedStatement.setString(3, scanner.nextLine());
			System.out.println("Enter fuel type");
			preparedStatement.setString(4, scanner.nextLine());
			System.out.println("Enter Car Price");
			preparedStatement.setInt(5, scanner.nextInt());
			preparedStatement.addBatch();
			System.out.println("\n car(s) added!\n");
			}
			
			int[] row=preparedStatement.executeBatch();
			System.out.println(row.length+" row(s) affected.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void removeCarDetails() {
		try {
			
			connection = openConnection();
			query="DELETE FROM car_details WHERE car_id=?";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter car id to deleter car");
			int car_id=scanner.nextInt();
			preparedStatement.setInt(1, car_id);
			int row=preparedStatement.executeUpdate();
			System.out.println(row+" row(s) affected.");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public void updateCarDetails(int id) {
		try {
			connection = openConnection();
			query="UPDATE car_details SET name=?, brand=?, fuel_type=?, price=? WHERE car_id=?";
			preparedStatement = connection.prepareStatement(query);
			
			
			System.out.println("Enter car name");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.println("Enter car brand");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter fuel type");
			preparedStatement.setString(3, scanner.nextLine());
			System.out.println("Enter car price");
			preparedStatement.setDouble(4, scanner.nextDouble());
			
			preparedStatement.setInt(5, id);
			
			int row=preparedStatement.executeUpdate();
			System.out.println(row+" row(s) updated.");
			
		} catch (ClassNotFoundException | SQLException e) {
			
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
	
	public void searchByName() throws SQLException {
		
		System.out.println("Enter car name.");
		String name = scanner.nextLine();
		try {
			
			
			connection = openConnection();
			query="SELECT * FROM car_details WHERE name =?";
			preparedStatement =connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				do {
					System.out.println(resultSet.getInt(1));	
					System.out.println(resultSet.getString(2));	
					System.out.println(resultSet.getString(3));	
					System.out.println(resultSet.getString(4));	
					System.out.println(resultSet.getDouble(5));	
					}while(resultSet.next());
					System.out.println(resultSet);
			}
			else {
				System.out.println("No car details found.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	
	public static void closeConnection() throws SQLException {
		if(connection!=null) {
			connection.close();
		}
		if(preparedStatement!=null) {
			preparedStatement.close();
		}
	}
	

	
}
