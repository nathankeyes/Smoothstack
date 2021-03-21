package utopia.dao;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 I/O for booking_guest
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Booking;
import utopia.entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuests = new ArrayList<>();
		
		BookingGuest bg = new BookingGuest();
		Booking       b = new Booking();
		
		while(rs.next()) {
			b.setBookingID(rs.getInt("booking_id"));
			bg.setBookingGuestID(b);
			
			bg.setBookingGuestEmail(rs.getString("contact_email"));
			bg.setBookingGuestPhone(rs.getString("contact_phone"));
			
			bookingGuests.add(bg);
		}
		
		return bookingGuests;
	}

}
