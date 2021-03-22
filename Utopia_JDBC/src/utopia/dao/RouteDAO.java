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
	
	// ------------------------- functions for table  -------------------------
	public void addRoute(Route route) throws ClassNotFoundException, SQLException {
		save("INSERT INTO route VALUES (?,?,?)", new Object[] {route.getRouteID(), route.getOriginAirport(), route.getDestAirport()});
	}
	
	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("UPDATE route SET origin_id = ?,  destination_id = ? WHERE id = ?", new Object[] {route.getOriginAirport(), route.getDestAirport(), route.getRouteID()});
	}
	
	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException{
		save("DELETE FROM route WHERE id = ?", new Object[] {route.getRouteID()});
	}
	
	public List<Route> readAllRoutes(Route route) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route", null);
	}
	
	public List<Route> readAllRoutesByCode(Route route) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM route WHERE id = ", new Object[] {route.getRouteID()});
	}
	
	public List<Route> test() throws ClassNotFoundException, SQLException {
		return read("SELECT id, origin_id, destination_id, a1.city AS org_city, a2.city AS dest_city "
				+ "FROM route LEFT JOIN airport a1 on origin_id = a1.iata_id LEFT JOIN airport a2 ON destination_id = a2.iata_id", null);
	}
	
	

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		//Airport a2 = new Airport();
		
		while (rs.next()) {
			Route   r = new Route();
			r.setRouteID(rs.getInt("id"));
		
			Airport a1 = new Airport();
			Airport a2 = new Airport();
			
			a1.setAirportCode(rs.getString("origin_id"));
			r.setOriginAirport(a1);
			//System.out.print(rs.getString("origin_id") + "     ");
			
			a2.setAirportCode(rs.getString("destination_id"));
			r.setDestAirport(a2);
			//System.out.println(rs.getString("destination_id"));
		
			routes.add(r);
		}
		
		//a2.setRoutes(routes);				// not working
		
		return routes;
	}
	
//	@Override
//	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
//		List<Route> routes = new ArrayList<>();
//		
//		while (rs.next()) {
//			Route   r = new Route();
//			r.setRouteID(rs.getInt("id"));
//		
//			Airport a1 = new Airport();
//			Airport a2 = new Airport();
//			
//			a1.setAirportCode(rs.getString("origin_id"));
//			a1.setCity(rs.getString("org_city"));
//			r.setOriginAirport(a1);
//			//System.out.print(rs.getString("origin_id") + "     ");
//			
//			a2.setAirportCode(rs.getString("destination_id"));
//			a2.setCity(rs.getString("dest_city"));
//			r.setDestAirport(a2);
//			//System.out.println(rs.getString("destination_id"));
//			
//			routes.add(r);
//		}
//		
//		//a.setRoutes(routes);				// not sure if i need this, but whatevs
//		return routes;
//	}

}
