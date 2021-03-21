package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		return null;
	}

}
