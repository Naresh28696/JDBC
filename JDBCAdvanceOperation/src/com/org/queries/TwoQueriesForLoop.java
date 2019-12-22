package com.org.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TwoQueriesForLoop {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		String query = "insert into movie_table values(?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root", "root@123");
			pstmt = conn.prepareStatement(query);
			
			while(count++ < 3) {
				System.out.print("Enter ID : ");
				int id = scan.nextInt();
				System.out.print("Enter Name : ");
				String name = scan.next();
				System.out.print("Enter Duration : ");
				String duration = scan.next();
				System.out.print("Enter Budget : ");
				String budget = scan.next();
				System.out.print("Enter Year : ");
				String year = scan.next();
				System.out.print("Enter Languager : ");
				String language = scan.next();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, duration);
				pstmt.setString(4, budget);
				pstmt.setString(5, year);
				pstmt.setString(6, language);
				
				int rowAffect = pstmt.executeUpdate();
				System.out.println(rowAffect + "Row Affected.");
				System.out.println("-------------------------- ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
