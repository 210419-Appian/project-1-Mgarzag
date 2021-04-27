package com.banking.models;

public class AccountStatus extends Account {
	private int statusId; // primary key
	  private String status; // not null, unique
	  
	  public AccountStatus() {
		 super(); 
	  }
	  
	  public AccountStatus(int AccountId, double Balance, AccountStatus Status, AccountType Type, int statusId, String status) {
		  super(AccountId, Balance, Status, Type);
		  this.statusId = statusId;
		  this.status = status;
	  }

}
