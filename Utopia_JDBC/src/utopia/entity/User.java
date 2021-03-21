package utopia.entity;

import java.util.List;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/20/21
 * @LastEdited  3/20/21
 * @Description Assessment 2 Entity for user
 */

public class User {
	
	private Integer userID;						// primary key, id
	private UserRole userRoleID;				// foreign key on user_role, role_id to id
	
	private String userGivenName;				// given_name
	private String userFamilyName;				// family_name
	private String userUsername;				// username
	private String userEmail;					// email
	private String userPassword;				// password
	private String userPhone;					// phone
	
	List<BookingAgent> userBookingAgents;
	List<BookingUser>  userBookingUser;
	
	// -------------------- Get/Set --------------------
	// ID
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	//roleID
	public UserRole getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(UserRole userRoleID) {
		this.userRoleID = userRoleID;
	}
	
	// Given Name
	public String getUserGivenName() {
		return userGivenName;
	}
	public void setUserGivenName(String userGivenName) {
		this.userGivenName = userGivenName;
	}
	
	// Family Name
	public String getUserFamilyName() {
		return userFamilyName;
	}
	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;
	}
	
	// Username
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	// Email
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	// Password
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	// Phone
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	// bookingAgents
	public List<BookingAgent> getUserBookingAgents() {
		return userBookingAgents;
	}
	public void setUserBookingAgents(List<BookingAgent> userBookingAgents) {
		this.userBookingAgents = userBookingAgents;
	}
	
	// bookingUsers
	public List<BookingUser> getUserBookingUser() {
		return userBookingUser;
	}
	public void setUserBookingUser(List<BookingUser> userBookingUser) {
		this.userBookingUser = userBookingUser;
	}
	
	// -------------------- HashCode on Primary Key --------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		User other = (User) obj;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
}
