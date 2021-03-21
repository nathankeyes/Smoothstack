package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.Airport;
import utopia.entity.Route;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod
 */

public class RouteDAO extends BaseDAO<Route>{

	public RouteDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		Route r = new Route();
		Airport a = new Airport();
		
		while (rs.next()) {
			r.setRouteID(rs.getInt("id"));
			
			a.setAirportCode(rs.getString("origin_id"));
			r.setOriginAirport(a);
			
			a.setAirportCode(rs.getString("destination_id"));
			r.setDestAirport(a);
		
			
			routes.add(r);
		}
		
		a.setRoutes(routes);				// not sure if i need this, but whatevs
		return routes;
	}

}
