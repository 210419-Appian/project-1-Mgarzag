package com.banking.models;

public class User {
	  private int userId; // primary key
	  private String username; // not null, unique
	  private String password; // not null
	  private String firstName; // not null
	  private String lastName; // not null
	  private String email; // not null
	  private Role role;
	  
	  //No args constructor
	  public User() {
		  super();
		  this.username = "Mgarzag";
		  this.password = "90sKid";
		  this.firstName = "Marcel";
		  this.lastName = "Garza";
		  this.email = "marcel.garza09@gmail.com";
		  
	  }
	  
	  //Constructor
	  public User(int newUserId, String newUser) {
		  this.userId = newUserId;
		  this.username = newUser;
	  }
	  
	  public User(String newUser, int newUserId, String newPassword, String firstName, String lastName, String newEmail, Role role) {
		  this(newUserId, newUser);
		  this.password = newPassword;
		  this.firstName = firstName;
		  this.lastName = lastName;
		  this.email = newEmail;
		  this.role = role;
	  }
	  

}
