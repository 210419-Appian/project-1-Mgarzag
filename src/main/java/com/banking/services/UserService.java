package com.banking.services;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.banking.daos.UserDAO;
import com.banking.daos.UserDAOImpl;
import com.banking.models.User;

public class UserService {
	
	private UserDAO uDao = new UserDAOImpl();
	
	public List<User> getAllUser() {
		
		List<User> list = uDao.findAll();
		
		return list;
		
	}
	
	public User findUserById(int id) {
		return uDao.findById(id);
	}
	
	public boolean addUser(User u) {
		return uDao.addUser(u);
	}
	
	public boolean checkLogin(User u) {
		User user = uDao.findById(u.getUsername());
		System.out.println(user.toString());
		
		if((user.getPassword() != null && (u.getPassword().equals(user.getPassword())))) {
			return true;
		}
		return false;
	}

}
