package utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utopia.entity.User;
import utopia.entity.UserRole;

public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		
		User          u = new User();
		UserRole     ur = new UserRole();

		while(rs.next()) {
			u.setUserID(rs.getInt("id"));
			
			ur.setUserRoleID(rs.getInt("role_id"));
			u.setUserRoleID(ur);
			
			u.setUserGivenName(rs.getString("given_name"));
			u.setUserFamilyName(rs.getString("family_name"));
			u.setUserUsername(rs.getString("username"));
			u.setUserEmail(rs.getString("email"));
			u.setUserPassword(rs.getString("password"));
			u.setUserPhone(rs.getString("phone"));
			
			users.add(u);
		}
		
		ur.setUsers(users);
		
		return users;
	}

}
