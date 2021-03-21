package utopia.entity;

import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod, airplane_type table
 */

public class AirplaneType {
	
	private Integer airplaneTypeID;			//id
	private Integer maxCapacity;			//max_capacity
	
	// since it has a many to one relationship with airplane, it can have a list of airplaneTypes
	private List<Airplane> airplaneTypes;
	
	
	// -------------------- Get/Set --------------------
	// airplaneTypeID
	public Integer getAirplaneTypeID() {
		return airplaneTypeID;
	}
	public void setAirplaneTypeID(Integer airplaneTypeID) {
		this.airplaneTypeID = airplaneTypeID;
	}
	
	// maxCapacity
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	// airplaneTypes
	public List<Airplane> getAirplaneTypes() {
		return airplaneTypes;
	}
	public void setAirplaneTypes(List<Airplane> airplaneTypes) {
		this.airplaneTypes = airplaneTypes;
	}

	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneTypeID == null) ? 0 : airplaneTypeID.hashCode());
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
		AirplaneType other = (AirplaneType) obj;
		if (airplaneTypeID == null) {
			if (other.airplaneTypeID != null)
				return false;
		} else if (!airplaneTypeID.equals(other.airplaneTypeID))
			return false;
		return true;
	}
	
}
