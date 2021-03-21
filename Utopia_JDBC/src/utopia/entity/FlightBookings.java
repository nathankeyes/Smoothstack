package utopia.entity;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2, flight_bookings table, weird table which is just used as a connector
 */

public class FlightBookings {

	private Flight flightBookingsFlightID;		// one to many relationship with flight, flight_id to id
	private Booking flightBookingsBookings;		// one to many relationship with booking, booking_id to id 

	// -------------------- Get/Set --------------------
	// FlightBookingsFlightID
	public Flight getFlightBookingsFlightID() {
		return flightBookingsFlightID;
	}
	public void setFlightBookingsFlightID(Flight flightBookingsFlightID) {
		this.flightBookingsFlightID = flightBookingsFlightID;
	}
	
	// flightBookingsBookings
	public Booking getFlightBookingsBookings() {
		return flightBookingsBookings;
	}
	public void setFlightBookingsBookings(Booking flightBookingsBookings) {
		this.flightBookingsBookings = flightBookingsBookings;
	}
}
