package com.org.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {
	
	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static String URLlink = "jdbc:mysql://localhost:3306/jdbc";
	private static String userName = "root";
	private static String password = "root@123";
	
	public static void main(String[] args) {
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql = "select * from jokes";
		
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(URLlink,userName,password);
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmtdt = rs.getMetaData();
			
			System.out.println(rsmtdt.toString());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null || conn != null) {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
