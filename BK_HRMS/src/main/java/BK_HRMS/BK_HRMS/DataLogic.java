package BK_HRMS.BK_HRMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataLogic {
	private static final String DB_URL = "jdbc:mysql://localhost:3308/apitest";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static void insertData(String name, String number, int age) {
		String query = "INSERT INTO test (name, number, age) VALUES (?, ?, ?)";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, number);
		pstmt.setInt(3, age);
		pstmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("SQL Exception Occured, Error: "+e.getMessage());
			e.printStackTrace();
		}
	}
}
