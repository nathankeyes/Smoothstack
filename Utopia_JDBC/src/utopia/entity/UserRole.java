package utopia.entity;

import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 Entity for user_role
 */

public class UserRole {
	
	private Integer userRoleID;					// primary key, id
	private String  UserRoleName;				// name
	
	// since it has a many to one relationship with Route, it can have a list of Route's
	private List<User> users;
	
	// -------------------- Get/Set --------------------
	// ID
	public Integer getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(Integer userRoleID) {
		this.userRoleID = userRoleID;
	}
	
	// name
	public String getUserRoleName() {
		return UserRoleName;
	}
	public void setUserRoleName(String userRoleName) { 
		UserRoleName = userRoleName; 
	}
	
	// users
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRoleID == null) ? 0 : userRoleID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (userRoleID == null) {
			if (other.userRoleID != null)
				return false;
		} else if (!userRoleID.equals(other.userRoleID))
			return false;
		return true;
	}
}
