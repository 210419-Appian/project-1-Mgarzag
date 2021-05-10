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
	private static UserDAO uDao = new UserDAOImpl();
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
				null,
				null
				); 
				int aStatusId = result.getInt("account_status");
				int aTypeId = result.getInt("account_type");
				int aUserId = result.getInt("user");
				if(aStatusId != 0) {
					account.setStatus(aSDao.findById(aStatusId));
					account.setType(aTDao.findById(aTypeId));
					account.setUser(uDao.findById(aUserId));
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
			
			String sql = "INSERT INTO account (accountid, balance, status, type, \"user\")"
					+ "VALUES(?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setLong(++index, a.getAccountId());
			statement.setDouble(++index, a.getBalance());
			if(a.getStatus() != null) {
				statement.setLong(++index, a.getStatus().getStatusId());	
			} else {
				statement.setNull(++index, java.sql.Types.INTEGER);
			}
			if(a.getType() != null) {
				statement.setLong(++index, a.getType().getTypeId());
			} else {
				statement.setNull(++index, java.sql.Types.INTEGER);
			}
			if(a.getUser() != null) {
				statement.setLong(++index, a.getUser().getUserId());
			} else {
				statement.setNull(++index, java.sql.Types.INTEGER);
			}
			
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
	public boolean update(Account a, User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserId(Account user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean deposit(int accountid, double balance) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE account SET balance = '" + balance + "'where accountid'" + accountid + "'";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, balance);
			statement.setInt(++index, accountid);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transferFunds(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}




}
