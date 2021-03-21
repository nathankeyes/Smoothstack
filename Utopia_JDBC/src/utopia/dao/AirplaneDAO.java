package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airplane;
import utopia.entity.AirplaneType;


/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 I/O for airplane
 */

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		
		Airplane a = new Airplane();
		AirplaneType at = new AirplaneType();
		
		while (rs.next()) {	
			a.setAirplaneID(rs.getInt("id"));
			
			at.setAirplaneTypeID(rs.getInt("type_id"));
			a.setAirplaneTypeID(at);
		
			airplanes.add(a);
		}
		
		at.setAirplaneTypes(airplanes);					// not sure if i need this, but whatevs
		
		return airplanes;
	}

}
