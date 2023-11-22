package com.jspiders.jdbc.operation;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class JDBCInsert {
	
	public static void main(String[] args) throws SQLException {
		
		//Register Driver
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3?user=root&&password=root");
		
		//create Statement
		Statement statement =  connection.createStatement();
		
		//execute Statement
		statement.execute("INSERT INTO student VALUES(1,'sam','sam@gmail.com',20,30000)");
		
		//process result
		System.out.println("Data Inserted");
		
		//close connection
		statement.close();
		connection.close();
		
		//deregister driver
		DriverManager.deregisterDriver(driver);
;	}
}
