package com.org.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Twoqueries {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into movie_table values(?,?,?,?,?,?)";
		
		Scanner scan = new Scanner(System.in);
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?user=root&password=root@123");
			pstmt = con.prepareStatement(query);
			
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
			
			int rowAffected1 = pstmt.executeUpdate();
			System.out.println(rowAffected1 + " Row Affected");
			
			System.out.print("Enter ID : ");
			 id = scan.nextInt();
			System.out.print("Enter Name : ");
			 name = scan.next();
			System.out.print("Enter Duration : ");
			 duration = scan.next();
			System.out.print("Enter Budget : ");
			 budget = scan.next();
			System.out.print("Enter Year : ");
			 year = scan.next();
			System.out.print("Enter Languager : ");
			 language = scan.next();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, duration);
			pstmt.setString(4, budget);
			pstmt.setString(5, year);
			pstmt.setString(6, language);
			
			int rowAffected2 = pstmt.executeUpdate();
			System.out.println(rowAffected2 + " Row Affected");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			if(pstmt!=null || con!= null) {
			
				try {
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
