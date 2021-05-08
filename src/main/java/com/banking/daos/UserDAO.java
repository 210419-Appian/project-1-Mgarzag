package com.banking.daos;

import java.util.List;

import com.banking.models.User;

public interface UserDAO {
	
	public List<User> findAll();
	public User findById(String aUser);
	public boolean addUser(User u);
	public List<User> findByRole(String role);
	public boolean addUserWithRole(User user);
	public boolean updateUser(User user);
	User findById(int id);
	
}