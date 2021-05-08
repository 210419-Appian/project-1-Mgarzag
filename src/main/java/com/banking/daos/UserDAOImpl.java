package com.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking.models.User;
import com.banking.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static RoleDAO rDao = new RoleDAOImpl();

	@Override
	public List<User> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
		
			String sql = "SELECT * FROM \"user\";";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<User> list = new ArrayList<>();
			
			while (result.next()) {
				User user = new User(
				result.getInt("userid"),
				result.getString("username"),
				result.getString("password"),
				result.getString("firstname"),
				result.getString("lastname"),
				result.getString("email"),
				null
				);
			int rId = result.getInt("role");
			if(rId!=0) {
				user.setRole(rDao.findById(rId));
			}
				list.add(user);
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"user\" WHERE userid = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			
			User user = new User();
			
			while (result.next()) {
				user.setUserId(result.getInt("userid"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				user.setEmail(result.getString("email"));
				
			}
			
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO \"user\" (userid, username, password, firstname, lastname, email, role)"
					+ "VALUES(?,?,?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setLong(++index, user.getUserId());
			statement.setString(++index, user.getUsername());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
			if(user.getRole() != null) {
				statement.setLong(++index, user.getRole().getRoleId());	
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
	public List<User> findByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUserWithRole(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(String aUser) {
		// TODO Auto-generated method stub
		return null;
	}

}