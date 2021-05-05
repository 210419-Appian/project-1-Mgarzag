package com.banking.daos;

import java.util.List;

import com.banking.models.Account;
import com.banking.models.AccountStatus;

public interface AccountStatusDAO {
		
		public boolean addAccountStatus(AccountStatus a);
		public boolean updateAccountStatus(AccountStatus a);
		public AccountStatus findById(String aStatus);


}
