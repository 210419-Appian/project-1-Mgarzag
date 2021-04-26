package com.banking.models;

public class User {
	  private int userId; // primary key
	  private String username; // not null, unique
	  private String password; // not null
	  private String firstName; // not null
	  private String lastName; // not null
	  private String email; // not null
	  private Role role;
	  
	  //Constructor
	  public User(int newUserId, String newUser) {
		  this.userId = newUserId;
		  this.username = newUser;
	  }

}
