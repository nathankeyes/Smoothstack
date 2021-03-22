package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airplane;
import utopia.entity.Flight;
import utopia.entity.Route;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 I/O for flight
 */

public class FlightDAO extends BaseDAO<Flight>{

	public FlightDAO(Connection conn) {
		super(conn);
	}
	
	// ------------------------- functions for table  -------------------------
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("INSERT INTO flight VALUES (?,?,?,?,?,?)", new Object[] {
				flight.getFlightID(), 
				flight.getFlightRouteID(), 
				flight.getFlightAirplaneID(),
				flight.getFlightDepartureTime(),
				flight.getFlightReservedSeats(),
				flight.getFlightSeatPrice()
				});
	}
	
	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight SET route_id = ?,  aiplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?", new Object[] {
				flight.getFlightRouteID(), 
				flight.getFlightAirplaneID(),
				flight.getFlightDepartureTime(),
				flight.getFlightReservedSeats(),
				flight.getFlightSeatPrice(),
				flight.getFlightID() 
				});
	}
	
	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException{
		save("DELETE FROM flight WHERE id = ?", new Object[] {flight.getFlightID()});
	}
	
	public List<Flight> readAllFlights(Flight flight) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight", null);
	}
	
	public List<Flight> readAllFlightsByCode(Flight flight) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM flight WHERE id = ", new Object[] {flight.getFlightID()});
	}
	

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		
		
		while(rs.next()) {	
			Flight   f = new Flight();
			Airplane a = new Airplane();
			Route    r = new Route();
			
			f.setFlightID(rs.getInt("id"));
			f.setFlightDepartureTime(rs.getTimestamp("departure_time"));									// DATETIME ???????
			f.setFlightReservedSeats(rs.getInt("reserved_seats"));
			f.setFlightSeatPrice(rs.getFloat("seat_price"));
			
			r.setRouteID(rs.getInt("route_id"));
			f.setFlightRouteID(r);
			
			a.setAirplaneID(rs.getInt("airplane_id"));
			f.setFlightAirplaneID(a);
			
			flights.add(f);	
		}
		
		//a.setAirplaneFlights(flights);				// not sure if i need this, but whatevs
		//r.setRouteFlights(flights);					// not sure if i need this, but whatevs
		return flights;
	}

}
