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
	
	public boolean createAccount(Account account) {
		if(0 ==(account.getAccountId())) {
			return false;
		}else {
			return aDao.addAccount(account);
		}
	}

}
