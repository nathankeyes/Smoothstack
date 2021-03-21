package utopia.entity;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/21/21
 * @Description Assessment 2, booking_payment table
 */

public class BookingPayment {
	
	private Booking bookingPaymentID;				// not primary key, booking_id
	private String	stripID;						// stripe_id
	private Boolean	refunded;						// refunded
	
	// -------------------- Get/Set --------------------
	// bookingPaymentID
	public Booking getBookingPaymentID() {
		return bookingPaymentID;
	}
	public void setBookingPaymentID(Booking bookingPaymentID) {
		this.bookingPaymentID = bookingPaymentID;
	}
	
	// stripeID
	public String getStripID() {
		return stripID;
	}
	public void setStripID(String stripID) {
		this.stripID = stripID;
	}
	
	// refunded
	public Boolean getRefunded() {
		return refunded;
	}
	public void setRefunded(Boolean refunded) {
		this.refunded = refunded;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingPaymentID == null) ? 0 : bookingPaymentID.hashCode());
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
		BookingPayment other = (BookingPayment) obj;
		if (bookingPaymentID == null) {
			if (other.bookingPaymentID != null)
				return false;
		} else if (!bookingPaymentID.equals(other.bookingPaymentID))
			return false;
		return true;
	}
}
