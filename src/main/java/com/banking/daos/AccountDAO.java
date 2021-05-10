package com.banking.daos;

import java.util.List;

import com.banking.models.Account;
import com.banking.models.User;

public interface AccountDAO {
	
	public List<Account> findAll();
	public Account findById(int id);
	public boolean addAccount(Account a);
	public List<Account> findByAccountStatus(String status);
	public boolean addAccountWithStatus(Account status);
	public boolean update(Account a, User u);
	public int getUserId(Account user);
	public double withdraw(double amount);
	public double transferFunds(double amount);
	boolean deposit(int accountid, double balance);
	

}
