package utopia.entity;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/21/21
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
	
	// -------------------- HashCode on Primary Key --------------------
	// Both are Primary Keys
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightBookingsBookings == null) ? 0 : flightBookingsBookings.hashCode());
		result = prime * result + ((flightBookingsFlightID == null) ? 0 : flightBookingsFlightID.hashCode());
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
		FlightBookings other = (FlightBookings) obj;
		if (flightBookingsBookings == null) {
			if (other.flightBookingsBookings != null)
				return false;
		} else if (!flightBookingsBookings.equals(other.flightBookingsBookings))
			return false;
		if (flightBookingsFlightID == null) {
			if (other.flightBookingsFlightID != null)
				return false;
		} else if (!flightBookingsFlightID.equals(other.flightBookingsFlightID))
			return false;
		return true;
	}
	
	
}
