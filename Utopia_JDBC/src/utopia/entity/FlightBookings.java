package utopia.entity;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2, flight_bookings table, weird table which is just used as a connector
 */

public class FlightBookings {

	private Integer flightBookingsFlightID;		// one to many relationship with flight, flight_id to id
	private Integer flightBookingsBookings;		// one to many relationship with booking, booking_id to id 

	// -------------------- Get/Set --------------------
	// FlightBookingsFlightID
	public Integer getFlightBookingsFlightID() {
		return flightBookingsFlightID;
	}
	public void setFlightBookingsFlightID(Integer flightBookingsFlightID) {
		this.flightBookingsFlightID = flightBookingsFlightID;
	}
	
	// flightBookingsBookings
	public Integer getFlightBookingsBookings() {
		return flightBookingsBookings;
	}
	public void setFlightBookingsBookings(Integer flightBookingsBookings) {
		this.flightBookingsBookings = flightBookingsBookings;
	}
}
