package org.com.JDBC.FirstSimpleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester2 {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?user=root&password=root@123");
			stmt = con.createStatement();
			//stmt.executeUpdate("insert into games_table values(1,'Dave',1,'digital','10 levels')");
			stmt.executeUpdate("update games_table set game_name = 'PUBG' where game_id = 1");
			stmt.executeUpdate("insert into games_table values(2,'Contra',2,'digital','10 levels')");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			if(stmt!=null || con!= null) {
			
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
