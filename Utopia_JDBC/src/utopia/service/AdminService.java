package utopia.service;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod handle exceptions here
 */

import java.sql.Connection;
import java.sql.SQLException;

import utopia.dao.AirplaneDAO;
import utopia.dao.AirportDAO;
import utopia.dao.FlightDAO;
import utopia.dao.RouteDAO;

public class AdminService {
	
	Util util = new Util();
	
	public String addFlight() throws SQLException{
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			AirportDAO  aDAO = new AirportDAO(conn);
			//RouteDAO    rDAO = new RouteDAO(conn);
			//FlightDAO   fDAO =  new FlightDAO(conn);
			//AirplaneDAO apDAO = new AirplaneDAO(conn);
			
			
			
			conn.commit();
			return "Flight added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Flight rolledback";
		}
		finally {
			if (conn!=null) {
				conn.close();
			}
		}
	}
	
	public String updateFlight() throws SQLException{
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			// flightDAO pass same conn
			// airplane dao pass same conn
			
			
			//conn.commit();
			return "Flight added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Flight rolledback";
		}
		finally {
			if (conn!=null) {
				conn.close();
			}
		}
	}
	
	public String deleteFlight() throws SQLException{
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			// flightDAO pass same conn
			// airplane dao pass same conn
			
			
			//conn.commit();
			return "Flight added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Flight rolledback";
		}
		finally {
			if (conn!=null) {
				conn.close();
			}
		}
	}
	
	public String readFlights() throws SQLException{
		Connection conn = null;
		
		// transaction handling
		try {
			conn = util.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			// flightDAO pass same conn
			// airplane dao pass same conn
			
			
			//conn.commit();
			return "Flight added successfully";
		}
		catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Flight rolledback";
		}
		finally {
			if (conn!=null) {
				conn.close();
			}
		}
	}
	

}
