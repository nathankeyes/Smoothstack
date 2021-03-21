package utopia.entity;

import java.security.Timestamp;
import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2, flight table
 */

public class Flight {
	
	private Integer flightID;		    			// Primary Key, id
	
	private Integer flightRouteID;					// Foreign Key on routeID, route_id
	private Integer flightAirplaneID;				// Foreign Key on airplaneID, airplane_id
	
	private Timestamp flightDepartureTime;			// departure_time, Timestamp(year, month, date, hour, minute, second, nano)
	private Integer   flightReservedSeats;			// reserved_seats
	private Float     flightSeatPrice;				// seat_price
	
	private List<FlightBookings> flightFlightBookings;	// many to one relationship with flight_bookings, id to flight_id
	
	// -------------------- Get/Set --------------------
	// flightID
	public Integer getFlightID() {
		return flightID;
	}
	public void setFlightID(Integer flightID) {
		this.flightID = flightID;
	}
	
	// flightRouteID
	public Integer getFlightRouteID() {
		return flightRouteID;
	}
	public void setFlightRouteID(Integer flightRouteID) {
		this.flightRouteID = flightRouteID;
	}
	
	// flightAirplaneID
	public Integer getFlightAirplaneID() {
		return flightAirplaneID;
	}
	public void setFlightAirplaneID(Integer flightAirplaneID) {
		this.flightAirplaneID = flightAirplaneID;
	}
	
	// flightDepartureTime
	public Timestamp getFlightDepartureTime() {
		return flightDepartureTime;
	}
	public void setFlightDepartureTime(Timestamp flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}
	
	// flightReservedSeats
	public Integer getFlightReservedSeats() {
		return flightReservedSeats;
	}
	public void setFlightReservedSeats(Integer flightReservedSeats) {
		this.flightReservedSeats = flightReservedSeats;
	}
	
	// flightSeatPrice
	public Float getFlightSeatPrice() {
		return flightSeatPrice;
	}
	public void setFlightSeatPrice(Float flightSeatPrice) {
		this.flightSeatPrice = flightSeatPrice;
	}
	
	// flightFlightBookings
	public List<FlightBookings> getFlightFlightBookings() {
		return flightFlightBookings;
	}
	public void setFlightFlightBookings(List<FlightBookings> flightFlightBookings) {
		this.flightFlightBookings = flightFlightBookings;
	}
	
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightID == null) ? 0 : flightID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (flightID == null) {
			if (other.flightID != null)
				return false;
		} else if (!flightID.equals(other.flightID))
			return false;
		return true;
	}

	

}
