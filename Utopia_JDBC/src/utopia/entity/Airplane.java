package utopia.entity;

import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod, airplane table
 */

public class Airplane {
	
	private Integer airplaneID;		    // Primary Key, id
	
	private Integer airplaneTypeID;		// Foreign Key to airplane_type
	
	private List<Flight> airplaneFlights;		// many to one relationship with flight, airpalneID to airplane_id
	
	
	// -------------------- Get/Set --------------------
	// airplaneID
	public Integer getAirplaneID() {
		return airplaneID;
	}
	public void setAirplaneID(Integer airplaneID) {
		this.airplaneID = airplaneID;
	}

	// airplaneTypeID
	public Integer getAirplaneTypeID() {
		return airplaneTypeID;
	}
	public void setAirplaneTypeID(Integer airplaneTypeID) {
		this.airplaneTypeID = airplaneTypeID;
	}
	
	// airplaneFlights
	public List<Flight> getAirplaneFlights() {
		return airplaneFlights;
	}
	public void setAirplaneFlights(List<Flight> airplaneFlights) {
		this.airplaneFlights = airplaneFlights;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneID == null) ? 0 : airplaneID.hashCode());
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
		Airplane other = (Airplane) obj;
		if (airplaneID == null) {
			if (other.airplaneID != null)
				return false;
		} else if (!airplaneID.equals(other.airplaneID))
			return false;
		return true;
	}
	

}
