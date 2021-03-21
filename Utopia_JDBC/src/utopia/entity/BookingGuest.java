package utopia.entity;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 Entity for booking_guest
 */

public class BookingGuest {
	private Booking bookingGuestID;			// Foreign key on booking for id
	
	private String bookingGuestEmail;		// contact_email
	private String bookingGuestPhone;		// contact_phone
	
	
	// -------------------- Get/Set --------------------
	// BookingID
	public Booking getBookingGuestID() {
		return bookingGuestID;
	}
	public void setBookingGuestID(Booking bookingGuestID) {
		this.bookingGuestID = bookingGuestID;
	}
	
	// Email
	public String getBookingGuestEmail() {
		return bookingGuestEmail;
	}
	public void setBookingGuestEmail(String bookingGuestEmail) {
		this.bookingGuestEmail = bookingGuestEmail;
	}
	
	// Phone
	public String getBookingGuestPhone() {
		return bookingGuestPhone;
	}
	public void setBookingGuestPhone(String bookingGuestPhone) {
		this.bookingGuestPhone = bookingGuestPhone;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingGuestID == null) ? 0 : bookingGuestID.hashCode());
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
		BookingGuest other = (BookingGuest) obj;
		if (bookingGuestID == null) {
			if (other.bookingGuestID != null)
				return false;
		} else if (!bookingGuestID.equals(other.bookingGuestID))
			return false;
		return true;
	}
}
