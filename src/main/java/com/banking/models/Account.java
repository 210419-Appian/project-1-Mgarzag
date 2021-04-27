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

}
