package com.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking.models.Role;
import com.banking.utils.ConnectionUtil;

public class RoleDAOImpl implements RoleDAO {

	@Override
	public List<Role> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM role;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Role> list = new ArrayList<>();
			
			while (result.next()) {
				Role role = new Role();
				role.setRoleId(result.getInt("roleid"));
				role.setRole(result.getString("role"));
				
				list.add(role);
			}
			
			return list;
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM role WHERE roleid = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			Role role = new Role();
			
			while (result.next()) {
				role.setRoleId(result.getInt("roleid"));
				role.setRole(result.getString("role"));
			}
			
			return role;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}



}
