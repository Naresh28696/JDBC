package com.org.storedprocedure.callableStatment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCoprationWithCallableStatment {
	private static String classDriver = "com.mysql.cj.jdbc.Driver";
	private static String URLlink = "jdbc:mysql://localhost:3306/jdbc";
	private static String userName = "root";
	private static String password = "root@123";
	
	public static void procedure(int id, String name) throws ClassNotFoundException, SQLException{
		String query = "call joke(?,?)";
		Class.forName(classDriver);
		try(Connection conn = DriverManager.getConnection(URLlink,userName,password)){
			try(CallableStatement cstmt = conn.prepareCall(query)){
				cstmt.setInt(1, id);
				cstmt.setString(2, name);
				
				int rowAffect = cstmt.executeUpdate();
				System.out.println(rowAffect+" Rows Affected.");
				
				cstmt.close();
				conn.close();
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Id : ");
		int id = scan.nextInt();
		System.out.print("Enter Name : ");
		String name = scan.next();
		
		procedure(id,name);
		
	}
}
