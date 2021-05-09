package com.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.banking.models.AccountType;
import com.banking.utils.ConnectionUtil;

public class AccountTypeDAOImpl implements AccountTypeDAO {

	@Override
	public boolean addAccountType(AccountType a) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO account_type (typeid, type)"
					+ "VALUES(?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setLong(++index, a.getTypeId());
			statement.setString(++index, a.getType());
			
			statement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}

	@Override
	public AccountType findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM account_type WHERE typeid = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			
			AccountType aType = new AccountType();
			
			while (result.next()) {
				aType.setTypeId(result.getInt("typeid"));
				aType.setType(result.getString("type"));
			}
			
			return aType;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
