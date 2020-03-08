package model;

import java.io.Serializable;

import utilities.UserType;

public class User implements Serializable{
	
	private UserType userType;
	private String username;
	//TODO dodati i workspace,tj filepath za ucitavanje
	
	public User(UserType userType, String username) {
		this.userType = userType;
		this.username = username;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userType=" + userType + ", username=" + username + "]";
	}

}
