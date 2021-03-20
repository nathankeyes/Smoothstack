package utopia.jdbc;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod
 */

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadAirport {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/utopia";
	private static final String username = "root";
	private static final String password = "Redwings12!";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Register the driver
		Class.forName(driver);
		
		// Create Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// Prepared Statement
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM airport WHERE iata_id = ?");
		
		// User Input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Airport Code to search");
		String airportCode = scan.nextLine();
		
		// append user input onto prepared statement
		pstmt.setString(1, airportCode);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getString("iata_id"));
			System.out.println(rs.getString("city"));
		}
		
	}
	
}
