package utopia.service;

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.AirportDAO;
import utopia.dao.RouteDAO;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 operations for Employees
 */

public class EmployeeService {
	
	Util util = new Util();

	
	public String viewFlights() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			// flightDAO pass same conn
			// airplane dao pass same conn
			
			
			//conn.commit();
			return "Flight added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Flight rolledback";
		}
		finally {
			if (conn!=null) {
				conn.close();
			}
		}
	}
}

