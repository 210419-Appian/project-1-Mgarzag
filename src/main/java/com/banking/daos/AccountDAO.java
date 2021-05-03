package com.banking.daos;

import java.util.List;

import com.banking.models.Account;

public interface AccountDAO {
	
	public List<Account> findAll();
	public Account findById(int id);
	public boolean addAccount(Account a);
	public List<Account> findByAccountStatus(String status);
	public boolean addAccountWithStatus(Account a);

}
