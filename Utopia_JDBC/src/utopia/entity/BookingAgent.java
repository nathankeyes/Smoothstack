package utopia.entity;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 Entity for booking_agent
 */

public class BookingAgent {
	private Booking bookingAgentBookingID;			// Foreign key to booking on, booking_id to id
	private User    bookingAgentAgentID;			// Foreign key to user on, agent_id to id
	
	// -------------------- Get/Set --------------------
	// BookingID
	public Booking getBookingAgentBookingID() {
		return bookingAgentBookingID;
	}
	public void setBookingAgentBookingID(Booking bookingAgentBookingID) {
		this.bookingAgentBookingID = bookingAgentBookingID;
	}
	
	// AgentID
	public User getBookingAgentAgentID() {
		return bookingAgentAgentID;
	}
	public void setBookingAgentAgentID(User bookingAgentAgentID) {
		this.bookingAgentAgentID = bookingAgentAgentID;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingAgentBookingID == null) ? 0 : bookingAgentBookingID.hashCode());
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
		BookingAgent other = (BookingAgent) obj;
		if (bookingAgentBookingID == null) {
			if (other.bookingAgentBookingID != null)
				return false;
		} else if (!bookingAgentBookingID.equals(other.bookingAgentBookingID))
			return false;
		return true;
	}
	
	
	
}
