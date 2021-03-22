package utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public String updateFlight(int count) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		try {
			conn = util.getConnection();
			
			RouteDAO   rDAO = new RouteDAO(conn);
			FlightDAO  fDAO = new FlightDAO(conn);
			AirportDAO aDAO = new AirportDAO(conn);
			
			List<Route>     routes = new ArrayList<>();
			List<Flight>   flights = new ArrayList<>();
			List<Airport> airports = new ArrayList<>();
			
			Scanner userInput = new Scanner(System.in);
			
			
			int i = 1;
			
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
						System.out.print("You have chosen to Update the Flight with Flight ID: " + f.getFlightID());
						System.out.print(" and Departure Airport: " + org.getAirportCode() + " and Arrival Airport: " + dest.getAirportCode() + "\n");
						System.out.println("Enter 'quit' at any prompt to cancel operation\n");
					
						// Origin Airport and City
						System.out.println("Please enter a new Origin Airport and City or enter N/A for no change: ");
						
						String orgAirp = userInput.nextLine();
						if (orgAirp.equals("quit") || orgAirp.equals("Quit"))
							return "quit";
						else if (orgAirp.equals("N/A"))
							orgAirp = null;
						
						originCity= userInput.nextLine();
						if (originCity.equals("quit") || originCity.equals("Quit"))
							return "quit";
						else if (originCity.equals("N/A"))
							originCity = null;
						
						// Destinatin Airport and City
						System.out.println("Please enter a new Origin Airport and City or enter N/A for no change: ");
						
						String destAirp = userInput.nextLine();
						if (destAirp.equals("quit") || destAirp.equals("Quit"))
							return "quit";
						else if (destAirp.equals("N/A"))
							destAirp = null;
						
						destCity= userInput.nextLine();
						if (destCity.equals("quit") || destCity.equals("Quit"))
							return "quit";
						else if (destCity.equals("N/A"))
							destCity = null;
						
						// Departure date
						System.out.println("Please enter a new Departure Date and Time or enter N/A for no change: ");
						
						String depDateTime = userInput.nextLine();
						if (depDateTime.equals("quit") || depDateTime.equals("Quit"))
							return "quit";
						else if (depDateTime.equals("N/A"))
							depDateTime = null;

					// ----- Update Route Table -----
						// define new Route variable with specified inputs
						Route rInput = new Route();
						Airport tempA = new Airport();
						Airport tempB = new Airport();
						
						// Origin, Airport and City
						if ( orgAirp != null)
							tempA.setAirportCode(orgAirp);
						else 
							tempA.setAirportCode(org.getAirportCode());
						
						if ( originCity != null)
							tempA.setCity(originCity);
						else
							tempA.setCity(org.getCity());
						
						// D, Airport and City
						if ( destAirp != null)
							tempB.setAirportCode(destAirp);
						else 
							tempB.setAirportCode(dest.getAirportCode());
						
						if ( destCity != null)
							tempB.setCity(destCity);
						else
							tempB.setCity(dest.getCity());
						
						// then just get the city for those airport IDs
						rInput.setOriginAirport(tempA);
						rInput.setDestAirport(tempB);
	
						rDAO.updateRoute(rInput);
						
						
					// ----- Update Flight Table -----
						// convert string obj to Timestamp obj
						
						Timestamp obj = new Timestamp();
						f.setFlightDepartureTime(valueOf());
						
						fDAO.updateFlight(f);
					}
					
					i++;
				}
			}
			

			
			return "Success";
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

