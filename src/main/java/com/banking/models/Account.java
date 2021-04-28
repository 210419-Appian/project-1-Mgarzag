package com.banking.models;

public class Account {
	 private int accountId; // primary key
	 private double balance;  // not null
	 private AccountStatus status;
	 private AccountType type;
	 
	 //No args constructor
	 public Account() {
		 super();
		 this.accountId = 123;
		 this.balance = 60000.00;
	 }
	 
	 //Constructor
	 public Account(int AccountId, double Balance, AccountStatus Status, AccountType Type) {
		 accountId = AccountId;
		 balance = Balance;
		 status = Status;
		 type = Type;
	 }
	 
	 public int getAccountId() {
		  return accountId;
	  }
	 
	 public void setAccountId(int accountId) {
		  this.accountId = accountId;
	  }
	 
	 public double getBalance() {
		 return balance;
	 }
	 
	 public void setBalance(double balance) {
		 this.balance = balance;
	 }
	 
	 private AccountStatus getAccountStatus() {
		 return status;
	 }
	 
	 private void setAccountStatus(AccountStatus status) {
		 this.status = status;
	 }
	 
	 private AccountType getAccountType() {
		 return type;
	 }
	 
	 private void setAccountType(AccountType type) {
		 this.type = type;
	 }
	 
	 

}
