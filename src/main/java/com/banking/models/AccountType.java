package com.banking.models;

public class AccountType extends Account {
	private int typeId; // primary key
	  private String type; // not null, unique
	  
	  public AccountType() {
		  super();
	  }
	  
	  public AccountType(int AccountId, double Balance, AccountStatus Status, AccountType Type, int typeId, String type) {
		  super(AccountId, Balance, Status, Type);
		  this.typeId = typeId;
		  this.type = type;
		  
	  }

}
