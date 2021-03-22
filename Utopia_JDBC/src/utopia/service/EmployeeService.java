package utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.dao.AirportDAO;
import utopia.dao.RouteDAO;
import utopia.entity.Airport;
import utopia.entity.Route;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 operations for Employees
 */



//for (Airport o : airports) {
//System.out.println(o.getCity());
//}

public class EmployeeService {
	
	Util util = new Util();

	
	public int viewFlights() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			
			RouteDAO rDAO = new RouteDAO(conn);
			
			List<Route> routes = new ArrayList<>();

			routes = rDAO.test();	
			
			int count = 1;

			for (Route o : routes) {
				Airport org = o.getOriginAirport();
				Airport dest = o.getDestAirport();
				
				System.out.println(count + ") " + org.getAirportCode()+ "," +  org.getCity() + " --> " + dest.getCity() + "," +  dest.getAirportCode());
				count++;
			}
			
			System.out.println(count + ") Quit to previous");

			conn.commit();
			//System.out.println("Flight read successfully");
			//return "Flight read successfully";
			return count;
		}
		catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("Flight rolledback");
			return 0;
		}
		finally {
			if (conn!=null) {
				conn.close();
			}
		}
	}
}

