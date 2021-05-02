package com.banking.daos;

import java.util.List;

import com.banking.models.User;

public interface UserDAO {
	
	public List<User> findAll();
	public User findById(int id);
	public boolean addUser(User user);
	//public boolean updateUser(User user);
}
