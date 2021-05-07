package com.banking.servlets;

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

public class AdministrativeServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		//Gets users from the db
		List<User> list = uService.getAllUser();
		
		//Converts Java object into a JSOn string that can be written to the body of an HTTP response
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
		resp.setContentType("application/json");
		
	}

}
