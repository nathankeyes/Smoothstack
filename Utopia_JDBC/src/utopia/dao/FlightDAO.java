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

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		
		Flight   f = new Flight();
		Airplane a = new Airplane();
		Route    r = new Route();
		
		while(rs.next()) {
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
		
		a.setAirplaneFlights(flights);				// not sure if i need this, but whatevs
		r.setRouteFlights(flights);					// not sure if i need this, but whatevs
		return flights;
	}

}
