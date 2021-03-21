package utopia.entity;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2, booking_payment table
 */

public class BookingPayment {
	
	private Integer bookingPaymentID;				// not primary key, booking_id
	private String	stripID;						// stripe_id
	private Boolean	refunded;						// refunded
	
	// -------------------- Get/Set --------------------
	// bookingPaymentID
	public Integer getBookingPaymentID() {
		return bookingPaymentID;
	}
	public void setBookingPaymentID(Integer bookingPaymentID) {
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
	
	
	

}
