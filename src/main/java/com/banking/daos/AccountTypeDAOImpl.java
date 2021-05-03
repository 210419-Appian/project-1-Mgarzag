package com.banking.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking.models.AccountStatus;
import com.banking.models.AccountType;
import com.banking.utils.ConnectionUtil;

public class AccountTypeDAOImpl implements AccountTypeDAO {

	@Override
	public List<AccountType> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM account_type;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<AccountType> list = new ArrayList<>();
			
			while (result.next()) {
				AccountType accounttype = new AccountType();
				accounttype.setTypeId(result.getInt("typeid"));
				accounttype.setType(result.getString("type"));
				
				list.add(accounttype);
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountType findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccountType(AccountType accounttype) {
		// TODO Auto-generated method stub
		return false;
	}

}
