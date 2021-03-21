package utopia.entity;

import java.sql.Date;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2, passenger table
 */

public class Passenger {
	
	private Integer passengerID;				// Primary Key, id
	
	private Booking passengerBookingID;			// booking_id
	private String 	passengerGivenName;			// given_name
	private String  passengerFamilyName;		// family_name
	private Date    passengerDOB;				// dob
	private String  passengerGender;			// gender
	private String	passengerAddress;			// address
	
	// -------------------- Get/Set --------------------
	// passengerID
	public Integer getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(Integer passengerID) {
		this.passengerID = passengerID;
	}
	
	// BookingID
	public Booking getPassengerBookingID() {
		return passengerBookingID;
	}
	public void setPassengerBookingID(Booking passengerBookingID) {
		this.passengerBookingID = passengerBookingID;
	}
	
	// GivenName
	public String getPassengerGivenName() {
		return passengerGivenName;
	}
	public void setPassengerGivenName(String passengerGivenName) {
		this.passengerGivenName = passengerGivenName;
	}
	
	// FamilyName
	public String getPassengerFamilyName() {
		return passengerFamilyName;
	}
	public void setPassengerFamilyName(String passengerFamilyName) {
		this.passengerFamilyName = passengerFamilyName;
	}
	
	// DOB
	public Date getPassengerDOB() {
		return passengerDOB;
	}
	public void setPassengerDOB(Date passengerDOB) {
		this.passengerDOB = passengerDOB;
	}
	
	// Gender
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	
	// Address
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passengerID == null) ? 0 : passengerID.hashCode());
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
		Passenger other = (Passenger) obj;
		if (passengerID == null) {
			if (other.passengerID != null)
				return false;
		} else if (!passengerID.equals(other.passengerID))
			return false;
		return true;
	}
	
	
	
	

}
