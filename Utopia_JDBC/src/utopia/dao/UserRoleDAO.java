package utopia.dao;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/21/21
 * @LastEdited  3/21/21
 * @Description Assessment 2 I/O for UserRole
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoles = new ArrayList<>();
		UserRole ur = new UserRole();
		
		while(rs.next()) {
			ur.setUserRoleID(rs.getInt("id"));
			ur.setUserRoleName(rs.getString("name"));
			
			userRoles.add(ur);
		}
		
		return userRoles;
	}

}
