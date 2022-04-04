package jbdcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		String url = "jbdc:mysql//localhost:3306/demo";
		String user = "student";
		String password = "student";
		
		try {
			//1. Get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			String sql = "insert into employees " + " (last_name, first_name, email)" + " values ('Cole', 'Chelsea', 'info@colewoods.com')";
			myStmt.executeUpdate(sql);
			//4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		}
		catch (Exception exc) {
			
		}

	}

}
