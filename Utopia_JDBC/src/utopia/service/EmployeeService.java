package utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.dao.AirportDAO;
import utopia.dao.RouteDAO;
import utopia.entity.Airport;

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
			
			AirportDAO aDAO = new AirportDAO(conn);
			RouteDAO   rDAO = new RouteDAO(conn);
			List<Airport> airports = new ArrayList<>();
			Airport a = new Airport();
			
			airports = aDAO.readAllAirports(a);
			
			for (Airport o : airports) {
				System.out.println(o.getCity());
			}

			
			
			
			
			
			conn.commit();
			return "Flight read successfully";
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

