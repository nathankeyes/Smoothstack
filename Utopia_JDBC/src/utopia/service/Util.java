package utopia.service;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod, will take care of connection for entire transaction with database
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/utopia";
	private final String username = "root";
	private final String password = "Redwings12!";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Register the driver
		Class.forName(driver);
		
		// Create Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// until told to had commit, make all commits soft commits (in database memory, not permanent save)
		conn.setAutoCommit(Boolean.FALSE);
		
		return conn;
	}

}
