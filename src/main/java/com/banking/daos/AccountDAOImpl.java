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
import com.banking.models.AccountType;
import com.banking.models.User;
import com.banking.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	private static AccountStatusDAO aSDao = new AccountStatusDAOImpl();
	private static AccountTypeDAO aTDao = new AccountTypeDAOImpl();
	@Override
	public List<Account> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM Account;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Account> list = new ArrayList<>();
			
			while (result.next()) {
				Account account = new Account(
				result.getInt("accountid"), 
				result.getDouble("balance"), 
				null,
				null
				); 
				String aStatus = result.getString("account_status");
				String aType = result.getString("account_type");
				if(aStatus != null) {
					account.setStatus(aSDao.findById(aStatus));
					account.setType(aTDao.findById(aType));
				}
				list.add(account);
				
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM account WHERE accountid = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			
			Account account = new Account();
			
			while (result.next()) {
				account.setAccountId(result.getInt("accountid"));
				account.setBalance(result.getDouble("balance"));
				
			}
			
			return account;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO account (accountid, balance)"
					+ "VALUES(?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setLong(++index, a.getAccountId());
			statement.setDouble(++index, a.getBalance());
			
			statement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	@Override
	public List<Account> findByAccountStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccountWithStatus(Account status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> findByAccountType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccountWithType(Account type) {
		// TODO Auto-generated method stub
		return false;
	}



}
