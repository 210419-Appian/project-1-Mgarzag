package com.banking.models;

public class AccountType extends Account {
	private int typeId; // primary key
	  private String type; // not null, unique
	  
	  public AccountType() {
		  super();
	  }
	  
	  public AccountType(int typeId, String type) {
		  this.typeId = typeId;
		  this.type = type;
		  
	  }
	  
	  public int getTypeId() {
		  return typeId;
	  }
	  
	  public void setTypeId(int typeId) {
		  this.typeId = typeId;
	  }
	  
	  public String getType() {
		  return type;
	  }
	  
	  public void setType(String type) {
		  this.type = type;
	  }

}
