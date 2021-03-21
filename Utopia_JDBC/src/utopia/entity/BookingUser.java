package utopia.entity;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 Entity for booking_agent
 */

public class BookingUser {
	
	private Booking bookingUserBookingID;			// Foreign key to booking on, booking_id to id
	private User    bookingUserUserID;			// Foreign key to user on, agent_id to id
	
	// -------------------- Get/Set --------------------
	// BookingID
	public Booking bookingUserBookingID() {
		return bookingUserBookingID;
	}
	public void bookingUserBookingID(Booking bookingUserBookingID) {
		this.bookingUserBookingID = bookingUserBookingID;
	}
	
	// AgentID
	public User bookingUserUserID() {
		return bookingUserUserID;
	}
	public void bookingUserUserID(User bookingUserUserID) {
		this.bookingUserUserID = bookingUserUserID;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingUserBookingID == null) ? 0 : bookingUserBookingID.hashCode());
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
		BookingUser other = (BookingUser) obj;
		if (bookingUserBookingID == null) {
			if (other.bookingUserBookingID != null)
				return false;
		} else if (!bookingUserBookingID.equals(other.bookingUserBookingID))
			return false;
		return true;
	}
	
	
	

}
