package utopia.entity;

import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2, booking table
 */

public class Booking {
	
	private Integer bookingID;								// Primary Key, id
	
	private Boolean bookingIsActive;						// is_active TINYINT, but looking for boolean
	private String	bookingConfirmationCode;				// confirmation_code
	
	private List<FlightBookings> bookingFlightBookings;		// many to one relationship with flight_bookings, id to flight_id
	private List<Passenger> bookingBookingID;				// many to one relationship with passenger, id to booking_id
	
	// -------------------- Get/Set --------------------
	// bookingID
	public Integer getBookingID() {
		return bookingID;
	}
	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}
	
	// bookingIsActive
	public Boolean getBookingIsActive() {
		return bookingIsActive;
	}
	public void setBookingIsActive(Boolean bookingIsActive) {
		this.bookingIsActive = bookingIsActive;
	}
	
	// bookingConfirmationCode
	public String getBookingConfirmationCode() {
		return bookingConfirmationCode;
	}
	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}
	
	// bookingFlightBookings
	public List<FlightBookings> getBookingFlightBookings() {
		return bookingFlightBookings;
	}
	public void setBookingFlightBookings(List<FlightBookings> bookingFlightBookings) {
		this.bookingFlightBookings = bookingFlightBookings;
	}
	
	// bookingBookingID
	public List<Passenger> getBookingBookingID() {
		return bookingBookingID;
	}
	public void setBookingBookingID(List<Passenger> bookingBookingID) {
		this.bookingBookingID = bookingBookingID;
	}
	
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingID == null) ? 0 : bookingID.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingID == null) {
			if (other.bookingID != null)
				return false;
		} else if (!bookingID.equals(other.bookingID))
			return false;
		return true;
	}
	
	
	
	

}
