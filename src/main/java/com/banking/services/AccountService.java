package com.banking.services;

import java.util.List;

import com.banking.daos.AccountDAO;
import com.banking.daos.AccountDAOImpl;
import com.banking.models.Account;

public class AccountService {
	
	private AccountDAO aDao = new AccountDAOImpl();
	
	public List<Account> getAllAccount() {
		
		return aDao.findAll();
		
	}
	
	public Account findAccountById(int id) {
		return aDao.findById(id);
	}
	
	public boolean addAccount(Account account) {
		if(-1 ==(account.getAccountId())) {
			return false;
		}else {
			return aDao.addAccount(account);
		}
	}
	
	public double deposit(double amount, double balance) {
		return aDao.deposit(amount, balance);
	}

}
