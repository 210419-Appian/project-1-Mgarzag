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
	public boolean addAccountStatus(AccountStatus a) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO account_status (statusid, status)"
					+ "VALUES(?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setLong(++index, a.getStatusId());
			statement.setString(++index, a.getStatus());
			
			statement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}


	@Override
	public boolean updateAccountStatus(AccountStatus a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccountStatus findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM account_status WHERE statusid = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			
			AccountStatus aStatus1 = new AccountStatus();
			
			while (result.next()) {
				aStatus1.setStatusId(result.getInt("statusid"));
				aStatus1.setStatus(result.getString("status"));
			}
			
			return aStatus1;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
