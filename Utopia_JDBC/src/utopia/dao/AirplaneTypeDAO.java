package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.AirplaneType;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 I/O for airplane_type
 */

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> AirplaneTypes = new ArrayList<>();
		
		while(rs.next()) {
			AirplaneType at = new AirplaneType();
			
			at.setAirplaneTypeID(rs.getInt("id"));
			at.setMaxCapacity(rs.getInt("max_capacity"));
			
			AirplaneTypes.add(at);
		}
		return AirplaneTypes;
	}

}
