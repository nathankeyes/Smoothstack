package utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.dao.AirportDAO;
import utopia.dao.FlightDAO;
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

	public String flightInfo(int count) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		try {
			conn = util.getConnection();
			
			RouteDAO   rDAO = new RouteDAO(conn);
			FlightDAO  fDAO = new FlightDAO(conn);
			AirportDAO aDAO = new AirportDAO(conn);
			
			List<Route>     routes = new ArrayList<>();
			List<Airport> airports = new ArrayList<>();

			routes = rDAO.test();	
			int i = 1;

			for (Route o : routes) {
				Airport org = o.getOriginAirport();
				Airport dest = o.getDestAirport();
				
				if (i == count) {
					System.out.println(count + ") " + org.getAirportCode()+ "," +  org.getCity() + " --> " + dest.getCity() + "," +  dest.getAirportCode());
					System.out.print("You have chosen to view the Flight with Flight ID: " + o.getRouteID());
					System.out.print(" and Departure Airport: " + org.getAirportCode() + " and Arrival Airport: " + dest.getAirportCode() + "\n\n");
					
					System.out.println("Departure Airport: " + org.getAirportCode() + " | Arrival Airport: " + dest.getAirportCode());
					System.out.println("Departure Date: " + org.getAirportCode() + " | Arrival Airport: " + dest.getAirportCode());
					
				}
				i++;
			}
			
			
		

			conn.commit();
	
			return "Flight Informed";
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
	
	public int viewFlights() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			
			RouteDAO   rDAO = new RouteDAO(conn);
			AirportDAO aDAO = new AirportDAO(conn);
			
			List<Route>     routes = new ArrayList<>();
			List<Airport> airports = new ArrayList<>();

			routes = rDAO.readAllRoutes(null);
			airports = aDAO.readAllAirports(null);	
			
			int count = 1;
			
			for (Route r : routes) {
				Airport org = r.getOriginAirport();
				Airport dest = r.getDestAirport();
				
				String originCity = null;
				String destCity = null;
				
				// need to check if our origin, and dest are located in airports
				for (Airport a : airports) {
					if (org.equals(a)) 
						originCity = a.getCity();
					if (dest.equals(a)) 
						destCity = a.getCity();
				}
				
				if (originCity != null && destCity != null) 
					System.out.println(count + ") " + org.getAirportCode()+ "," +  originCity + " --> " + dest.getAirportCode() + "," + destCity);
				count++;
			}
			

//			for (Route o : routes) {
//				Airport org = o.getOriginAirport();
//				Airport dest = o.getDestAirport();
//				
//				System.out.println(count + ") " + org.getAirportCode()+ "," +  org.getCity() + " --> " + dest.getCity() + "," +  dest.getAirportCode());
//				count++;
//			}
			
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

