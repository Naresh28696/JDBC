package com.org.batch.army;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ArmyDBoperation {
	
	public static String driverClassPath = "com.mysql.cj.jdbc.Driver";
	public static String URLlink = "jdbc:mysql://localhost:3306/jdbc";
	public static String userName = "root";
	public static String password = "root@123";
	
	public static void main(String[] args) {
		
		Connection conn =null;
		Statement stmt = null;
		String insertQuery1 = "insert into army_table values(1,'PARA','KanyaKumari','AK-47')";
		String insertQuery2 = "insert into army_table values(2,'CRPF','JAMMU','AK-47')";
		
		try {
			Class.forName(driverClassPath);
			conn = DriverManager.getConnection(URLlink,userName,password);
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			stmt.addBatch(insertQuery1);
			stmt.addBatch(insertQuery2);
			
			int[] rowAffectArry = stmt.executeBatch();
			for(int i =0 ;i<rowAffectArry.length;i++) {
				System.out.println(i+1 + " Query Affect "+rowAffectArry[i]+" ROWS.");
			}
			
			conn.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(stmt != null || conn != null) {
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
