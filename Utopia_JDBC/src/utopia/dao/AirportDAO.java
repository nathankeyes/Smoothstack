package utopia.dao;


import utopia.entity.Airport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod
 */

public class AirportDAO extends BaseDAO<Airport>{
	
	public AirportDAO(Connection conn) {
		super(conn);
	}


	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airport VALUES (?,?)", new Object[] {airport.getAirportCode(), airport.getCity()});
	}
	
	
	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("UPDATE airport SET city = ? WHERE iata_id = ?", new Object[] {airport.getCity(), airport.getAirportCode()});
	}
	
	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException{
		save("DELETE FROM airport WHERE iata_id = ?", new Object[] {airport.getAirportCode()});
	}
	
	public List<Airport> readAllAirports(Airport airport) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airport", null);
	}
	
	public List<Airport> readAllAirportsByCode(Airport airport) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM airport WHERE iata_id = ", new Object[] {airport.getAirportCode()});
	}
	
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		
		while (rs.next()) {
			Airport a = new Airport();
			a.setAirportCode(rs.getString("iata_id"));
			a.setCity(rs.getString("city"));
			
			airports.add(a);
		}
		
		return airports;
	}

}
