package com.bookstore.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {

	public static final String jdbcURL = "jdbc:mysql://localhost:3306/bookstorefinal";
	public static final String jdbcUsername = "root";
	public static final String jdbcPassword = "160399";
	
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("Connect succesfully!");
		} catch (Exception e) {
			System.out.println("Connect failed!");
			e.printStackTrace();
		}
		
		return con;
		
	}
	public static void main(String[] args) {
		JDBCUtils.getConnection();

	}

}
