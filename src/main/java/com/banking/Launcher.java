package com.banking;

import java.util.List;

import com.banking.models.User;
import com.revature.services.UserService;

public class Launcher {
	
	private static UserService uService = new UserService();

	public static void main(String[] args) {
		List<User> list = uService.getAllUser();
		
		System.out.println(list);
		
		User u = uService.findUserById(0);
		
		User u2 = new User(1, "Mgarzag", "That90sGuy", "Marcel", "Garza", "marcel.garza09@gmail.com");
		
		uService.createUser(u2);
;		
		u = uService.findUserById(1);
		System.out.println(u);

	}

}
