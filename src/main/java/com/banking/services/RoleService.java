package com.banking.services;

import java.util.List;

import com.banking.daos.RoleDAO;
import com.banking.daos.RoleDAOImpl;
import com.banking.models.Role;

public class RoleService {
	
	private RoleDAO rDao = new RoleDAOImpl();
	
	public List<Role> getAllRole() {
		
		List<Role> list = rDao.findAll();
		
		return list;
	}
	
	public Role findRoleById(int id) {
		return rDao.findById(id);
	}
	
	public boolean createRole(Role role) {
		if(-1 ==(role.getRoleId())) {
			return false;
		}else {
			return rDao.addRole(role);
		}
	}

}
