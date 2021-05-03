package com.banking.daos;

import java.util.List;

import com.banking.models.AccountStatus;
import com.banking.models.AccountType;

public interface AccountTypeDAO {
	
	public List <AccountType> findAll();
	public AccountType findById(int id);
	public boolean addAccountType(AccountType accounttype);

}
