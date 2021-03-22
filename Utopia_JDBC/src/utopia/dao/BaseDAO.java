package utopia.dao;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 example code from Pramod
 */

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet; 

public abstract class BaseDAO<T> {
	
	protected Connection conn = null;
	
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}
	
	// for when you want something to be returned, i.e. auto generated key from SQL (auto-increment)
	public Integer saveReturnPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
	
		pstmt.executeUpdate();
		
		// anything that comes out of database goes into result set
		// ResultSet rs = pstmt.getGeneratedKeys();				// try
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			return rs.getInt(1); // try 0 too
		}
		
		return null;
	}
	
	// for if you just want to save, without anything returning
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
	
		pstmt.executeUpdate();
	}
	
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		
		
		if ( vals != null ) {
			for (Object o : vals) {
				pstmt.setObject(count, o);
				count++;
			}
		}	
	
		ResultSet rs = pstmt.executeQuery();
		
		return extractData(rs);
	}
	
	abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;

}
