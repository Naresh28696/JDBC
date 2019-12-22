package com.org.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class MetaDataTester {
	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static String URLlink = "jdbc:mysql://localhost:3306";
	private static String username = "root";
	private static String password = "root@123";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		
		
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(URLlink,username,password);
			DatabaseMetaData dmd = conn.getMetaData();
			System.out.println(dmd.getDriverName());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( conn != null) {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
