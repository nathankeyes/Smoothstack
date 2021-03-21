package utopia.dao;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 I/O for Passenger
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Booking;
import utopia.entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger>{

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		Passenger p = new Passenger();
		Booking   b = new Booking();
		
		while(rs.next()) {
			p.setPassengerID(rs.getInt("id"));
			
			b.setBookingID(rs.getInt("booking_id"));
			p.setPassengerBookingID(b);
			
			p.setPassengerGivenName(rs.getString("given_name"));
			p.setPassengerFamilyName(rs.getString("family_name"));
			p.setPassengerDOB(rs.getDate("dob"));
			p.setPassengerGender(rs.getString("gender"));
			p.setPassengerAddress(rs.getString("address"));
			
			passengers.add(p);
		}
		
		
		b.setBookingBookingID(passengers);							// maybe
		return passengers;
	}

}
