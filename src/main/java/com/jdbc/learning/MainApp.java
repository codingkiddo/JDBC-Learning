package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

	static final String DB_URL = "jdbc:mysql://localhost:3306/employees?useSSL=false";
	static final String USER = "root";
	static final String PASS = "12345678";
	static final String QUERY = "SELECT emp_no, first_name, last_name FROM Employees";
//	static final String QUERY = "SELECT version()";
	
	public static void main(String[] args) {

		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered !!!!!!!");
        } catch (Exception ex) {
        	System.out.println("Error Occured While JDBC Driver Register!");
        }

		

//		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
//			System.out.println("Database connected!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			while (rs.next()) {
	            // Retrieve by column name
	            System.out.print("ID: " + rs.getInt("emp_no"));
	            System.out.print(", First: " + rs.getString("first_name"));
	            System.out.println(", Last: " + rs.getString("last_name"));
	         }
			System.out.println("Database connected!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
