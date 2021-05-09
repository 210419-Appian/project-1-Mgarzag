package com.banking.daos;

import com.banking.models.AccountStatus;

public interface AccountStatusDAO {
		
		public boolean addAccountStatus(AccountStatus a);
		public boolean updateAccountStatus(AccountStatus a);
		AccountStatus findById(int id);


}
