package com.banking.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.models.User;
import com.banking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegisterServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		//The request object has a built in method to return an object that can read the body line by line
		BufferedReader reader = req.getReader();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			//advance to the next line
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		//The above is all so that the object mapper can easily read the body
		
		//Jackson will convert the json that is in the body to a java object we tell it to.
		User u = om.readValue(body, User.class);
		
		if (uService.addUser(u)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(400);
		}
		
	}

}
