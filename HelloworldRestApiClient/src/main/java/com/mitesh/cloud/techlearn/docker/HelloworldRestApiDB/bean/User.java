package com.mitesh.cloud.techlearn.docker.HelloworldRestApiDB.bean;

public class User {

	
	private int userId;
	private String userName;
	private String userCity;;
	
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public User() {
		
	}
	public User(int userId, String userName, String userCity) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCity = userCity;
	}
	
	
	
}
