package utopia.dao;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 I/O for Booking
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Booking;

public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		Booking b = new Booking();
		
		while(rs.next()) {
			b.setBookingID(rs.getInt("id"));
			b.setBookingIsActive(rs.getBoolean("is_active"));
			b.setBookingConfirmationCode(rs.getString("confirmation_code"));
			
			bookings.add(b);
		}
		
		return bookings;
	}

}
