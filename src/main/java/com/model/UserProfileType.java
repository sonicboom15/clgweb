package com.model;

public enum UserProfileType{
	User("User"),
	Student("Student"),
	Admin("Admin"),
	Staff("Staff");
	
	String userProfileType;
	private UserProfileType(String userProfileType){
		this.userProfileType=userProfileType;
	}
	public String getUserProfileType() {
		return userProfileType;
	}
}