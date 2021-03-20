package utopia.entity;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod
 */

public class Route {
	
	private Integer routeID;
	
	//since this is a foreign key for airport
	private Airport originAirport;
	private Airport destAirport;
	
	// -------------------- Get/Set --------------------
	public Integer getRouteID() {
		return routeID;
	}
	public void setRouteID(Integer routeID) {
		this.routeID = routeID;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestAirport() {
		return destAirport;
	}
	public void setDestAirport(Airport destAirport) {
		this.destAirport = destAirport;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeID == null) ? 0 : routeID.hashCode());
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
		Route other = (Route) obj;
		if (routeID == null) {
			if (other.routeID != null)
				return false;
		} else if (!routeID.equals(other.routeID))
			return false;
		return true;
	}
	
	
	
}
