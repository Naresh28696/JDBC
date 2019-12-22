package org.com.JDBC.FirstSimpleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {
	public static void main(String[] args) {
		Connection connection = null;
		Statement st =null;
		String query = "insert into movie_table values(3,'KGF','3 hours','250 crore','2018','hindi'),(4,'KGF','3 hours','250 crore','2018','hindi')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?user=root&password=root@123");
				// DriverManager is a Helper method.
				// Only one Helper Method is present in 
				// getConnection() method return Connection type object 
				// and it will create implementation object of Connection.
				// getConnection() use to establish connection betn Database server & application.
				st = connection.createStatement();
				int result = st.executeUpdate(query);
				System.out.println(result+" Row Affected.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
