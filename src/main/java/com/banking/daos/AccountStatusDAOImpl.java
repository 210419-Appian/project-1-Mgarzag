package com.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking.models.Account;
import com.banking.models.AccountStatus;
import com.banking.models.Role;
import com.banking.models.User;
import com.banking.utils.ConnectionUtil;

public class AccountStatusDAOImpl implements AccountStatusDAO {

	@Override
	public List<AccountStatus> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM account_status;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<AccountStatus> list = new ArrayList<>();
			
			while (result.next()) {
				AccountStatus accountstatus = new AccountStatus();
				accountstatus.setStatusId(result.getInt("statusid"));
				accountstatus.setStatus(result.getString("status"));
				
				list.add(accountstatus);
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountStatus findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM account_status WHERE statusid = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			
			AccountStatus accountstatus = new AccountStatus();
			
			while (result.next()) {
				accountstatus.setStatusId(result.getInt("statusid"));
				accountstatus.setStatus(result.getString("status"));
				
			}
			
			return accountstatus;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccountStatus(AccountStatus a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAccountStatus(AccountStatus a) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
