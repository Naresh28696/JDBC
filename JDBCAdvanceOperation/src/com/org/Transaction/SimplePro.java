package com.org.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimplePro {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String query = "insert into movie_table values(19,'ddlj','3','210','2Year','Andra')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?user=root&password=root@123");
			
//			conn.setAutoCommit(false);
			// here data will sent from java application OR our code 
			// but the DataBase server will not give respond because of we set setAutoCommit as false.
			
			
			stmt = conn.createStatement();
			int rowAffect = stmt.executeUpdate(query);
			System.out.println(rowAffect + " ow affected.");
			System.out.println(2/0);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null || stmt != null) {
				try {
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	
	}
	
}
