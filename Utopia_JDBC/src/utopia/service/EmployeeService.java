package utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import utopia.dao.AirplaneDAO;
import utopia.dao.AirportDAO;
import utopia.dao.FlightDAO;
import utopia.dao.RouteDAO;
import utopia.entity.Airport;
import utopia.entity.Flight;
import utopia.entity.Route;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 operations for Employees
 */

public class EmployeeService {
	
	Util util = new Util();

	public String flightInfo(int count) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		try {
			conn = util.getConnection();
			
			RouteDAO         rDAO = new RouteDAO(conn);
			FlightDAO        fDAO = new FlightDAO(conn);
			AirportDAO       aDAO = new AirportDAO(conn);
			//AirplaneDAO      pDAO = new AirplaneDAO(conn);
			//AirplaneTypeDAO atDAO = new AirplaneTypeDAO(conn);
			
			List<Route>     routes = new ArrayList<>();
			List<Airport> airports = new ArrayList<>();
			List<Flight>   flights = new ArrayList<>();
			
			routes   = rDAO.readAllRoutes(null);
			airports = aDAO.readAllAirports(null);
			flights  = fDAO.readAllFlights(null);

			int i = 1;

			// private Route flightRouteID;						// Foreign Key on routeID, route_id
			for (Flight f : flights) {
				for (Route r : routes) {					
					// make sure the flight info is for the right route
					if ( f.getFlightRouteID().equals(r) && i == count) {
						Airport org = r.getOriginAirport();
						Airport dest = r.getDestAirport();
						
						String originCity = null;
						String destCity = null;
						
						for (Airport a : airports) {
							if (org.equals(a)) 
								originCity = a.getCity();
							if (dest.equals(a)) 
								destCity = a.getCity();
						}
						
						// now we got our info and we looking at the correct route
						System.out.println(count + ") " + org.getAirportCode()+ "," +  originCity + " --> " + dest.getAirportCode() + "," + destCity);
						System.out.print("You have chosen to view the Flight with Flight ID: " + f.getFlightID());
						System.out.print(" and Departure Airport: " + org.getAirportCode() + " and Arrival Airport: " + dest.getAirportCode() + "\n\n");
						
						System.out.println("Departure Airport: " + org.getAirportCode() + " | Arrival Airport: " + dest.getAirportCode());
						System.out.println("Departure Date and Time: " + f.getFlightDepartureTime() + "\n");
						
						// technically need to go through airplane_type and airplane and subrtract the available seats from the reserved seats to get value
						System.out.println("Available Seats: " + f.getFlightReservedSeats());
					}
					
					i++;
				}
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

