package utopia.dao;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 I/O for BookingPayment
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Booking;
import utopia.entity.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment>{

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingPayments = new ArrayList<>();
		
		BookingPayment bp = new BookingPayment();
		Booking 		b = new Booking();
		
		while(rs.next()) {
			b.setBookingID(rs.getInt("booking_id"));
			bp.setBookingPaymentID(b);
			
			bp.setStripID(rs.getString("stripe_id"));
			bp.setRefunded(rs.getBoolean("refunded"));
			
			bookingPayments.add(bp);
		}
		
		return bookingPayments;
	}

}
