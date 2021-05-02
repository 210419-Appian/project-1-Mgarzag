package com.revature.services;

import java.util.List;

import com.banking.daos.UserDAO;
import com.banking.daos.UserDAOImpl;
import com.banking.models.User;

public class UserService {
	
	private UserDAO uDao = new UserDAOImpl();
	
	public List<User> getAllUser() {
		
		List<User> list = uDao.findAll();
		
		//any business logic that would need to take place can happen here.
		
		return list;
		
	}
	
	public User findUserById(int id) {
		return uDao.findById(id);
	}
	
	public boolean createUser(User user) {
		if(0 ==(user.getUserId())) {
			return false;
		}else {
			return uDao.addUser(user);
		}
	}

}
