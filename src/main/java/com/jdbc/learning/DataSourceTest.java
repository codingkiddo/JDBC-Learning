package com.jdbc.learning;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DataSourceTest {

	public static void main(String[] args) {

//		testMySQLDataSource();
		testBasicDataSource();

	}
	
	private static void testBasicDataSource() {
		DataSource ds = null;
		ds = DataSourceFactory.getBasicDataSource();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select emp_no, first_name from Employees where emp_no=498076");
			while (rs.next()) {
				System.out.println("Employee ID=" + rs.getInt("emp_no") + ", Name=" + rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void testMySQLDataSource() {
		DataSource ds = null;
		ds = DataSourceFactory.getMySQLDataSource();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select emp_no, first_name from Employees");
			while (rs.next()) {
				System.out.println("Employee ID=" + rs.getInt("emp_no") + ", Name=" + rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
