package com.banking.daos;

import java.util.List;

import com.banking.models.Role;

public interface RoleDAO {
	
	public List<Role> findAll();
	public Role findById(int id);
	public boolean addRole(Role role);

}
